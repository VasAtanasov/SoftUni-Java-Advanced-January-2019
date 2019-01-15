package L04StacksAndQueuesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex06BalancedParentheses {
    private static BufferedReader reader;
    private static Deque<Character> stack;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        stack = new ArrayDeque<>();
    }

    public static void main(String[] args) throws IOException {
        char[] chars = reader.readLine().toCharArray();

        for (char character : chars) {
            boolean isBalanced = true;
            switch (character) {
                case ']':
                    isBalanced = isBalanced('[');
                    break;
                case '}':
                    isBalanced = isBalanced('{');
                    break;
                case ')':
                    isBalanced = isBalanced('(');
                    break;
                default:
                    stack.addLast(character);
            }

            if (!isBalanced) {
                System.out.println("NO");
                return;
            }

        }

        System.out.println("YES");
    }

    private static boolean isBalanced(char bracket) {
        if (! stack.isEmpty() && stack.peekLast() == bracket) {
            stack.removeLast();
            return true;
        } else {
            return false;
        }
    }

}

