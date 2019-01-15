package L03StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex06HotPotato {
    private static BufferedReader reader;
    private static Deque<String> queue;
    private static int n;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        queue = new ArrayDeque<>();
    }

    public static void main(String[] args) throws IOException {
        readInput();
        playTheGame();
        System.out.println("Last is " + queue.poll());

    }

    private static void playTheGame() {
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
    }

    @SuppressWarnings("Duplicates")
    private static void readInput() throws IOException {
        String[] persons = reader.readLine().split("\\s+");
        n = Integer.valueOf(reader.readLine());
        for (String person : persons) {
            queue.offer(person);
        }
    }
}


