package L06MultidimensionalArraysExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ex06StingMatrixRotation {
    private static BufferedReader reader;
    private static char[][] matrix;
    private static List<String> words;
    private static int rotate;
    private static int longestWord;
    private static int rows;
    private static int cols;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        words = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        readInput();
        assignRowsAndCols();
        initializeMatrix();

        switch (rotate) {
            case 0:
                fillMatrixHorizontally();
                break;
            case 180:
                fillMatrix180Degrees();
                break;
            case 90:
                fillMatrix90Degrees();
                break;
            case 270:
                fillMatrix270Degrees();
                break;
        }


        System.out.print(getMatrixString());
    }


    @SuppressWarnings("Duplicates")
    private static void fillMatrix270Degrees() {
        for (int col = 0; col < cols; col++) {
            char[] word = words.get(col).toCharArray();
            for (int row = rows - 1, i = 0; row >= 0; row--, i++) {
                matrix[row][col] = i < word.length ? word[i] : ' ';
            }
        }
    }

    private static void fillMatrix90Degrees() {
        for (int col = 0; col < cols; col++) {
            char[] word = words.get(words.size() - 1 - col).toCharArray();
            for (int row = 0; row < rows; row++) {
                matrix[row][col] = row < word.length ? word[row] : ' ';
            }
        }
    }

    @SuppressWarnings("Duplicates")
    private static void fillMatrix180Degrees() {
        for (int row = 0; row < rows; row++) {
            char[] word = words.get(words.size() - 1 - row).toCharArray();
            for (int col = cols - 1, i = 0; col >= 0; col--, i++) {
                matrix[row][col] = i < word.length ? word[i] : ' ';
            }
        }
    }

    private static void fillMatrixHorizontally() {
        for (int row = 0; row < rows; row++) {
            char[] word = words.get(row).toCharArray();
            for (int col = 0; col < word.length; col++) {
                matrix[row][col] = word[col];
            }
        }
    }

    private static void initializeMatrix() {
        matrix = new char[rows][cols];
    }

    private static void assignRowsAndCols() {
        if (rotate == 0 || rotate == 180) {
            rows = words.size();
            cols = longestWord;
        } else if (rotate == 90 || rotate == 270) {
            rows = longestWord;
            cols = words.size();
        }
    }

    private static void readInput() throws IOException {
        gerDegrees();
        getWords();
    }

    private static void getWords() throws IOException {
        String input;
        while (! "END".equals(input = reader.readLine())) {
            words.add(input);
            int currentLength = input.length();
            if (currentLength > longestWord) {
                longestWord = currentLength;
            }
        }
    }

    private static void gerDegrees() throws IOException {
        rotate = Integer.parseInt(reader.readLine()
                .replace("Rotate(", "")
                .replace(")", "").trim()) % 360;
    }

    private static String getMatrixString() {
        StringBuilder output = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            StringBuilder rowOutput = new StringBuilder();
            for (int col = 0; col < cols; col++) {
                rowOutput.append(matrix[row][col]);
            }
            output.append(rowOutput.toString())
                    .append(System.lineSeparator());
        }
        return output.toString();
    }
}
