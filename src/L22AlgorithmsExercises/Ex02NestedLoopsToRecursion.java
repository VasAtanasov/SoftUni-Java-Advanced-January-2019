package L22AlgorithmsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02NestedLoopsToRecursion {
    private static BufferedReader reader;
    private static int n;
    private static int[] loops;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(reader.readLine());
        loops = new int[n];
        nestedLoops(0);

    }

    private static void nestedLoops(int currentLoop) {
        if (currentLoop == n) {
            printLoops();
            return;
        }

        for (int counter = 1; counter <= n; counter++) {
            loops[currentLoop] = counter;
            nestedLoops(currentLoop + 1);
        }
    }


    private static void printLoops() {
        for (int i = 0; i < n; i++) {
            System.out.print(String.format("%d ", loops[i]));
        }
        System.out.println();
    }
}
