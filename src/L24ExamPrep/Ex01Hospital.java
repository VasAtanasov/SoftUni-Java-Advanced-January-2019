package L24ExamPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ex01Hospital {
    private static final String END = "End";
    private static final String OUTPUT = "Output";

    private static BufferedReader reader;
    private static Map<String, List<Person>> byDoctor;
    private static Map<String, Department> byDepartments;

    static {
        byDepartments = new HashMap<>();
        byDoctor = new LinkedHashMap<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        accommodatePatients();
        generateInfo();
    }

    private static void generateInfo() throws IOException {
        String input;
        while (! END.equals(input = reader.readLine())) {
            if (byDepartments.containsKey(input)) {

                byDepartments.get(input).getPatients().forEach(System.out::println);

            } else if (byDoctor.containsKey(input)) {

                byDoctor.get(input).stream().sorted().forEach(System.out::println);

            } else {

                String[] tokens = input.split("\\s+");
                String department = tokens[0];
                int room = Integer.parseInt(tokens[1]);
                byDepartments.get(department).getPatients(room).forEach(System.out::println);
            }
        }
    }

    private static void accommodatePatients() throws IOException {
        String input;
        while (! OUTPUT.equals(input = reader.readLine())) {
            int firstSpace = input.indexOf(" ");
            int lastSpace = input.lastIndexOf(" ");

            String departmentName = input.substring(0, firstSpace);
            String doctorFullName = input.substring(firstSpace + 1, lastSpace);
            String patientName = input.substring(lastSpace + 1);

            if (byDepartments.containsKey(departmentName) && ! byDepartments.get(departmentName).isFreeBed()) {
                continue;
            }

            Person patient = new Person(patientName);
            byDepartments.putIfAbsent(departmentName, new Department());
            byDepartments.get(departmentName).add(patient);

            byDoctor.putIfAbsent(doctorFullName, new ArrayList<>());
            byDoctor.get(doctorFullName).add(patient);
        }
    }

    private static class Department {
        private static final int DEPARTMENT_CAPACITY = 60;

        private List<Person> rooms;

        public Department() {
            this.rooms = new ArrayList<>();
        }

        public boolean isFreeBed() {
            return DEPARTMENT_CAPACITY - this.rooms.size() > 0;
        }

        public boolean add(Person patient) {
            if (this.rooms.size() >= DEPARTMENT_CAPACITY) {
                return false;
            }
            return this.rooms.add(patient);
        }

        public List<Person> getPatients() {
            return Collections.unmodifiableList(this.rooms);
        }

        public List<Person> getPatients(int room) {
            int to = (room * 3);
            int from = (room * 3) - 3;
            return this.rooms.subList(from, to)
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
        }
    }

    private static class Person implements Comparable<Person> {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public int compareTo(Person other) {
            return this.getName().compareTo(other.getName());
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
