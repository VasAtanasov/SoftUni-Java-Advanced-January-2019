package L03StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex03DecimalToBinary {
    private static BufferedReader reader;
    private static Deque<Integer> binary;
    private static int number;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        binary = new ArrayDeque<>();
    }

    public static void main(String[] args) throws IOException {
        number = Integer.parseInt(reader.readLine());

        if (number == 0) {
            System.out.println(number);
            return;
        }

        convertToBinary();

        System.out.println(getResultString());
    }

    private static String getResultString() {
        StringBuilder output = new StringBuilder();
        while (! binary.isEmpty()) {
            output.append(binary.removeLast());
        }
        return output.toString();
    }

    private static void convertToBinary() {
        while (number != 0) {
            binary.addLast(number % 2);
            number /= 2;
        }
    }
}

