package L06MultidimensionalArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class Ex12TheMatrixRecursive { // 100/100
    private static BufferedReader reader;
    private static String[][] maze;
    private static int[] rowOffset;
    private static int[] colOffset;
    private static String startChar;
    private static String fillChar;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        rowOffset = new int[] {0, 0, - 1, 1};
        colOffset = new int[] {- 1, 1, 0, 0};
    }

    public static void main(String[] args) throws IOException {
        readMatrix();
        fillChar = reader.readLine();
        int[] startParams = getParams();
        int starRow = startParams[0];
        int starCol = startParams[1];

        startChar = maze[starRow][starCol];

        visitCell(starRow, starCol);

        printMatrix();
    }

    private static void visitCell(int row, int col) {
        if (! inRange(row, col) || ! startChar.equals(maze[row][col])) {
            return;
        }

        maze[row][col] = fillChar;

        visitCell(row + rowOffset[0], col + colOffset[0]);
        visitCell(row + rowOffset[1], col + colOffset[1]);
        visitCell(row + rowOffset[2], col + colOffset[2]);
        visitCell(row + rowOffset[3], col + colOffset[3]);
    }

    private static void printMatrix() {
        for (String[] row : maze) {
            System.out.println(String.join("", row));
        }
    }

    private static boolean inRange(int row, int col) {
        return (row >= 0 && row < maze.length) &&
                (col >= 0 && col < maze[row].length);
    }

    private static void readMatrix() throws IOException {
        int[] size = getParams();
        int rows = size[0];
        maze = new String[rows][];
        for (int row = 0; row < size[0]; row++) {
            maze[row] = reader.readLine().split("\\s+");
        }
    }

    private static int[] getParams() throws IOException {
        return Arrays
                .stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
