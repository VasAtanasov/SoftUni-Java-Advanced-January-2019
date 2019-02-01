package L12FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Ex04AppliedArithmetic {
    private static BufferedReader reader;
    private static Map<String, Function<Integer, Integer>> actions;
    private static int[] numbres;
    private static Function<int[], String> print;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        actions = new HashMap<>() {{
            put("add", number -> number += 1);
            put("subtract", number -> number -= 1);
            put("multiply", number -> number *= 2);
        }};
        print = ints -> Arrays.toString(ints).replaceAll("[\\[\\],]", "");
    }

    public static void main(String[] args) throws IOException {
        numbres = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command;
        while (! "end".equals(command = reader.readLine())) {

            if ("print".equals(command)) {
                System.out.println(print.apply(numbres));
            } else {
                Function<Integer, Integer> action = actions.get(command);
                for (int i = 0; i < numbres.length; i++) {
                    numbres[i] = action.apply(numbres[i]);
                }
            }
        }
    }
}
