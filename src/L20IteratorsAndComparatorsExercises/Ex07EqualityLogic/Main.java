package L20IteratorsAndComparatorsExercises.Ex07EqualityLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static BufferedReader reader;
    private static Set<Person> treeOfPeople = new TreeSet<>();
    private static Set<Person> setOfPeople = new HashSet<>();

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            treeOfPeople.add(person);
            setOfPeople.add(person);
        }

        System.out.println(treeOfPeople.size());
        System.out.println(setOfPeople.size());
    }
}
