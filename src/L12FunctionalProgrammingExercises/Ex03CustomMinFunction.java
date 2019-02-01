package L12FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex03CustomMinFunction {
    private static BufferedReader reader;
    private static List<Integer> numbers;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(getMin.apply(numbers));


    }

    private static Function<List<Integer>, Integer> getMin = integers -> {
        int min = integers.get(0);
        for (int i = 1; i < integers.size(); i++) {
            if (integers.get(i) < min) {
                min = integers.get(i);
            }
        }
        return min;
    };
}
