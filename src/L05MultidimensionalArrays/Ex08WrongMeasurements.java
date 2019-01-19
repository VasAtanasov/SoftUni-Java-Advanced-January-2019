package L05MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex08WrongMeasurements {
    private static BufferedReader reader;
    private static int[][] matrix;
    private static int[] rowOffset = {0, 0, - 1, 1};
    private static int[] colOffset = {- 1, 1, 0, 0};
    private static int[][] resultMatrix;


    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        readMatrix();
        int[] elementParams = getElementPosition();

        int value = matrix[elementParams[0]][elementParams[1]];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == value) {
                    resultMatrix[row][col] = getSum(row, col, value);
                } else {
                    resultMatrix[row][col] = matrix[row][col];
                }
            }
        }

        printMatrix();
    }

    private static void printMatrix() {
        for (int row = 0; row < resultMatrix.length; row++) {
            StringBuilder output = new StringBuilder();
            for (int col = 0; col < resultMatrix[row].length; col++) {
                output.append(resultMatrix[row][col]).append(" ");
            }
            System.out.println(output.toString().trim());
        }
    }

    private static int getSum(int currentRow, int currentCol, int value) {
        int sum = 0;

        for (int i = 0; i < 4; i++) {
            int row = currentRow + rowOffset[i];
            int col = currentCol + colOffset[i];
            if (inRange(row, col) && matrix[row][col] != value) {
                sum += matrix[row][col];
            }
        }

        return sum;
    }

    private static void readMatrix() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        matrix = new int[size][];
        resultMatrix = new int[size][];
        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays
                    .stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            resultMatrix[row] = new int[matrix[row].length];
        }
    }

    private static boolean inRange(int row, int col) {
        return (row >= 0 && row < matrix.length) &&
                (col >= 0 && col < matrix[row].length);
    }

    private static int[] getElementPosition() throws IOException {
        return Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
