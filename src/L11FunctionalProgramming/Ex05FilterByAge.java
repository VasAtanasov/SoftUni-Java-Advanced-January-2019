package L11FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class Ex05FilterByAge {
    private static BufferedReader reader;
    private static Map<String, Person> people;
    private static Map<String, BiPredicate<Person, Integer>> predicates;
    private static Map<String, Function<Person, String>> formats;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        people = new LinkedHashMap<>();
        predicates = new HashMap<>() {{
            put("younger", (person, limitAte) -> person.getAge() < limitAte);
            put("older", (person, limitAge) -> person.getAge() >= limitAge);
        }};
        formats = new HashMap<>() {{
            put("name age", person -> String.format("%s - %d", person.getName(), person.getAge()));
            put("name", Person::getName);
            put("age", person -> String.format("%d", person.getAge()));
        }};
    }

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String[] tokens = reader.readLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            people.putIfAbsent(name, new Person(name, age));
        }

        String condition = reader.readLine();
        int ageLimit = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        people.values().stream()
                .filter(person -> predicates.get(condition).test(person, ageLimit))
                .forEach(person -> System.out.println(formats.get(format).apply(person)));
    }

    private static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String getName() {
            return this.name;
        }

        int getAge() {
            return this.age;
        }
    }
}

