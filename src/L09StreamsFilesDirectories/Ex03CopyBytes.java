package L09StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03CopyBytes {
    private static final String INPUT_TXT = "/L09StreamsFilesDirectories/files/input/input.txt";
    private static final String OUTPUT_TXT = "/L09StreamsFilesDirectories/files/output/03.CopyBytesOutput.txt";

    public static void main(String[] args) throws IOException {
        readFile(INPUT_TXT, OUTPUT_TXT);
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
                String digits = String.valueOf(oneByte);
                if (oneByte == 32) {
                    fileOutputStream.write(' ');
                } else if (oneByte == 10) {
                    fileOutputStream.write('\n');
                } else {
                    for (int i = 0; i < digits.length(); i++) {
                        fileOutputStream.write(digits.charAt(i));
                    }
                }
                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
