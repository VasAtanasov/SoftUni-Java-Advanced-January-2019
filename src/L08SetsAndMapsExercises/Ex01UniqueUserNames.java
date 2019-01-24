package L08SetsAndMapsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ex01UniqueUserNames {
    private static BufferedReader reader;
    private static Set<String> userNames;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        userNames = new LinkedHashSet<>();
    }

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            userNames.add(reader.readLine());
        }

        userNames.forEach(System.out::println);
    }
}
