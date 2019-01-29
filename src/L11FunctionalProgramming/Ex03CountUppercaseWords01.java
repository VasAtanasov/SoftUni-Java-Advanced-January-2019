package L11FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex03CountUppercaseWords01 {
    private static BufferedReader reader;
    private static Predicate<String> checkUpperCase;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        checkUpperCase = word -> word.charAt(0) == word.toUpperCase().charAt(0);
    }

    public static void main(String[] args) throws IOException {
        String[] words = reader.readLine().split(" ");
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (checkUpperCase.test(word)) {
                result.add(word);
            }
        }

        System.out.println(result.size());
        for (String word : result) {
            System.out.println(word);
        }
    }
}
