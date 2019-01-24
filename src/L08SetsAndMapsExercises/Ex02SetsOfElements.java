package L08SetsAndMapsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex02SetsOfElements {
    private static BufferedReader reader;
    private static Set<Integer> firstSet;
    private static Set<Integer> secondSet;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        firstSet = new LinkedHashSet<>();
        secondSet = new LinkedHashSet<>();
    }

    public static void main(String[] args) throws IOException {
        readNumbers();

        firstSet.retainAll(secondSet);

        System.out.println(firstSet.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

    }

    private static void readNumbers() throws IOException {
        String[] size = reader.readLine().split("\\s+");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);

        fillSet(n,firstSet);
        fillSet(m,secondSet);
    }

    private static void fillSet(int count, Set<Integer> set) throws IOException {
        for (int i = 0; i < count; i++) {
            set.add(Integer.parseInt(reader.readLine()));
        }
    }
}
