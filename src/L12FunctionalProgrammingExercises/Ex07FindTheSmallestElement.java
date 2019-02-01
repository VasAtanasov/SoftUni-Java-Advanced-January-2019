package L12FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class Ex07FindTheSmallestElement {
    private static BufferedReader reader;
    private static int[] numbers;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(findSmallestElementIndex.apply(numbers));

    }

    private static Function<int[], Integer> findSmallestElementIndex = numbres -> {
        int smallestElement = numbres[0];
        int index = 0;
        for (int i = 1; i < numbres.length; i++) {
            if (numbres[i] <= smallestElement) {
                smallestElement = numbres[i];
                index = i;
            }
        }
        return index;
    };
}
