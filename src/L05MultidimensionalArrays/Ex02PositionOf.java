package L05MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex02PositionOf {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int[][] matrix = readMatrix(getMatrixParams());
        int searchedElement = Integer.parseInt(reader.readLine());
        boolean notFound = true;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int element = matrix[row][col];
                if (element == searchedElement) {
                    notFound = false;
                    System.out.println(String.format("%d %d", row, col));
                }
            }
        }

        if (notFound) {
            System.out.println("not found");
        }
    }

    @SuppressWarnings("Duplicates")
    private static int[][] readMatrix(int[] matrixParams) throws IOException {
        int rows = matrixParams[0];

        int[][] resultMatrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            int[] inputCols = Arrays
                    .stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            resultMatrix[row] = new int[inputCols.length];
            System.arraycopy(inputCols, 0, resultMatrix[row], 0, inputCols.length);
        }

        return resultMatrix;
    }

    private static int[] getMatrixParams() throws IOException {
        return Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}