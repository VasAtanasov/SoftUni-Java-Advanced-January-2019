package L12FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class Ex09ListOfPredicates {
    private static BufferedReader reader;
    private static List<Integer> numbers;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] divisors = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .distinct()
                .toArray();

        for (int i = 1; i <= n; i++) {
            if (anyMatch.test(divisors,i)) {
                numbers.add(i);
            }
        }

        System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
    }

    private static BiPredicate<int[], Integer> anyMatch = (divisors, number) -> {
        for (int divisor : divisors) {
            if (number % divisor != 0) {
                return false;
            }
        }
        return true;
    };
}
