package L08SetsAndMapsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ex08HandsOfCards {
    private static BufferedReader reader;
    private static Map<String, CardPlayer> players;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        players = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        handOutCards();

        players.values()
                .forEach(System.out::println);

    }

    private static void handOutCards() throws IOException {
        String input;
        while (! "JOKER".equals(input = reader.readLine())) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            List<String> cards = Arrays.stream(tokens[1].split(", "))
                    .distinct()
                    .collect(Collectors.toCollection(ArrayList::new));
            players.putIfAbsent(name, new CardPlayer(name));
            players.get(name).addCards(cards);
        }
    }

    private static class CardPlayer {
        private static final List<String> powers = Arrays.asList("", "", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
        private static final List<String> suits = Arrays.asList("", "C", "D", "H", "S");

        private String name;
        private Set<String> cards;

        CardPlayer(String name) {
            this.name = name;
            this.cards = new HashSet<>();
        }

        void addCards(List<String> cards) {
            this.cards.addAll(cards);
        }

        private int getTotalScore() {
            return this.cards.stream()
                    .mapToInt(c -> {
                        String power = c.substring(0, c.length() - 1);
                        String suit = c.substring(c.length() - 1);
                        return powers.indexOf(power) * suits.indexOf(suit);
                    })
                    .sum();
        }

        @Override
        public String toString() {
            return String.format("%s: %d", this.name, this.getTotalScore());
        }
    }
}

