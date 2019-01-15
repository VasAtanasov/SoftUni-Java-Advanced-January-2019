package L04StacksAndQueuesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex04BasicQueueOperations {
    private static BufferedReader reader;
    private static int queueCount;
    private static int dequeueCount;
    private static int searchedElement;
    private static Deque<Integer> elements;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        elements = new ArrayDeque<>();
    }

    public static void main(String[] args) throws IOException {
        readInput();
        enqueueElements();
        dequeueElements();

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
            smallestElement = Integer.MAX_VALUE;
            while (! elements.isEmpty()) {
                int element = elements.removeFirst();
                if (element < smallestElement) {
                    smallestElement = element;
                }
            }
        }
        return smallestElement;
    }

    private static void dequeueElements() {
        while (! elements.isEmpty() && dequeueCount-- > 0) {
            elements.removeFirst();
        }
    }

    private static void readInput() throws IOException {
        String[] tokens = reader.readLine().split("\\s+");
        queueCount = Integer.parseInt(tokens[0]);
        dequeueCount = Integer.parseInt(tokens[1]);
        searchedElement = Integer.parseInt(tokens[2]);
    }

    private static void enqueueElements() throws IOException {
        String[] tokens = reader.readLine().split("\\s+");
        for (int i = 0; i < Math.min(tokens.length, queueCount); i++) {
            elements.addLast(Integer.parseInt(tokens[i]));
        }
    }
}

