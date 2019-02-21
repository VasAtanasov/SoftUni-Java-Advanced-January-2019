package L22AlgorithmsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Ex03ConnectedAreasInMatrix {
    private static BufferedReader reader;
    private static int[] rowOffset = {0, 0, - 1, 1};
    private static int[] colOffset = {- 1, 1, 0, 0};
    private static Cell[][] matrix;
    private static Set<Area> areas;

    static {
        areas = new LinkedHashSet<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        initMatrix();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                Cell cell = matrix[row][col];
                if (cell.getValue() == '-' && ! cell.isVisited()) {
                    Area area = new Area(row, col);
                    areas.add(area);
                    findCells(area, row, col);
                }
            }
        }

        AtomicInteger count = new AtomicInteger(1);
        System.out.println(String.format("Total areas found: %d", areas.size()));
        areas.stream()
                .sorted()
                .forEach(area -> System.out.println(getAreaInfo(area, count)));
    }

    private static String getAreaInfo(Area area, AtomicInteger count) {
        return String.format("Area #%d at (%d, %d), size: %d",
                count.getAndIncrement(), area.getStartRow(), area.getStartCol(), area.size());
    }

    private static void findCells(Area area, int row, int col) {
        if (outOfRange(row, col) || matrix[row][col].getValue() != '-' || matrix[row][col].isVisited()) {
            return;
        }
        matrix[row][col].setVisited();
        area.add(matrix[row][col]);
        for (int i = 0; i < 4; i++) {
            findCells(area, row + rowOffset[i], col + colOffset[i]);
        }
    }

    private static boolean outOfRange(int row, int col) {
        return (row < 0 || row >= matrix.length) ||
                (col < 0 || col >= matrix[row].length);
    }

    private static void initMatrix() throws IOException {
        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());
        matrix = new Cell[rows][cols];
        for (int row = 0; row < rows; row++) {
            char[] tokens = reader.readLine().replaceAll("\\s", "").toCharArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = new Cell(tokens[col], row, col);
            }
        }
    }

    private static class Area implements Comparable<Area> {
        private int startRow;
        private int startCol;
        private Set<Cell> cells;

        public Area(int startRow, int startCol) {
            this.startRow = startRow;
            this.startCol = startCol;
            this.cells = new LinkedHashSet<>();
        }

        public int size() {
            return this.cells.size();
        }

        public int getStartCol() {
            return this.startCol;
        }

        public int getStartRow() {
            return this.startRow;
        }

        public void add(Cell cell) {
            cell.setVisited();
            cells.add(cell);
        }

        @Override
        public int compareTo(Area other) {
            int compare = Integer.compare(other.size(), this.size());
            compare = compare != 0 ? compare : Integer.compare(this.startRow, other.startRow);
            return compare != 0 ? compare : Integer.compare(this.startCol, other.startCol);
        }
    }

    private static class Cell {
        private char value;
        private int row;
        private int col;
        private boolean visited;

        public Cell(char value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
            this.visited = false;
        }

        public char getValue() {
            return this.value;
        }

        public boolean isVisited() {
            return this.visited;
        }

        public void setVisited() {
            this.visited = true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (! (o instanceof Cell)) return false;
            Cell cell = (Cell) o;
            return row == cell.row &&
                    col == cell.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
