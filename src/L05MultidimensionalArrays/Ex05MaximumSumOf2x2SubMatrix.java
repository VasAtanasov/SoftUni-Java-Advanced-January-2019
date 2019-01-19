package L05MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05MaximumSumOf2x2SubMatrix {
    private static BufferedReader reader;
    private static int rows;
    private static int cols;
    private static int[][] matrix;
    private static int bestSum;
    private static int[][] bestMatrix;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        bestMatrix = new int[2][2];
        bestSum = Integer.MIN_VALUE;
    }

    public static void main(String[] args) throws IOException {
        readMatrixData();

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int currentSum = 0;
                currentSum += matrix[row][col];
                currentSum += matrix[row][col + 1];
                currentSum += matrix[row + 1][col];
                currentSum += matrix[row + 1][col + 1];

                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestMatrix[0][0] = matrix[row][col];
                    bestMatrix[0][1] = matrix[row][col + 1];
                    bestMatrix[1][0] = matrix[row + 1][col];
                    bestMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }

        System.out.println(getBestMatrixString());
        System.out.println(bestSum);
    }

    private static String getBestMatrixString() {
        StringBuilder output = new StringBuilder();
        output.append(bestMatrix[0][0]).append(" ").append(bestMatrix[0][1])
                .append(System.lineSeparator())
                .append(bestMatrix[1][0]).append(" ").append(bestMatrix[1][1]);
        return output.toString();
    }

    private static void readMatrixData() throws IOException {
        String[] tokens = reader.readLine().split(", ");
        rows = Integer.parseInt(tokens[0]);
        cols = Integer.parseInt(tokens[1]);
        readMatrix();
    }

    private static void readMatrix() throws IOException {
        matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] rowInput = reader.readLine().split(", ");
            for (int col = 0, i = 0; i < cols && col < cols; col++, i++) {
                matrix[row][col] = Integer.parseInt(rowInput[i]);
            }
        }
    }
}
