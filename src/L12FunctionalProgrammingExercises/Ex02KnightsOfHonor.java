package L12FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class Ex02KnightsOfHonor {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        Arrays.stream(reader.readLine().split("\\s+"))
                .forEach(s -> getPrintln.accept(s));
    }

    private static Consumer<String> getPrintln = s -> System.out.println(String.format("Sir %s", s));
}
