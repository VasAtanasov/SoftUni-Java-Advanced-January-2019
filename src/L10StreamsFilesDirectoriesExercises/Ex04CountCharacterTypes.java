package L10StreamsFilesDirectoriesExercises;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Ex04CountCharacterTypes {
    private static final String INPUT_TXT = "/L10StreamsFilesDirectoriesExercises/files/input.txt";
    private static final String OUTPUT_TXT = "/L10StreamsFilesDirectoriesExercises/files/output.txt";
    private static final List<String> VOWELS = Arrays.asList("a", "e", "i", "o", "u");
    private static final List<String> PUNCTUATIONS = Arrays.asList("!", ",", ".", "?");

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
            int vowelsCount = 0;
            int consonantsCount = 0;
            int punctuationCount = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.replaceAll("\\s+", "").split("");
                for (String token : tokens) {
                    if (VOWELS.contains(token)) {
                        vowelsCount += 1;
                    } else if (PUNCTUATIONS.contains(token)) {
                        punctuationCount += 1;
                    } else {
                        consonantsCount += 1;
                    }
                }
            }

            out.write(String.format("Vowels: %d\n",vowelsCount));
            out.write(String.format("Consonants: %d\n",consonantsCount));
            out.write(String.format("Punctuation: %d",punctuationCount));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
