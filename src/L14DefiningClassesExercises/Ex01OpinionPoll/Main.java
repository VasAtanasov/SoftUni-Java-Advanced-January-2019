package L14DefiningClassesExercises.Ex01OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader reader;
    private static List<Person> people;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        people = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            people.add(new Person(name, age));
        }

        people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted()
                .forEach(System.out::println);
    }
}
