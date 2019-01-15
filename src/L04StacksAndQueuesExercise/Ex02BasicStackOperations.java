package L04StacksAndQueuesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex02BasicStackOperations {
    private static BufferedReader reader;
    private static int pushCount;
    private static int popCount;
    private static int searchedElement;
    private static Deque<Integer> elements;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        elements = new ArrayDeque<>();
    }

    public static void main(String[] args) throws IOException {
        readInput();
        pushElements();
        popElements();

        if (elements.contains(searchedElement)) {
            System.out.println(true);
        } else {
            int smallestElement = getSmallestElement();
            System.out.println(smallestElement);
        }
    }

    private static int getSmallestElement() {
        int smallestElement;
        if (elements.isEmpty()) {
            smallestElement = 0;
        } else {
            smallestElement = elements.removeLast();
            while (! elements.isEmpty()) {
                int element = elements.removeLast();
                if (element < smallestElement) {
                    smallestElement = element;
                }
            }
        }
        return smallestElement;
    }

    private static void popElements() {
        while (! elements.isEmpty() && popCount-- > 0) {
            elements.removeLast();
        }
    }

    private static void readInput() throws IOException {
        String[] tokens = reader.readLine().split("\\s+");
        pushCount = Integer.parseInt(tokens[0]);
        popCount = Integer.parseInt(tokens[1]);
        searchedElement = Integer.parseInt(tokens[2]);
    }

    private static void pushElements() throws IOException {
        String[] tokens = reader.readLine().split("\\s+");
        for (int i = 0; i < Math.min(tokens.length, pushCount); i++) {
            elements.addLast(Integer.parseInt(tokens[i]));
        }
    }
}

