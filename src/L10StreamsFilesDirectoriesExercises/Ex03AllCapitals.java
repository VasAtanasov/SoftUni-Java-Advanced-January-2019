package L10StreamsFilesDirectoriesExercises;

import java.io.*;

public class Ex03AllCapitals {
    private static final String INPUT_TXT = "/L10StreamsFilesDirectoriesExercises/files/input.txt";
    private static final String OUTPUT_TXT = "/L10StreamsFilesDirectoriesExercises/files/output.txt";

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "/resources/" + INPUT_TXT;
        String outPath = System.getProperty("user.dir") + "/resources/" + OUTPUT_TXT;
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(path)
                                )
                        )
                );
                PrintWriter out = new PrintWriter(new FileWriter(outPath))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                out.println(line.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
