package L08SetsAndMapsExercises;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ex10PopulationCounter {
    private static Map<String, Country> countries;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        countries = new LinkedHashMap<>();

        String input;
        while (! "report".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            countries.putIfAbsent(country, new Country(country));
            countries.get(country).addCity(new City(city, population));
        }

        countries.values().stream()
                .sorted()
                .forEach(System.out::print);


    }

    private static class Country implements Comparable<Country> {
        private String name;
        private List<City> cities;

        Country(String name) {
            this.name = name;
            this.cities = new ArrayList<>();
        }

        private String getName() {
            return this.name;
        }

        private List<City> getCities() {
            return this.cities;
        }

        private long getTotalPopulation() {
            return this.cities.stream()
                    .map(City::getPopulation)
                    .reduce(0L, (a, b) -> a + b);
        }

        void addCity(City city) {
            this.cities.add(city);
        }

        @Override
        public int compareTo(Country other) {
            return Long.compare(other.getTotalPopulation(), this.getTotalPopulation());
        }

        @Override
        public String toString() {
            StringBuilder output = new StringBuilder();
            output.append(String.format("%s (total population: %d)", this.getName(), this.getTotalPopulation()))
                    .append(System.lineSeparator());
            this.getCities().stream()
                    .sorted()
                    .forEach(c -> output.append(c).append(System.lineSeparator()));
            return output.toString();
        }
    }

    private static class City implements Comparable<City> {
        private String name;
        private long population;

        City(String name, Long population) {
            this.name = name;
            this.population = population;
        }

        private String getName() {
            return this.name;
        }

        long getPopulation() {
            return this.population;
        }

        @Override
        public int compareTo(City other) {
            return Long.compare(other.getPopulation(), this.getPopulation());
        }

        @Override
        public String toString() {
            return String.format("=>%s: %d", this.getName(), this.getPopulation());
        }
    }
}



