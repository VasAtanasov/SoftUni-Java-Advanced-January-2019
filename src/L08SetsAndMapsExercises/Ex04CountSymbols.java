package L08SetsAndMapsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Ex04CountSymbols {
    private static BufferedReader reader;
    private static Map<Character, Integer> chars;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        chars = new TreeMap<>();
    }

    public static void main(String[] args) throws IOException {
        char[] input = reader.readLine().toCharArray();

        for (char ch : input) {
            chars.putIfAbsent(ch, 0);
            int updatedCount = chars.get(ch) + 1;
            chars.put(ch, updatedCount);
        }

        chars.forEach((c,i) -> System.out.println(String.format("%c: %d time/s",c,i)));
    }
}
