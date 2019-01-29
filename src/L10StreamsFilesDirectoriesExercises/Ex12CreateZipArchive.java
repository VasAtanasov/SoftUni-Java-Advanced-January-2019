package L10StreamsFilesDirectoriesExercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Ex12CreateZipArchive {
    private static final String TXT_FILE_ONE = "/L10StreamsFilesDirectoriesExercises/files/input.txt";
    private static final String TXT_FILE_TWO = "/L10StreamsFilesDirectoriesExercises/files/inputLineNumbers.txt";
    private static final String TXT_FILE_THREE = "/L10StreamsFilesDirectoriesExercises/files/inputOne.txt";
    private static final String OUTPUT_ZIP = "/L10StreamsFilesDirectoriesExercises/otherFiles/files.zip";

    public static void main(String[] args) throws IOException {
        List<String> srcFiles = new ArrayList<>() {{
            add(System.getProperty("user.dir") + "/resources/" + TXT_FILE_ONE);
            add(System.getProperty("user.dir") + "/resources/" + TXT_FILE_TWO);
            add(System.getProperty("user.dir") + "/resources/" + TXT_FILE_THREE);
        }};

        String outputFilePath = System.getProperty("user.dir") + "/resources/" + OUTPUT_ZIP;

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(outputFilePath))) {
            for (String srcFile : srcFiles) {
                File fileToZip = new File(srcFile);
                FileInputStream fis = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);

                byte[] bytes = new byte[1024];
                int length;
                while ((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
                fis.close();
            }
        }
    }
}
