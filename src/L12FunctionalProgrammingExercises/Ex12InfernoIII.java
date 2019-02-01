package L12FunctionalProgrammingExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Ex12InfernoIII {
    private static BufferedReader reader;
    private static List<Integer> numbers;
    private static List<String> actions;
    private static List<Integer> indexes;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        actions = new ArrayList<>();
        indexes = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        getGems();
        getActions();

        for (String action : actions) {
            indexes.addAll(indexFilter.apply(numbers, action));
        }

        System.out.println(getStringResult());
    }

    private static String getStringResult() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            if (! indexes.contains(i)) {
                output.append(numbers.get(i)).append(" ");
            }
        }
        return output.toString().trim();
    }

    private static void getActions() throws IOException {
        String input;
        while (! "Forge".equals(input = reader.readLine())) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String condition = tokens[1];
            String criteria = tokens[2];

            String action = condition + " " + criteria;
            switch (command) {
                case "Exclude":
                    actions.add(action);
                    break;
                case "Reverse":
                    reverseAction(action);
                    break;
            }
        }
    }

    private static void reverseAction(String action) {
        for (int i = actions.size() - 1; i >= 0; i--) {
            if (actions.get(i).equals(action)) {
                actions.remove(i);
                break;
            }
        }
    }

    private static void getGems() throws IOException {
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static BiFunction<List<Integer>, String, List<Integer>> indexFilter = (list, action) -> {
        List<Integer> indexes = new ArrayList<>();
        String condition = action.substring(0, action.lastIndexOf(" "));
        int criteria = Integer.parseInt(action.substring(action.lastIndexOf(" ") + 1));
        for (int i = 0; i < list.size(); i++) {
            int leftElement = i - 1 < 0 ? 0 : list.get(i - 1);
            int rightElement = i + 1 >= list.size() ? 0 : list.get(i + 1);
            if ("Sum Left".equals(condition)) {
                rightElement = 0;
            }
            if ("Sum Right".equals(condition)) {
                leftElement = 0;
            }
            int currentElement = list.get(i);
            int sum = leftElement + currentElement + rightElement;
            if (sum == criteria) {
                indexes.add(i);
            }
        }
        return indexes;
    };
}
