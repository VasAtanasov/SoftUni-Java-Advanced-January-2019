package L06MultidimensionalArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex09ParkingSystem {
    private static BufferedReader reader;
    private static int rows, cols;
    private static Map<Integer, Set<Integer>> parkingSpots;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        parkingSpots = new HashMap<>();
    }

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        getLotSize();

        String input;
        while (! "stop".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            int entryRow = Integer.parseInt(tokens[0]);
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);

            parkingSpots.putIfAbsent(row, new HashSet<>());

            if (isFullRow(row)) {
                System.out.println(String.format("Row %d full", row));
                continue;
            }

            if (! isFreeSpot(row, col)) {
                parkingSpots.get(row).add(col);
                System.out.println(countMoves(entryRow, row, col));
                continue;
            }

            int leftSpot = col - 1;
            int rightSpot = col + 1;
            Set<Integer> colNumbers = parkingSpots.get(row);
            while (true) {
                if (leftSpot > 0 && ! colNumbers.contains(leftSpot)) {
                    colNumbers.add(leftSpot);
                    System.out.println(countMoves(entryRow, row, leftSpot));
                    break;
                } else {
                    leftSpot--;
                }

                if (rightSpot < cols && ! colNumbers.contains(rightSpot)) {
                    colNumbers.add(rightSpot);
                    System.out.println(countMoves(entryRow, row, rightSpot));
                    break;
                } else {
                    rightSpot++;
                }
            }

        }
    }

    private static int countMoves(int entryRow, int row, int col) {
        return Math.abs(entryRow - row) + col + 1;
    }

    private static boolean isFreeSpot(int row, int col) {
        return parkingSpots.get(row).contains(col);
    }

    private static boolean isFullRow(int row) {
        return parkingSpots.get(row).size() == (cols - 1);
    }

    private static void getLotSize() throws IOException {
        String[] size = reader.readLine().split("\\s+");
        rows = Integer.parseInt(size[0]);
        cols = Integer.parseInt(size[1]);
    }
}
