package L14DefiningClassesExercises.Ex02CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department implements Comparable<Department> {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    void add(Employee employee) {
        this.employees.add(employee);
    }

    private double getAverageSalary() {
        double totalSalary = this.employees.stream()
                .map(Employee::getSalary)
                .reduce(0.0, (a, b) -> a + b);
        return totalSalary / this.employees.size();
    }

    @Override
    public int compareTo(Department other) {
        return Double.compare(other.getAverageSalary(), this.getAverageSalary());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        this.employees
                .stream()
                .sorted()
                .forEach(employee -> output.append(employee).append(System.lineSeparator()));
        return output.toString();
    }
}
