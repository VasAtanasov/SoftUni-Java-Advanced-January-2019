package L14DefiningClassesExercises.Ex06PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static BufferedReader reader;
    private static Map<String, Trainer> trainers;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        trainers = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        getPokemons();

        String input;
        while (! "End".equals(input = reader.readLine())) {
            String element = input;
            trainers.values().forEach(trainer -> trainer.procesElement(element));
        }

        trainers.values()
                .stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static void getPokemons() throws IOException {
        String input;
        while (! "Tournament".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String trainer = tokens[0];
            String pokemnonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);
            trainers.putIfAbsent(trainer, new Trainer(trainer));
            trainers.get(trainer).add(new Pokemon(pokemnonName, element, health));
        }
    }
}
