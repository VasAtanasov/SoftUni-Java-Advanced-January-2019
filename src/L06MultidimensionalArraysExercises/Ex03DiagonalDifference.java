package L06MultidimensionalArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03DiagonalDifference {
    private static BufferedReader reader;
    private static int n;
    private static int[][] matrix;
    private static int leftDiagonalSum;
    private static int rightDiagonalSum;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        leftDiagonalSum = 0;
        rightDiagonalSum = 0;
    }

    public static void main(String[] args) throws IOException {
        readInput();
        getLeftDiagonalSum();
        getRightDiagonalSum();

        System.out.println(Math.abs(leftDiagonalSum - rightDiagonalSum));
    }

    private static void getRightDiagonalSum() {
        for (int row = 0, col = n - 1; row < n && col >= 0; row++, col--) {
            rightDiagonalSum += matrix[row][col];
        }
    }

    private static void getLeftDiagonalSum() {
        for (int i = 0; i < n; i++) {
            leftDiagonalSum += matrix[i][i];
        }
    }

    private static void readInput() throws IOException {
        n = Integer.parseInt(reader.readLine());
        matrix = new int[n][n];
        fillMatrix();
    }

    private static void fillMatrix() throws IOException {
        for (int row = 0; row < n; row++) {
            String[] numbres = reader.readLine().split("\\s+");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = Integer.parseInt(numbres[col]);
            }
        }
    }
}

