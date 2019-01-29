package L10StreamsFilesDirectoriesExercises;

import java.io.*;
import java.util.stream.IntStream;

public class Ex02SumBytes {
    private static final String INPUT_TXT = "/L10StreamsFilesDirectoriesExercises/files/input.txt";

    public static void main(String[] args) {
        System.out.println(sumFileCharacters());
    }

    private static long sumFileCharacters() {
        String path = System.getProperty("user.dir") + "/resources/" + INPUT_TXT;
        long sum = 0;
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(path)
                                )
                        )
                )
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sum += IntStream.range(0, line.length())
                        .map(line::charAt)
                        .sum();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sum;
    }
}
