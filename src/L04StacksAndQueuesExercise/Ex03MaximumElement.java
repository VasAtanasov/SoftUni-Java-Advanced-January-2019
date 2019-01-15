package L04StacksAndQueuesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex03MaximumElement {
    private static BufferedReader reader;
    private static Deque<Integer> elements;
    private static int max = Integer.MIN_VALUE;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        elements = new ArrayDeque<>(100000);
    }

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            String input = reader.readLine();
            String command = input;
            if (input.length() != 1) {
                command = "1";
            }

            switch (command) {
                case "1":
                    String[] tokens = input.split("\\s+");
                    int element = Integer.parseInt(tokens[1]);
                    elements.addLast(element);
                    break;
                case "2":
                    popElement();
                    break;
                case "3":
                    Optional<Integer> minOpt = elements.stream().max(Integer::compareTo);
                    if (minOpt.isPresent()) {
                        System.out.println(minOpt.get());
                    } else {
                        System.out.println(0);
                    }
                    break;
            }
        }

    }

    private static void popElement() {
        if (! elements.isEmpty()) {
            elements.removeLast();
        }
    }
}
