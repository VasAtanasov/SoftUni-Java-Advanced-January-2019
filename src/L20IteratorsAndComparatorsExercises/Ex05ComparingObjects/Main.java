package L20IteratorsAndComparatorsExercises.Ex05ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.partitioningBy;

public class Main {
    private static BufferedReader reader;
    private static List<Person> people;
    private static final String NO_MATCHES = "No matches";

    static {
        people = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "END".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];
            people.add(new Person(name, age, town));
        }

        int index = Integer.parseInt(reader.readLine());

        if (index >= people.size()) {
            System.out.println(NO_MATCHES);
            return;
        }

        Person person = people.get(index);
        Map<Boolean, List<Person>> statistics = equalPersons(people.stream(), person);

        if (statistics.get(Boolean.TRUE).size() == 0) {
            System.out.println(NO_MATCHES);
        } else {
            System.out.println(String.format("%d %d %d", statistics.get(Boolean.TRUE).size(), statistics.get(Boolean.FALSE).size(), people.size()));
        }
    }

    private static Map<Boolean, List<Person>> equalPersons(Stream<Person> artists, Person person) {
        return artists.collect(partitioningBy(p -> p.compareTo(person) == 0));
    }
}
