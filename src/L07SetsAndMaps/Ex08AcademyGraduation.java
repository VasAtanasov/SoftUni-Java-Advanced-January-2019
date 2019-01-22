package L07SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ex08AcademyGraduation {
    private static BufferedReader reader;
    private static Map<String, Student> students;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        students = new TreeMap<>();
    }

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String name = reader.readLine();
            List<Double> grades = Arrays.stream(reader.readLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toCollection(ArrayList::new));

            students.putIfAbsent(name, new Student(name));
            students.get(name).addGrades(grades);
        }


        students.values().forEach(System.out::println);
    }
}

class Student {
    private String name;
    private List<Double> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    void addGrades(List<Double> grades) {
        this.grades.addAll(grades);
    }

    private double getAverage() {
        double sum = 0.0;
        for (Double grade : this.grades) {
            sum += grade;
        }
        return sum / grades.size();

    }

    @Override
    public String toString() {
        return String.format("%s is graduated with %s", this.name, this.getAverage());
    }
}
