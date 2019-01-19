package L05MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03IntersectionOfTwoMatrices {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        char[][] matrixOne = readMatrix(rows);
        char[][] matrixTwo = readMatrix(rows);


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrixOne[row][col] == matrixTwo[row][col]) {
                    System.out.print(matrixOne[row][col] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(int rows) throws IOException {
        char[][] matrix = new char[rows][];
        for (int row = 0; row < rows; row++) {
            String[] inputCols = reader.readLine().split(" ");
            matrix[row] = new char[inputCols.length];
            for (int col = 0; col < inputCols.length; col++) {
                matrix[row][col] = inputCols[col].charAt(0);
            }
        }
        return matrix;
    }
}