package L20IteratorsAndComparatorsExercises.Ex04Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static BufferedReader reader;
    private static final String END_COMMAND = "END";

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! END_COMMAND.equals(input = reader.readLine())) {
            int[] numbers = Arrays.stream(input.split("[,\\s+]"))
                    .filter(s -> ! s.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Lake lake = new Lake(numbers);

            List<Integer> integers = new ArrayList<>();
            lake.forEach(integers::add);
            System.out.println(integers.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
