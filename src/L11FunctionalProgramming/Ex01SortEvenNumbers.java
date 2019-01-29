package L11FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex01SortEvenNumbers {
    private static BufferedReader reader;
    private static List<Integer> numbers;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        numbers = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        numbers = Arrays.stream(reader.readLine().split("[,\\s]+"))
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        numbers.removeIf(n -> n % 2 != 0);
        System.out.println(numbers.toString().replaceAll("[\\[\\]]",""));
        numbers.sort(Integer::compareTo);
        System.out.println(numbers.toString().replaceAll("[\\[\\]]",""));
    }
}
