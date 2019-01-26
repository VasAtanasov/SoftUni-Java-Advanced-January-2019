package L09StreamsFilesDirectories;

import java.io.File;

public class Ex07ListFiles {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/resources/L09StreamsFilesDirectories/Files-and-Streams/";

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null) {
            return;
        }

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(String.format("%s: [%d]", file.getName(), file.length()));
            }
        }
    }
}
