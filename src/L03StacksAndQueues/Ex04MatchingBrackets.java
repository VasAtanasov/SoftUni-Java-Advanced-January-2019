package L03StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex04MatchingBrackets {
    private static BufferedReader reader;
    private static Deque<Integer> stack;
    private static String expression;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        stack = new ArrayDeque<>();
    }

    public static void main(String[] args) throws IOException {
        expression = reader.readLine();
        char[] chars = expression.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.addLast(i);
            } else if (chars[i] == ')') {
                int startIndex = stack.removeLast();
                String subExpression = expression.substring(startIndex, i + 1);
                System.out.println(subExpression);
            }
        }
    }
}

