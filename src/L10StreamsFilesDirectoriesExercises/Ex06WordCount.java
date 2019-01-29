package L10StreamsFilesDirectoriesExercises;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex06WordCount {
    private static final String WORDS_TXT = "/L10StreamsFilesDirectoriesExercises/files/words.txt";
    private static final String TEXT_TXT = "/L10StreamsFilesDirectoriesExercises/files/text.txt";
    private static final String OUTPUT_TXT = "/L10StreamsFilesDirectoriesExercises/files/result.txt";

    private static Map<String, Integer> words;

    static {
        words = new LinkedHashMap<>();
    }

    public static void main(String[] args) {
        String wordsPath = System.getProperty("user.dir") + "/resources/" + WORDS_TXT;
        String textPath = System.getProperty("user.dir") + "/resources/" + TEXT_TXT;
        String resultPath = System.getProperty("user.dir") + "/resources/" + OUTPUT_TXT;
        try (
                BufferedReader wordsReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(wordsPath)
                                )
                        )
                );
                BufferedReader textReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(textPath)
                                )
                        )
                );
                PrintWriter out = new PrintWriter(new FileWriter(resultPath))
        ) {
            String line;

            while ((line = wordsReader.readLine()) != null) {
                Arrays.stream(line.trim().split("\\s+")).forEach(word -> {
                    words.putIfAbsent(word, 0);
                });
            }


            while ((line = textReader.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                for (String word : tokens) {
                    if (words.containsKey(word)) {
                        words.put(word, words.get(word) + 1);
                    }
                }
            }

            words.entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(entry -> {
                        out.println(String.format("%s - %d", entry.getKey(), entry.getValue()));
                    });


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
