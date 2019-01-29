package L10StreamsFilesDirectoriesExercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex08GetFolderSize {
    private static final String INPUT_ONE_TXT = "/L10StreamsFilesDirectoriesExercises/files";

    public static void main(String[] args) throws IOException {
        String filesPath = System.getProperty("user.dir") + "/resources/" + INPUT_ONE_TXT;

        Path folder = Paths.get(filesPath);
        long size = Files.walk(folder)
                .filter(p -> p.toFile().isFile())
                .filter(p -> !p.toFile().getName().equals("output.txt"))
                .filter(p -> !p.toFile().getName().equals("result.txt"))
                .mapToLong(p -> p.toFile().length())
                .sum();

        System.out.println(String.format("Folder size: %d", size));

    }
}
