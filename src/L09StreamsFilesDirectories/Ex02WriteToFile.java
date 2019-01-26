package L09StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Ex02WriteToFile {
    private static final String INPUT_TXT = "/L09StreamsFilesDirectories/files/input/input.txt";
    private static final String OUTPUT_TXT = "/L09StreamsFilesDirectories/files/output/02.WriteToFileOutput.txt";

    private static final List<Character> punctuation = Arrays.asList(',', '.', '!', '?');

    public static void main(String[] args) throws IOException {
        readFile(INPUT_TXT,OUTPUT_TXT);
    }

    private static void readFile(String fileIn, String fileOut) throws IOException {
        String path = System.getProperty("user.dir") + "/resources/" + fileIn;
        String outPath = System.getProperty("user.dir") + "/resources/" + fileOut;
        try (
                FileInputStream fileInputStream = new FileInputStream(path);
                FileOutputStream fileOutputStream = new FileOutputStream(outPath)
        ) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                if (! punctuation.contains((char) oneByte)) {
                    fileOutputStream.write(oneByte);
                }
                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
