package L08SetsAndMapsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ex03PeriodicTable {
    private static BufferedReader reader;
    private static Set<String> elements;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        elements = new TreeSet<>();
    }

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            List<String> inputElements = Arrays.stream(reader.readLine().split("\\s+"))
                    .collect(Collectors.toCollection(ArrayList::new));

            elements.addAll(inputElements);
        }

        System.out.println(String.join(" ", elements));
    }
}
