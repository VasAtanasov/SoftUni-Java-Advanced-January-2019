package L14DefiningClassesExercises.Ex09CatLady;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static BufferedReader reader;
    private static Map<String, Cat> cats;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        cats = new HashMap<>();
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            double value = Double.parseDouble(tokens[2]);

            Cat cat = null;
            switch (type) {
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, value);
                    break;
                case "Siamese":
                    cat = new Siamese(name, value);
                    break;
                case "Cymric":
                    cat = new Cymric(name, value);
                    break;
            }

            if (cat != null) {
                cats.put(name, cat);
            }
        }


        String catName = reader.readLine();

        if (cats.containsKey(catName)) {
            System.out.println(cats.get(catName));
        }
    }
}
