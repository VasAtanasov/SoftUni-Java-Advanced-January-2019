package Z_Exam24Feb2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex02TronRacers {
    private enum Command {up, down, left, right}

    private static final char X = 'x';
    private static final char F = 'f';
    private static final char S = 's';

    private static BufferedReader reader;
    private static Map<Command, int[]> offsets;

    private static char[][] matrix;
    private static int[] first = new int[2];
    private static int[] second = new int[2];

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        offsets = new HashMap<>() {{
            put(Command.up, new int[] {- 1, 0});
            put(Command.down, new int[] {1, 0});
            put(Command.right, new int[] {0, 1});
            put(Command.left, new int[] {0, - 1});
        }};
    }

    public static void main(String[] args) throws IOException {
        initMatrix();

        while (true) {
            Command[] commands = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(Command::valueOf)
                    .toArray(Command[]::new);

            int[] firstOffset = offsets.get(commands[0]);

            if (! processPlayersTurn(first, firstOffset, F, S)) {
                break;
            }

            int[] secondOffset = offsets.get(commands[1]);

            if (! processPlayersTurn(second, secondOffset, S, F)) {
                break;
            }
        }

        printMatrix();
    }

    private static boolean processPlayersTurn(int[] pos, int[] offset, char current, char enemy) {
        int nextRow = getNextRow(pos[0] + offset[0]);
        int nextCol = getNextCol(nextRow, pos[1] + offset[1]);

        if (matrix[nextRow][nextCol] == enemy) {
            matrix[nextRow][nextCol] = X;
            return false;
        }

        pos[0] = nextRow;
        pos[1] = nextCol;
        matrix[pos[0]][pos[1]] = current;
        return true;
    }

    private static void printMatrix() {
        for (char[] row : matrix) {
            StringBuilder outputRow = new StringBuilder();
            for (char col : row) {
                outputRow.append(col);
            }
            System.out.println(outputRow.toString());
        }
    }

    private static int getNextRow(int row) {
        if (row < 0) {
            return matrix.length - 1;
        }
        if (row >= matrix.length) {
            return 0;
        }
        return row;
    }

    private static int getNextCol(int row, int col) {
        if (col < 0) {
            return matrix[row].length - 1;
        }
        if (col >= matrix[row].length) {
            return 0;
        }
        return col;
    }

    private static void initMatrix() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        matrix = new char[size][];
        for (int row = 0; row < size; row++) {
            char[] inputRow = reader.readLine().toCharArray();
            matrix[row] = new char[inputRow.length];
            for (int col = 0; col < inputRow.length; col++) {
                char ch = inputRow[col];
                if (ch == F) {
                    first[0] = row;
                    first[1] = col;
                } else if (ch == S) {
                    second[0] = row;
                    second[1] = col;
                }
                matrix[row][col] = ch;
            }
        }
    }
}
