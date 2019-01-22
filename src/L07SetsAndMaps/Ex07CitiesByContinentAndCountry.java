package L07SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ex07CitiesByContinentAndCountry {

    private static Map<String, Map<String, List<String>>> continents;
    private static BufferedReader reader;

    static {
        continents = new LinkedHashMap<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int lines = Integer.parseInt(reader.readLine());
        while (lines-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String town = tokens[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country, new ArrayList<>());
            continents.get(continent).get(country).add(town);
        }

        continents.forEach((continent, countries) -> {
            System.out.println(continent + ":");
            countries.forEach((country, towns) -> {
                System.out.println(String.format("  %s -> %s", country, String.join(", ", towns)));
            });
        });
    }
}
