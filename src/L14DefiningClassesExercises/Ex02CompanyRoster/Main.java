package L14DefiningClassesExercises.Ex02CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    private static BufferedReader reader;
    private static Map<String, Department> departments;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        departments = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        getEmployees();

        Optional<String> department = departments
                .values()
                .stream()
                .sorted()
                .findFirst()
                .map(Department::getName);

        if (department.isPresent()) {
            System.out.println(String.format("Highest Average Salary: %s", department.get()));
            System.out.println(departments.get(department.get()));
        }


    }

    private static void getEmployees() throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            departments.putIfAbsent(department, new Department(department));
            if (tokens.length == 4) {
                departments.get(department).add(new Employee(name, salary, position, department));
            } else if (tokens.length == 6) {
                String email = tokens[4];
                int age = Integer.parseInt(tokens[5]);
                departments.get(department).add(new Employee(name, salary, position, department, email, age));
            } else {
                String token = tokens[4];
                if (isNumber(token)) {
                    int age = Integer.parseInt(token);
                    departments.get(department).add(new Employee(name, salary, position, department, age));
                } else {
                    departments.get(department).add(new Employee(name, salary, position, department, token));
                }
            }
        }
    }

    private static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

//    private static boolean isNumber(String token) {
//        for (int i = 0; i < token.length(); i++) {
//            if (! Character.isDigit(token.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
//    }
}
