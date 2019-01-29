package L10StreamsFilesDirectoriesExercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ex01SumLines {
    private static final String INPUT_TXT = "/L10StreamsFilesDirectoriesExercises/files/input.txt";

    public static void main(String[] args) {
        List<Integer> fileLinesSums = sumFileLines();

        fileLinesSums.forEach(System.out::println);
    }

    private static List<Integer> sumFileLines() {
        String path = System.getProperty("user.dir") + "/resources/" + INPUT_TXT;
        List<Integer> lines = new ArrayList<>();
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
                lines.add(
                        IntStream.range(0, line.length())
                                .map(line::charAt)
                                .sum()
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}
