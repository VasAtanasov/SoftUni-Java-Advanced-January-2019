package L12FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Ex10PredicateParty {
    private static final String END_COMMAND = "Party!";

    private enum Criteria {
        STARTSWITH, ENDSWITH, LENGTH
    }

    private enum Command {
        DOUBLE, REMOVE
    }

    private static Map<Criteria, BiPredicate<String, String>> predicates;
    private static List<String> people;
    private static BufferedReader reader;

    static {
        people = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
        predicates = new HashMap<>() {{
            put(Criteria.STARTSWITH, String::startsWith);
            put(Criteria.ENDSWITH, String::endsWith);
            put(Criteria.LENGTH, (name, parameter) -> name.length() == Integer.parseInt(parameter));
        }};
    }

    public static void main(String[] args) throws IOException {
        readNames();

        String input;
        while (! END_COMMAND.equals(input = reader.readLine())) {

            if (people.isEmpty()) {
                break;
            }

            String[] tokens = input.split("\\s+");
            Command command = Command.valueOf(tokens[0].toUpperCase());
            Criteria criteria = Criteria.valueOf(tokens[1].toUpperCase());
            String parameter = tokens[2];

            switch (command) {
                case DOUBLE:
                    doublePeople(predicates.get(criteria), parameter);
                    break;
                case REMOVE:
                    removePeople(predicates.get(criteria), parameter);
                    break;
            }
        }

        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(people);
            System.out.println(String.format("%s are going to the party!", String.join(", ", people)));
        }

    }

    private static void removePeople(BiPredicate<String, String> predicate, String parameter) {
        people.removeIf(person -> predicate.test(person, parameter));
    }

    @SuppressWarnings("Duplicates")
    private static void doublePeople(BiPredicate<String, String> predicate, String parameter) {
        List<String> doubledNames = new ArrayList<>(people.size());
        for (String name : people) {
            if (predicate.test(name, parameter)) {
                doubledNames.add(name);
            }
            doubledNames.add(name);
        }
        people.clear();
        people.addAll(doubledNames);
    }

    private static void readNames() throws IOException {
        people = Arrays
                .stream(reader.readLine().split("\\s+"))
                .filter(s -> ! s.isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
