package L06MultidimensionalArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex10RadioactiveMutantVampireBunnies {
    private static final char PLAYER = 'P';
    private static final char BUNNY = 'B';

    private static BufferedReader reader;
    private static char[][] lair;
    private static Deque<Character> commands;
    private static boolean isEscaped;
    private static int[] playerPosition;
    private static int[] rowOffset = {0, 0, - 1, 1};
    private static int[] colOffset = {- 1, 1, 0, 0};

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        commands = new ArrayDeque<>();
        isEscaped = false;
        playerPosition = new int[2];
    }

    public static void main(String[] args) throws IOException {
        readMatrix();
        readCommands();

        while (true) {
            movePlayer();
            spreadBunnies();

            if (isEscaped) {
                printLair();
                System.out.println(String.format("won: %d %d", playerPosition[0], playerPosition[1]));
                return;
            }

            if (lair[playerPosition[0]][playerPosition[1]] == BUNNY) {
                printLair();
                System.out.println(String.format("dead: %d %d", playerPosition[0], playerPosition[1]));
                return;
            }
        }

    }

    private static void printLair() {
        for (int row = 0; row < lair.length; row++) {
            StringBuilder output = new StringBuilder();
            for (int col = 0; col < lair[row].length; col++) {
                output.append(lair[row][col]);
            }
            System.out.println(output.toString());
        }
    }

    private static void spreadBunnies() {
        char[][] newLair = new char[lair.length][];
        for (int i = 0; i < lair.length; i++) {
            newLair[i] = lair[i].clone();
        }

        for (int row = 0; row < lair.length; row++) {
            for (int col = 0; col < lair[row].length; col++) {
                if (lair[row][col] == BUNNY) {
                    for (int i = 0; i < rowOffset.length; i++) {
                        int bunnyRow = row + rowOffset[i];
                        int bunnyCol = col + colOffset[i];
                        if (inRange(bunnyRow, bunnyCol)) {
                            newLair[bunnyRow][bunnyCol] = BUNNY;
                        }
                    }
                }
            }
        }
        lair = newLair;
    }

    private static void movePlayer() {
        if (commands.isEmpty()) {
            return;
        }

        char command = commands.removeFirst();
        switch (command) {
            case 'U':
                playerPosition[0]--;
                if (! inRange(playerPosition[0], playerPosition[1])) {
                    playerPosition[0]++;
                    isEscaped = true;
                }
                break;
            case 'D':
                playerPosition[0]++;
                if (! inRange(playerPosition[0], playerPosition[1])) {
                    playerPosition[0]--;
                    isEscaped = true;
                }
                break;
            case 'L':
                playerPosition[1]--;
                if (! inRange(playerPosition[0], playerPosition[1])) {
                    playerPosition[1]++;
                    isEscaped = true;
                }
                break;
            case 'R':
                playerPosition[1]++;
                if (! inRange(playerPosition[0], playerPosition[1])) {
                    playerPosition[1]--;
                    isEscaped = true;
                }
                break;
        }
    }

    private static void readCommands() throws IOException {
        char[] tokens = reader.readLine().toCharArray();
        for (char command : tokens) {
            commands.addLast(command);
        }
    }

    private static void readMatrix() throws IOException {
        int[] matrixParams = getMatrixSize();
        int rows = matrixParams[0];
        int cols = matrixParams[1];
        lair = new char[rows][];

        for (int row = 0; row < rows; row++) {
            char[] inputCols = reader.readLine().toCharArray();
            lair[row] = new char[inputCols.length];
            for (int col = 0; col < cols; col++) {
                if (inputCols[col] == PLAYER) {
                    playerPosition[0] = row;
                    playerPosition[1] = col;
                    lair[row][col] = '.';
                } else {
                    lair[row][col] = inputCols[col];
                }

            }
        }
    }

    private static boolean inRange(int row, int col) {
        return (row >= 0 && row < lair.length) &&
                (col >= 0 && col < lair[row].length);
    }

    private static int[] getMatrixSize() throws IOException {
        return Arrays
                .stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
