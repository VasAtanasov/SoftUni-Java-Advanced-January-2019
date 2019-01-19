package L06MultidimensionalArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Ex12TheMatrix {
    private static BufferedReader reader;
    private static String[][] maze;
    private static int[] rowOffset = {0, 0, - 1, 1};
    private static int[] colOffset = {- 1, 1, 0, 0};
    private static Deque<Integer> possibleMoves = new ArrayDeque<>();

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        readMatrix();
        String fillChar = reader.readLine();
        int[] startParams = getParams();
        int starRow = startParams[0];
        int starCol = startParams[1];

        if (! inRange(starRow, starCol)) {
            return;
        }

        String startChar = maze[starRow][starCol];

        possibleMoves.addLast(starRow);
        possibleMoves.addLast(starCol);

        while (! possibleMoves.isEmpty()) {
            int currentRow = possibleMoves.removeFirst();
            int currentCol = possibleMoves.removeFirst();

            for (int i = 0; i < rowOffset.length; i++) {
                int row = currentRow + rowOffset[i];
                int col = currentCol + colOffset[i];

                if (inRange(row, col) && maze[row][col].equals(startChar)) {
                    possibleMoves.addLast(row);
                    possibleMoves.addLast(col);
                }
            }

            maze[currentRow][currentCol] = fillChar;
        }

        printMatrix();
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
