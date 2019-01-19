package L05MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex01CompareMatrices {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int[][] firstMatrix = readMatrix(getMatrixParams());
        int[][] secondMatrix = readMatrix(getMatrixParams());

        if (areEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    private static boolean areEqual(int[][] matrix, int[][] otherMatrix) {
        if (matrix.length != otherMatrix.length) {
            return false;
        }

        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row].length != otherMatrix[row].length) {
                return false;
            }
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != otherMatrix[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }

    @SuppressWarnings("Duplicates")
    private static int[][] readMatrix(int[] matrixParams) throws IOException {
        int rows = matrixParams[0];

        int[][] resultMatrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            int[] inputCols = Arrays.stream(reader.readLine().split("\\s+"))
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

