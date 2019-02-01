package L12FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex05ReverseAndExclude {
    private static BufferedReader reader;
    private static List<Integer> numbres;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        numbres = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        int n = Integer.parseInt(reader.readLine());

        System.out.println(getStringResult(n));
    }

    private static String getStringResult(int n) {
        numbres = reverse.apply(numbres);
        StringBuilder output = new StringBuilder();
        for (int number : numbres) {
            if (isNotDivisible.test(number, n)) {
                output.append(number).append(" ");
            }
        }
        return output.toString().trim();
    }

    private static Function<List<Integer>, List<Integer>> reverse = array -> {
        List<Integer> reversed = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            reversed.add(array.get(array.size() - 1 - i));
        }
        return reversed;
    };

    private static BiPredicate<Integer, Integer> isNotDivisible = (number, divisor) -> number % divisor != 0;

}
