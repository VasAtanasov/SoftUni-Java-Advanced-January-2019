package L24ExamPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex02Sneaking {
    private static BufferedReader reader;
    private static Cell sam;
    private static Cell nicoladze;
    private static List<Cell> enemies;
    private static Map<Character, int[]> offsets;
    private static int rows;
    private static int cols;
    private static char[][] maze;

    static {
        enemies = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
        offsets = new HashMap<>() {{
            put('U', new int[] {- 1, 0});
            put('D', new int[] {1, 0});
            put('R', new int[] {0, 1});
            put('L', new int[] {0, - 1});
            put('W', new int[] {0, 0});
        }};
    }

    public static void main(String[] args) throws IOException {
        initMaze();

        char[] commands = reader.readLine().toCharArray();
        for (int i = 0; i < commands.length; i++) {
            char command = commands[i];
            moveEnemies();

            if (samIsKilled()) {
                System.out.println(String.format("Sam died at %d, %d", sam.getRow(), sam.getCol()));
                break;
            }

            moveSam(command);

            isEnemyDead();

            if (isNicoladzeDead()) {
                System.out.println("Nikoladze killed!");
                break;
            }
        }

        printResult();
    }

    private static void printResult() {
        maze[sam.getRow()][sam.getCol()] = sam.getValue();
        maze[nicoladze.getRow()][nicoladze.getCol()] = nicoladze.getValue();
        enemies.forEach(cell -> maze[cell.getRow()][cell.getCol()] = cell.getValue());

        for (int row = 0; row < maze.length; row++) {
            StringBuilder rowOutput = new StringBuilder();
            for (int col = 0; col < maze[row].length; col++) {
                rowOutput.append(maze[row][col]);
            }
            System.out.println(rowOutput.toString());
        }
    }


    private static boolean isNicoladzeDead() {
        if (sam.getRow() == nicoladze.getRow()) {
            nicoladze.setValue('X');
            return true;
        }
        return false;
    }

    private static boolean samIsKilled() {
        Cell enemy = enemies.stream()
                .filter(cell -> cell.getRow() == sam.getRow())
                .findAny()
                .orElse(null);

        if (enemy == null) {
            return false;
        }

        if (enemy.getCol() < sam.getCol() && enemy.getValue() == 'b') {
            sam.setValue('X');
            return true;
        }

        if (enemy.getCol() > sam.getCol() && enemy.getValue() == 'd') {
            sam.setValue('X');
            return true;
        }

        return false;
    }

    private static void moveSam(char command) {
        int[] offset = offsets.get(command);
        sam.setRow(sam.getRow() + offset[0]);
        sam.setCol(sam.getCol() + offset[1]);
    }

    private static void isEnemyDead() {
        enemies.remove(sam);
    }

    private static void moveEnemies() {
        for (Cell enemy : enemies) {
            if (enemy.getCol() == 0 && enemy.getValue() == 'd') {
                enemy.setValue('b');
                continue;
            }

            if (enemy.getCol() == cols - 1 && enemy.getValue() == 'b') {
                enemy.setValue('d');
                continue;
            }

            char value = enemy.getValue();
            int[] offset = offsets.get(getDirection(value));
            int newColl = enemy.getCol() + offset[1];
            enemy.setCol(newColl);
        }
    }

    private static char getDirection(char value) {
        return value == 'b' ? 'R' : 'L';
    }

    private static void initMaze() throws IOException {
        rows = Integer.parseInt(reader.readLine());
        maze = new char[rows][];
        for (int row = 0; row < rows; row++) {
            char[] input = reader.readLine().toCharArray();
            maze[row] = new char[input.length];
            Arrays.fill(maze[row], '.');
            for (int col = 0; col < input.length; col++) {
                char ch = input[col];
                if (ch == 'S') {
                    sam = new Cell(row, col, ch);
                } else if (ch == 'N') {
                    nicoladze = new Cell(row, col, ch);
                } else if (ch == 'b' || ch == 'd') {
                    enemies.add(new Cell(row, col, ch));
                }
            }
            cols = input.length;
        }
    }

    private static class Cell {
        private int row;
        private int col;
        private char value;

        public Cell(int row, int col, char value) {
            this.value = value;
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }

        public char getValue() {
            return this.value;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public void setValue(char value) {
            this.value = value;
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
