package L12FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Ex08CustomComparator {
    private static BufferedReader reader;
    private static Integer[] numbres;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        numbres = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Arrays.sort(numbres, customSort);
        System.out.println(Arrays.toString(numbres).replaceAll("[\\[\\],]", ""));

    }

    private static Comparator<Integer> customSort = (num1, num2) -> {
        if ((num1 % 2 == 0) == (num2 % 2 == 0)) {
            return num1.compareTo(num2);
        } else if (num1 % 2 == 0) {
            return -1;
        } else {
            return 1;
        }
    };
}
