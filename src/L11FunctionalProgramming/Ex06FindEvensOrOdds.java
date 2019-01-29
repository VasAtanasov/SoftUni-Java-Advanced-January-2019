package L11FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Ex06FindEvensOrOdds {
    private static BufferedReader reader;
    private static Map<String, Predicate<Integer>> predicates;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        predicates = new HashMap<>() {{
            put("odd", number -> number % 2 != 0);
            put("even", number -> number % 2 == 0);
        }};
    }

    public static void main(String[] args) throws IOException {
        String[] bounds = reader.readLine().split("\\s+");
        int lowerBound = Integer.parseInt(bounds[0]);
        int upperBound = Integer.parseInt(bounds[1]);
        String condition = reader.readLine();

        System.out.println(getStringResult(lowerBound, upperBound, predicates.get(condition)));

    }

    private static String getStringResult(int lowerBound, int upperBound, Predicate<Integer> condition) {
        StringBuilder output = new StringBuilder();
        for (int number = lowerBound; number <= upperBound; number++) {
            if (condition.test(number)) {
                output.append(number).append(" ");
            }
        }
        return output.toString().trim();
    }
}
