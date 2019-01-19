package L06MultidimensionalArraysExercises;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02MatrixPalindromes {
    private static BufferedReader reader;
    private static String[][] matrix;
    private static int rows;
    private static int cols;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));

    }

    public static void main(String[] args) throws IOException {
        readInput();
        fillWithPalindromes();
        System.out.println(printMatrix());

    }

    private static void fillWithPalindromes() {
        for (int row = 0, increment = 0; row < rows; row++, increment++) {
            for (int col = 0; col < cols; col++) {
                int firstLast = 97 + row;
                int middle = 97 + col + increment;
                matrix[row][col] = String.format("%c%c%c", firstLast, middle, firstLast);
            }
        }
    }

    @SuppressWarnings("Duplicates")
    private static void readInput() throws IOException {
        String[] size = reader.readLine().split("\\s+");
        rows = Integer.parseInt(size[0]);
        cols = Integer.parseInt(size[1]);
        matrix = new String[rows][cols];
    }


    @SuppressWarnings("Duplicates")
    private static String printMatrix() {
        StringBuilder output = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            StringBuilder rowOutput = new StringBuilder();
            for (int col = 0; col < cols; col++) {
                rowOutput.append(matrix[row][col])
                        .append(" ");
            }
            output.append(rowOutput.toString().trim())
                    .append(System.lineSeparator());
        }
        return output.toString();
    }
}

