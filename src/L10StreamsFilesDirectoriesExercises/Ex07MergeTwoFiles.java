package L10StreamsFilesDirectoriesExercises;

import java.io.*;

public class Ex07MergeTwoFiles {
    private static final String INPUT_ONE_TXT = "/L10StreamsFilesDirectoriesExercises/files/inputOne.txt";
    private static final String INPUT_TWO_TXT = "/L10StreamsFilesDirectoriesExercises/files/inputTwo.txt";
    private static final String OUTPUT_TXT = "/L10StreamsFilesDirectoriesExercises/files/result.txt";

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        String inputOnePath = System.getProperty("user.dir") + "/resources/" + INPUT_ONE_TXT;
        String inputTwoPath = System.getProperty("user.dir") + "/resources/" + INPUT_TWO_TXT;
        String resultPath = System.getProperty("user.dir") + "/resources/" + OUTPUT_TXT;
        try (
                BufferedReader inputOneReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(inputOnePath)
                                )
                        )
                );
                BufferedReader inputTwoReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(inputTwoPath)
                                )
                        )
                );
                PrintWriter out = new PrintWriter(new FileWriter(resultPath))
        ) {
            String line;

            while ((line = inputOneReader.readLine()) != null) {
                out.println(line);
            }


            while ((line = inputTwoReader.readLine()) != null) {
                out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
