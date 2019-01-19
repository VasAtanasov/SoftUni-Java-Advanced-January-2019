package L06MultidimensionalArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01FillTheMatrix {
    private static BufferedReader reader;
    private static int[][] matrix;
    private static int n;
    private static String pattern;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        readInput();

        switch (pattern) {
            case "A":
                patternA();
                break;
            case "B":
                patternB();
                break;
        }

        System.out.println(printMatrix());
    }

    private static void patternB() {
        for (int col = 0, filler = 1; col < n; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++, filler++) {
                    matrix[row][col] = filler;
                }
            } else {
                for (int row = n - 1; row >= 0; row--, filler++) {
                    matrix[row][col] = filler;
                }
            }

        }
    }

    private static void patternA() {
        for (int col = 0, filler = 1; col < n; col++) {
            for (int row = 0; row < n; row++, filler++) {
                matrix[row][col] = filler;
            }
        }
    }

    private static void readInput() throws IOException {
        String[] tokens = reader.readLine().split(", ");
        n = Integer.parseInt(tokens[0]);
        matrix = new int[n][n];
        pattern = tokens[1];
    }

    private static String printMatrix() {
        StringBuilder output = new StringBuilder();
        for (int row = 0; row < n; row++) {
            StringBuilder rowOutput = new StringBuilder();
            for (int col = 0; col < n; col++) {
                rowOutput.append(matrix[row][col])
                        .append(" ");
            }
            output.append(rowOutput.toString().trim())
                    .append(System.lineSeparator());
        }
        return output.toString();
    }
}

