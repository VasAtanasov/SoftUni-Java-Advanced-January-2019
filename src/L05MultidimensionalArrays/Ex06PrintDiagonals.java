package L05MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06PrintDiagonals {
    private static BufferedReader reader;
    private static int n;
    private static String[][] matrix;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        readInput();
        getLeftDiagonal();
        getRightDiagonal();
    }

    private static void getRightDiagonal() {
        String[] result = new String[n];
        for (int row = matrix.length - 1, col = 0; row >= 0 && col < matrix[row].length; row--, col++) {
            result[col] = matrix[row][col];
        }
        System.out.println(String.join(" ", result));
    }

    private static void getLeftDiagonal() {
        String[] result = new String[n];
        for (int row = 0; row < matrix.length; row++) {
            result[row] = matrix[row][row];
        }
        System.out.println(String.join(" ", result));
    }

    private static void readInput() throws IOException {
        n = Integer.parseInt(reader.readLine());
        matrix = new String[n][];
        fillMatrix();
    }

    private static void fillMatrix() throws IOException {
        for (int row = 0; row < n; row++) {
            String[] cols = reader.readLine().split("\\s+");
            matrix[row] = new String[cols.length];
            System.arraycopy(cols, 0, matrix[row], 0, cols.length);
        }
    }
}
