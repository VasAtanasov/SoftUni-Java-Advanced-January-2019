package L14DefiningClassesExercises.Ex05CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static BufferedReader reader;
    private static Map<String, Engine> engines;
    private static List<Car> cars;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        engines = new LinkedHashMap<>();
        cars = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        getEngines();
        getCars();

        cars.forEach(System.out::print);

    }

    private static void getCars() throws IOException {
        int m = Integer.parseInt(reader.readLine());
        while (m-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            Engine engine = engines.get(tokens[1]);
            switch (tokens.length) {
                case 4:
                    cars.add(new Car(model, engine, tokens[2], tokens[3]));
                    break;
                case 3:
                    cars.add(new Car(model, engine, tokens[2]));
                    break;
                case 2:
                    cars.add(new Car(model, engine));
                    break;
            }
        }
    }

    private static void getEngines() throws IOException {
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String model = tokens[0];
            String power = tokens[1];
            switch (tokens.length) {
                case 4:
                    engines.put(model, new Engine(model, power, tokens[2], tokens[3]));
                    break;
                case 3:
                    engines.put(model, new Engine(model, power, tokens[2]));
                    break;
                case 2:
                    engines.put(model, new Engine(model, power));
                    break;
            }
        }
    }
}
