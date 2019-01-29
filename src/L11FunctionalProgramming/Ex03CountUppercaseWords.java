package L11FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Ex03CountUppercaseWords {
    private static BufferedReader reader;
    private static List<String> output;
    private static int count;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        output = new ArrayList<>();
        count = 0;
    }

    public static void main(String[] args) throws IOException {
        String[] words = Arrays.stream(reader.readLine().split("\\s"))
                .filter(s -> ! s.isEmpty())
                .toArray(String[]::new);

        for (String word : words) {
            if (isUppercase.test(word)) {
                output.add(word);
                count++;
            }
        }

        if (count > 0) {
            System.out.println(count);
            output.forEach(System.out::println);

        }
    }

    private static Predicate<String> isUppercase = word -> word.charAt(0) == word.toUpperCase().charAt(0);
}


