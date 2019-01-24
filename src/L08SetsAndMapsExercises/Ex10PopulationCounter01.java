package L08SetsAndMapsExercises;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Ex10PopulationCounter01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, LinkedHashMap<String, Long>> demographicData = new LinkedHashMap<>();

        String input = reader.readLine();
        while (! "report".equals(input)) {
            String[] tokens = input.split("[\\|]");
            String country = tokens[1];
            String city = tokens[0];
            long population = Long.valueOf(tokens[2]);

            demographicData.putIfAbsent(country, new LinkedHashMap<>());
            demographicData.get(country).put(city, population);

            input = reader.readLine();
        }


        demographicData.entrySet()
                .stream()
                .sorted((a, b) -> {
                    long sumA = a.getValue().values().stream().mapToLong(Long::valueOf).sum();
                    long sumB = b.getValue().values().stream().mapToLong(Long::valueOf).sum();
                    return Long.compare(sumB, sumA);
                })
                .forEach(country -> {
                    long totalPopulation = country.getValue().values().stream().mapToLong(Long::valueOf).sum();
                    System.out.println(String.format("%s (total population: %d)", country.getKey(), totalPopulation));
                    country.getValue()
                            .entrySet()
                            .stream()
                            .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                            .forEach(city -> {
                                System.out.println(String.format("=>%s: %d", city.getKey(), city.getValue()));
                            });
                });


    }
}

