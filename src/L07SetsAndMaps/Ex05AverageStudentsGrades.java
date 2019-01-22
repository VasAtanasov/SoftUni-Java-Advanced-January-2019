package L07SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ex05AverageStudentsGrades {

    private static Map<String, StudentRecord> records;
    private static BufferedReader reader;

    static {
        records = new TreeMap<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int lines = Integer.parseInt(reader.readLine());
        while (lines-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String studentName = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            records.putIfAbsent(studentName, new StudentRecord(studentName));
            records.get(studentName).add(grade);
        }

        records.values().forEach(System.out::println);

    }

    private static class StudentRecord {
        private String owner;
        private List<Double> grades;

        StudentRecord(String owner) {
            this.owner = owner;
            this.grades = new ArrayList<>();
        }

        void add(double grade) {
            this.grades.add(grade);
        }

        private double getAverage() {
            return this.grades.stream()
                    .mapToDouble(i -> i)
                    .average()
                    .orElse(0.0);
        }

        private String getGradesString() {
            return this.grades
                    .stream()
                    .map(grade -> String.format("%.2f", grade))
                    .collect(Collectors.joining(" "));
        }

        @Override
        public String toString() {
            return String.format("%s -> %s (avg: %.2f)", this.owner, this.getGradesString(), this.getAverage());
        }
    }
}
