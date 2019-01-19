package L05MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex03IntersectionOfTwoMatrices {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        String[][] matrixOne = readMatrix(rows);
        String[][] matrixTwo = readMatrix(rows);

        String[][] result = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            Arrays.fill(result[row], "*");
        }

        for (int row = 0; row < matrixTwo.length; row++) {
            for (int col = 0; col < matrixTwo[row].length; col++) {
                if (matrixOne[row][col].equals(matrixTwo[row][col])) {
                    result[row][col] = matrixOne[row][col];
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            System.out.println(String.join(" ",result[row]));
        }
    }

    private static String[][] readMatrix(int rows) throws IOException {
        String[][] matrixOne = new String[rows][];
        for (int row = 0; row < rows; row++) {
            String[] inputCols = reader.readLine().split(" ");
            matrixOne[row] = new String[inputCols.length];
            System.arraycopy(inputCols, 0, matrixOne[row], 0, inputCols.length);
        }
        return matrixOne;
    }
}