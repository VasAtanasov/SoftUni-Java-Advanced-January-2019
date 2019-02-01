package L12FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class Ex06PredicateForNames {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int length = Integer.parseInt(reader.readLine());
        Arrays.stream(reader.readLine().split("\\s+"))
                .filter(name -> nameFilter.test(name, length))
                .forEach(System.out::println);
    }

    private static BiPredicate<String, Integer> nameFilter = (name, length) -> name.length() <= length;
}
