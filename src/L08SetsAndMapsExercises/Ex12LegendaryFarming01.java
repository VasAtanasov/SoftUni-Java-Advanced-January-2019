package L08SetsAndMapsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex12LegendaryFarming01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> uniqueElements = new HashMap<>();
        HashMap<String, Integer> junk = new HashMap<>();

        uniqueElements.put("shards", 0);
        uniqueElements.put("fragments", 0);
        uniqueElements.put("motes", 0);

        boolean isFarming = true;
        String winner = "";

        while (isFarming) {
            String[] tokens = reader.readLine().toLowerCase().split("\\s+");


            for (int i = 0; i < tokens.length; i += 2) {
                if (! isFarming) {
                    break;
                }
                int amount = Integer.valueOf(tokens[i]);
                String material = tokens[i + 1];

                switch (material) {
                    case "shards":
                        int shards = uniqueElements.get(material) + amount;
                        uniqueElements.put(material, shards);
                        break;
                    case "fragments":
                        int fragments = uniqueElements.get(material) + amount;
                        uniqueElements.put(material, fragments);
                        break;
                    case "motes":
                        int motes = uniqueElements.get(material) + amount;
                        uniqueElements.put(material, motes);
                        break;
                    default:
                        junk.putIfAbsent(material, 0);
                        int total = junk.get(material) + amount;
                        junk.put(material, total);

                }

                for (Map.Entry<String, Integer> element : uniqueElements.entrySet()) {
                    if (element.getValue() >= 250) {
                        winner = element.getKey();
                        int left = element.getValue() - 250;
                        uniqueElements.put(element.getKey(), left);
                        isFarming = false;
                    }
                }


            }
        }

        switch (winner) {
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }

        uniqueElements.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int index = Integer.compare(Math.abs(b.getValue()), Math.abs(a.getValue()));
                    if (index == 0) {
                        index = a.getKey().compareToIgnoreCase(b.getKey());
                    }
                    return index;
                })
                .forEach(e -> {
                    System.out.println(String.format("%s: %d", e.getKey(), e.getValue()));
                });

        junk.entrySet()
                .stream()
                .sorted((a, b) -> a.getKey().compareToIgnoreCase(b.getKey()))
                .forEach(e -> {
                    System.out.println(String.format("%s: %d", e.getKey(), e.getValue()));
                });

    }
}


