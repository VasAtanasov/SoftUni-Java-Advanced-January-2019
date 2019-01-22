package L07SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex04CountRealNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<BigDecimal, Integer> occurrences = new LinkedHashMap<>();
        BigDecimal[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(BigDecimal::new)
                .toArray(BigDecimal[]::new);

        for (BigDecimal number : numbers) {
            occurrences.putIfAbsent(number, 0);
            occurrences.put(number, occurrences.get(number) + 1);
        }

        DecimalFormat df = new DecimalFormat("0.0");
        occurrences.forEach((key, value) -> {
            System.out.println(String.format("%s -> %d", df.format(key), value));
        });
    }
}
