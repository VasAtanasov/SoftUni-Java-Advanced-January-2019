package L12FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Ex11PartyFilter {
    private static BufferedReader reader;
    private static List<String> names;
    private static Map<String, BiPredicate<String, String>> predicates;
    private static List<String> filters;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        predicates = new HashMap<>() {{
            put("Starts", String::startsWith);
            put("Ends", String::endsWith);
            put("Contains", String::contains);
            put("Length", (name, criteria) -> name.length() == Integer.parseInt(criteria));
        }};
        filters = new ArrayList<>();
    }

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        getNames();

        String input;
        while (! "Print".equals(input = reader.readLine())) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String condition = tokens[1].split("\\s+")[0];
            String criteria = tokens[2];

            String filter = condition + " " + criteria;
            switch (command) {
                case "Add filter":
                    filters.add(filter);
                    break;
                case "Remove filter":
                    filters.removeIf(f -> f.equals(filter));
                    break;
            }
        }


        for (String filter : filters) {
            String[] tokens = filter.split(" ");
            String condition = tokens[0];
            String criteria = tokens[1];
            names.removeIf(name -> predicates.get(condition).test(name, criteria));
        }

        System.out.println(names.toString().replaceAll("[\\[\\],]",""));
    }

    private static void getNames() throws IOException {
        names = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
