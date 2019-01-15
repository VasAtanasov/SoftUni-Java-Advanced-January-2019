package L03StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03DecimalToBinaryRecursion {
    private static StringBuilder output = new StringBuilder();
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(reader.readLine());

        if (number == 0) {
            System.out.println(0);
        }

        printBinary(number);

        System.out.println(output.toString());
    }

    private static void printBinary(int b) {
        if (b > 0) {
            printBinary(b / 2);
            output.append(String.format("%d", b % 2));
        }
    }
}

