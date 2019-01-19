package L05MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex07FindTheRealQueen {
    private static String[][] board;
    private static BufferedReader reader;
    private static String QUEEN = "q";

    static {
        board = new String[8][];
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        readBoard();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                final String FIGURE = board[row][col];
                if (FIGURE.equals(QUEEN) && isTheRealQueen(row, col)) {
                    System.out.println(String.format("%d %d", row, col));
                    return;
                }
            }
        }
    }

    @SuppressWarnings("Duplicates")
    private static boolean isTheRealQueen(int queenRow, int queenCol) {

        for (int up = queenRow - 1, down = queenRow + 1, left = queenCol - 1, right = queenCol + 1;
             up >= 0 || down < board.length || left >= 0 || right < board.length;
             up--, down++, left--, right++
        ) {
            if (isQueen(queenRow, left)) {
                return false;
            }
            if (isQueen(queenRow, right)) {
                return false;
            }
            if (isQueen(up, queenCol)) {
                return false;
            }
            if (isQueen(down, queenCol)) {
                return false;
            }
            if (isQueen(up, left)) {
                return false;
            }
            if (isQueen(up, right)) {
                return false;
            }
            if (isQueen(down, left)) {
                return false;
            }
            if (isQueen(down, right)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isQueen(int row, int col) {
        return inRange(row, col) && board[row][col].equals(QUEEN);
    }

    private static boolean inRange(int row, int col) {
        return (row >= 0 && row < board.length) &&
                (col >= 0 && col < board[row].length);
    }

    private static void readBoard() throws IOException {
        for (int row = 0; row < 8; row++) {
            board[row] = reader.readLine().split("\\s+");
        }
    }
}
