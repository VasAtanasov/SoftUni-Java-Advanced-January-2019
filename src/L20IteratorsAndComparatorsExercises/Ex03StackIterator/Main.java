package L20IteratorsAndComparatorsExercises.Ex03StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.stream.IntStream;

public class Main {
    private static BufferedReader reader;
    private static final String END_COMMAND = "END";
    private static final String PUSH = "Push";
    private static final String POP = "Pop";
    private static Stack<Integer> stack;

    static {
        stack = new Stack<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! END_COMMAND.equals(input = reader.readLine())) {
            String[] tokens = input.split("[\\s,]+");
            String command = tokens[0];

            switch (command) {
                case POP:
                    try {
                        stack.pop();
                    } catch (EmptyStackException ese) {
                        System.out.println("No elements");
                    }
                    break;
                case PUSH:
                    pushElements(tokens);
                    break;
            }
        }

        IntStream.range(0, 2).forEach(i -> stack.forEach(System.out::println));
    }

    private static void pushElements(String[] token) {
        Arrays.stream(token)
                .filter(s -> !s.isEmpty())
                .skip(1)
                .map(Integer::parseInt)
                .forEach(integer -> stack.push(integer));
    }
}
