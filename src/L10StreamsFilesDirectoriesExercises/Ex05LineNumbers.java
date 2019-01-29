package L10StreamsFilesDirectoriesExercises;

import java.io.*;

public class Ex05LineNumbers {
    private static final String INPUT_TXT = "/L10StreamsFilesDirectoriesExercises/files/inputLineNumbers.txt";
    private static final String OUTPUT_TXT = "/L10StreamsFilesDirectoriesExercises/files/output.txt";

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/resources/" + INPUT_TXT;
        String outPath = System.getProperty("user.dir") + "/resources/" + OUTPUT_TXT;
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(path)
                                )
                        )
                );
                PrintWriter out = new PrintWriter(new FileWriter(outPath))
        ) {
            int lineCount = 1;

            String line;
            while ((line = reader.readLine()) != null) {
                out.println(String.format("%d. %s", lineCount++, line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
