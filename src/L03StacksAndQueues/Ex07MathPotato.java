package L03StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class Ex07MathPotato {
    private static BufferedReader reader;
    private static Deque<String> queue;
    private static int n;
    private static int cycle;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        queue = new ArrayDeque<>();
        cycle = 1;
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
            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
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

    private static boolean isPrime(int number) {
        return number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(div -> number % div == 0);
    }
}


