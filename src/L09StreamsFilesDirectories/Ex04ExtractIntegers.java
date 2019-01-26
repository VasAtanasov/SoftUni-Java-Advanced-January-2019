package L09StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ex04ExtractIntegers {
    private static final String INPUT_TXT = "/L09StreamsFilesDirectories/files/input/input.txt";

    public static void main(String[] args) {
        readFile(INPUT_TXT);
    }

    private static void readFile(String fileIn) {
        String path = System.getProperty("user.dir") + "/resources/" + fileIn;
        try (
                FileInputStream fileInputStream = new FileInputStream(path);
                Scanner scanner = new Scanner(fileInputStream)
        ) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.println(scanner.nextInt());
                }
                scanner.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
