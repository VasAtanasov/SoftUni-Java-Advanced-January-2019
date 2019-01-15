package L04StacksAndQueuesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;

public class Ex01ReverseNumbersWithStack {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = Arrays
                .stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        StringBuilder output = new StringBuilder();

        while (!deque.isEmpty()) {
            output.append(deque.removeLast())
                    .append(" ");
        }

        System.out.println(output.toString().trim());


    }
}
