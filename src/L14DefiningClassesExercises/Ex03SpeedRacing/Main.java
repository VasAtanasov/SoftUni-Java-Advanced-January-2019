package L14DefiningClassesExercises.Ex03SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static BufferedReader reader;
    private static Map<String, Car> models;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        models = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        getCars();

        String input;
        while (! "End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String model = tokens[1];
            double distance = Double.parseDouble(tokens[2]);

            if (! models.get(model).drive(distance)) {
                System.out.println("Insufficient fuel for the drive");
            }
        }

        models.values()
                .forEach(System.out::println);


    }

    private static void getCars() throws IOException {
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double consumptionPerKm = Double.parseDouble(tokens[2]);

            models.put(model, new Car(model, fuel, consumptionPerKm));
        }
    }
}
