package L06MultidimensionalArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04MaximalSum {
    private static BufferedReader reader;
    private static int[][] matrix;
    private static int rows;
    private static int cols;
    private static int bestSum;
    private static int bestRow;
    private static int bestCol;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        bestSum = Integer.MIN_VALUE;
        bestRow = 0;
        bestCol = 0;
    }

    public static void main(String[] args) throws IOException {
        readInput();
        getBestSum();

        System.out.println(String.format("Sum = %d",bestSum));
        System.out.println(getMatrixString());


    }

    private static void getBestSum() {
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum = getCurrentSum(row, col);
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }
    }

    private static int getCurrentSum(int row, int col) {
        int currentSum = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                currentSum += matrix[i][j];
            }
        }
        return currentSum;
    }

    private static void readInput() throws IOException {
        String[] size = reader.readLine().split("\\s+");
        rows = Integer.parseInt(size[0]);
        cols = Integer.parseInt(size[1]);
        matrix = new int[rows][cols];

        fillMatrix();
    }

    @SuppressWarnings("Duplicates")
    private static void fillMatrix() throws IOException {
        for (int row = 0; row < rows; row++) {
            String[] tokens = reader.readLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(tokens[col]);
            }
        }
    }

    private static String getMatrixString() {
        StringBuilder output = new StringBuilder();
        for (int row = bestRow; row < bestRow + 3; row++) {
            StringBuilder rowOutput = new StringBuilder();
            for (int col = bestCol; col < bestCol + 3; col++) {
                rowOutput.append(matrix[row][col])
                        .append(" ");
            }
            output.append(rowOutput.toString().trim())
                    .append(System.lineSeparator());
        }
        return output.toString();
    }
}

