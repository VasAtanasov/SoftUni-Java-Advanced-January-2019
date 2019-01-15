package L03StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex02SimpleCalculator {
    private static BufferedReader reader;
    private static Deque<String> expression;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        expression = new ArrayDeque<>();
    }

    public static void main(String[] args) throws IOException {
        readInput();
        calculateExpression();

        System.out.println(expression.remove());
    }

    private static void calculateExpression() {
        while (expression.size() != 1) {
            int leftElement = Integer.parseInt(expression.removeFirst());
            String operation = expression.removeFirst();
            int rightElement = Integer.parseInt(expression.removeFirst());

            int subResult = "+".endsWith(operation) ? leftElement + rightElement : leftElement - rightElement;
            expression.addFirst(String.valueOf(subResult));
        }
    }

    private static void readInput() throws IOException {
        String[] tokens = reader.readLine().split("\\s+");
        for (String token : tokens) {
            expression.addLast(token);
        }
    }
}
