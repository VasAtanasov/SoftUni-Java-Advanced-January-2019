package L09StreamsFilesDirectories;

import java.io.*;

public class Ex01ReadFile {
    private static final String INPUT_TXT = "/L09StreamsFilesDirectories/files/input/input.txt";

    public static void main(String[] args) throws IOException {
        System.out.println(readFile(INPUT_TXT));
    }

    private static String readFile(String filePath) throws IOException {
        String path = System.getProperty("user.dir") + "/resources/" + filePath;
        StringBuilder sb = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                sb.append(String.format("%s ", Integer.toBinaryString(oneByte)));
                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString().trim();
    }
}
