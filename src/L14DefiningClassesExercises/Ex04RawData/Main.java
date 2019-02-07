package L14DefiningClassesExercises.Ex04RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader reader;
    private static List<Car> cars;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        cars = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        getCars();

        String cargoType = reader.readLine();

        switch (cargoType) {
            case "fragile":
                cars.stream()
                        .filter(car -> car.getCargoType().equals("fragile"))
                        .filter(Car::isValidTierPressure)
                        .forEach(System.out::println);
                break;
            case "flamable":
                cars.stream()
                        .filter(car -> car.getCargoType().equals("flamable"))
                        .filter(Car::isValidEnginePower)
                        .forEach(System.out::println);
                break;
        }
    }

    private static void getCars() throws IOException {
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            cars.add(new Car(tokens));
        }
    }
}
