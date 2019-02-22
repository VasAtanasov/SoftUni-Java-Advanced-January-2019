package L23ExamPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex02ExcelFunctions01 {
    private static BufferedReader reader;
    private static List<String> headers;
    private static String[][] matrix;

    private enum Command {
        hide, sort, filter
    }

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        readInput();

        String[] tokens = reader.readLine().split("\\s+");
        Command command = Command.valueOf(tokens[0]);

        String header = tokens[1];
        switch (command) {
            case hide:
                hideColumns(header);
                break;
            case sort:
                sortColumns(headers.indexOf(header));
                break;
            case filter:
                filterColumns(header, headers.indexOf(header), tokens[2]);
                break;
        }

    }

    private static void filterColumns(String header, int headerIndex, String value) {
        System.out.println(String.join(" | ", matrix[0]));
        for (int row = 1; row < matrix.length; row++) {
            if (matrix[0][headerIndex].equals(header) && matrix[row][headerIndex].equals(value)) {
                System.out.println(String.join(" | ", matrix[row]));
            }
        }
    }

    private static void sortColumns(int headerIndex) {
        System.out.println(String.join(" | ", matrix[0]));
        System.out.println(String.join("\n",
                Arrays.stream(matrix)
                        .skip(1)
                        .sorted(Comparator.comparing(a -> a[headerIndex]))
                        .map(row -> String.join(" | ", row))
                        .toArray(String[]::new)
        ));
    }

    private static void hideColumns(String header) {
        List<String> cols = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[0][col].equals(header)) {
                    continue;
                }
                cols.add(matrix[row][col]);
            }
            System.out.println(String.join(" | ", cols));
            cols.clear();
        }
    }

    private static void readInput() throws IOException {
        int size = Integer.parseInt(reader.readLine());
        matrix = new String[size][];

        for (int row = 0; row < size; row++) {
            String[] tokens = reader.readLine().split(", ");
            matrix[row] = new String[tokens.length];
            System.arraycopy(tokens, 0, matrix[row], 0, tokens.length);
        }

        headers = new ArrayList<>(Arrays.asList(matrix[0]));
    }
}
