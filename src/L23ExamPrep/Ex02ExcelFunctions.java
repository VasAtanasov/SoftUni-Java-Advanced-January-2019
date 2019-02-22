package L23ExamPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex02ExcelFunctions {
    private static BufferedReader reader;
    private static List<Row> rows;
    private static List<String> headers;

    private enum Command {
        hide, sort, filter
    }

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        rows = new ArrayList<>();
    }

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(reader.readLine());
        headers = Arrays.stream(reader.readLine().split(", "))
                .collect(Collectors.toCollection(ArrayList::new));

        for (int row = 1; row < size; row++) {
            String[] tokens = reader.readLine().split(", ");
            Row tableRow = new Row();
            rows.add(tableRow);
            for (int col = 0; col < tokens.length; col++) {
                tableRow.add(new Col(headers.get(col), tokens[col]));
            }
        }

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
        System.out.println(String.join(" | ", headers));
        if (rows.isEmpty()) {
            return;
        }
        System.out.println(rows.stream()
                .filter(row -> {
                    Col col = row.getCols().get(headerIndex);
                    boolean isCorrectHeader = col.getHeader().equals(header);
                    boolean isCorrectValue = col.getValue().equals(value);
                    return isCorrectHeader && isCorrectValue;
                })
                .map(row -> row.getCols().stream().map(Col::toString).collect(Collectors.joining(" | ")))
                .collect(Collectors.joining("\n")));
    }

    private static void sortColumns(int colIndex) {
        if (rows.isEmpty()) {
            return;
        }
        System.out.println(String.join(" | ", headers));
        System.out.println(rows.stream()
                .sorted(Comparator.comparing(a -> a.getCols().get(colIndex)))
                .map(row -> row.getCols().stream().map(Col::toString).collect(Collectors.joining(" | ")))
                .collect(Collectors.joining("\n")));
    }

    private static void hideColumns(String header) {
        headers.remove(header);
        System.out.println(String.join(" | ", headers));
        for (Row row : rows) {
            System.out.println(row
                    .getCols()
                    .stream()
                    .filter(col -> ! col.getHeader().equals(header))
                    .map(Col::toString)
                    .collect(Collectors.joining(" | ")));
        }
    }

    private static class Row {
        private List<Col> cols;

        public Row() {
            this.cols = new ArrayList<>();
        }

        public void add(Col col) {
            this.cols.add(col);
        }

        public List<Col> getCols() {
            return this.cols;
        }
    }

    private static class Col implements Comparable<Col> {
        private String header;
        private String value;

        public Col(String header, String value) {
            this.header = header;
            this.value = value;
        }

        public String getHeader() {
            return this.header;
        }

        public String getValue() {
            return this.value;
        }

        @Override
        public int compareTo(Col o) {
            return this.value.compareTo(o.value);
        }

        @Override
        public String toString() {
            return this.value;
        }
    }
}
