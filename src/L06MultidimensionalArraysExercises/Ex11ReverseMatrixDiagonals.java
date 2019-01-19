package L06MultidimensionalArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex11ReverseMatrixDiagonals {
    private static int[][] matrix;
    private static BufferedReader reader;
    private static int rows;
    private static int cols;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        readMatrix();
        print();

    }

    private static void print() {
        for (int col = cols - 1; col > 0; col--) {
            printLeftDiagonals(matrix.length - 1, col);
            System.out.println();
        }

        for (int row = rows - 1; row >= 0; row--) {
            printRightDiagonals(row);
            System.out.println();
        }

    }

    private static void printRightDiagonals(int startRow) {
        for (int row = startRow, col = 0; row >= 0 && col < matrix[row].length; row--, col++) {
            System.out.print(matrix[row][col] + " ");
        }
    }

    private static void printLeftDiagonals(int startRow, int startCol) {
        for (int row = startRow, col = startCol; row >= 0 && col < matrix[row].length; row--, col++) {
            System.out.print(matrix[row][col] + " ");
        }
    }

    private static int[] getMatrixSize() throws IOException {
        return Arrays
                .stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void readMatrix() throws IOException {
        int[] size = getMatrixSize();
        rows = size[0];
        cols = size[1];
        matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays
                    .stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
