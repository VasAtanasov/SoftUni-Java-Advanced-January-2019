package L06MultidimensionalArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex07Crossfire {
    private static BufferedReader reader;
    private static List<List<Integer>> matrix;
    private static int rows, cols;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        matrix = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        getDimensions();

        String input;
        while (! "Nuke it from orbit".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            int targetRow = Integer.parseInt(tokens[0]);
            int targetCol = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            int rowStart = Math.max(0, targetRow - radius);
            int rowEnd = Math.min(rows - 1, targetRow + radius);
            int colStart = Math.max(0, targetCol - radius);
            int colEnd = Math.min(cols - 1, targetCol + radius);

            for (int col = colStart; col <= colEnd; col++) {
                if (inRange(targetRow, col)) {
                    matrix.get(targetRow).set(col, 0);
                }
            }

            for (int row = rowStart; row <= rowEnd; row++) {
                if (inRange(row, targetCol)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }

            matrix.forEach(row -> row.removeIf(value -> value == 0));
            matrix.removeIf(List::isEmpty);
        }

        System.out.println(getMatrixString());
    }

    private static String getMatrixString() {
        StringBuilder output = new StringBuilder();
        for (List<Integer> row : matrix) {
            output.append(row.toString().replaceAll("[\\[\\],]", ""));
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

    private static boolean inRange(int row, int col) {
        return row >= 0 && row < matrix.size() &&
                col >= 0 && col < matrix.get(row).size();
    }

    private static void getDimensions() throws IOException {
        String[] dimension = reader.readLine().split("\\s+");
        rows = Integer.parseInt(dimension[0]);
        cols = Integer.parseInt(dimension[1]);

        int filler = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(filler++);
            }
        }
    }
}

