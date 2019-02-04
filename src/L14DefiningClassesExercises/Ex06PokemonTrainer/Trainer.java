package L14DefiningClassesExercises.Ex06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer implements Comparable<Trainer> {
    private String name;
    private int badgesCount;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badgesCount = 0;
        this.pokemons = new ArrayList<>();
    }

    public int getBadgesCount() {
        return this.badgesCount;
    }

    public String getName() {
        return this.name;
    }

    public int getPokemonsCount() {
        return this.pokemons.size();
    }

    void add(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    void procesElement(String element) {
        if (isPokemont(element)) {
            this.badgesCount++;
        } else {
            pokemons.forEach(Pokemon::reduceHealth);
            this.pokemons = this.pokemons.stream()
                    .filter(Pokemon::isAlive)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }

    private boolean isPokemont(String element) {
        return this.pokemons.stream().anyMatch(pokemon -> pokemon.getElement().equals(element));
    }

    @Override
    public int compareTo(Trainer other) {
        return Integer.compare(other.getBadgesCount(), this.getBadgesCount());
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.getName(), this.getBadgesCount(), this.getPokemonsCount());
    }
}
