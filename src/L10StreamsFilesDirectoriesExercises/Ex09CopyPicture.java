package L10StreamsFilesDirectoriesExercises;

import java.io.*;

public class Ex09CopyPicture {
    private static final String IMAGE_IN = "/L10StreamsFilesDirectoriesExercises/media/image1.png";
    private static final String IMAGE_OUT = "/L10StreamsFilesDirectoriesExercises/otherFiles/copy-image1.png";


    public static void main(String[] args) {
        String imageInPath = System.getProperty("user.dir") + "/resources/" + IMAGE_IN;
        String imageOutPath = System.getProperty("user.dir") + "/resources/" + IMAGE_OUT;
        try (
                FileInputStream reader = new FileInputStream(new File(imageInPath));
                FileOutputStream fileOutputStream = new FileOutputStream(imageOutPath)
        ) {
            byte[] buffer = reader.readAllBytes();
            fileOutputStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

