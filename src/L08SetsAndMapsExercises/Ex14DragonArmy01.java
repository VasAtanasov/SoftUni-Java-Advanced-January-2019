package L08SetsAndMapsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Ex14DragonArmy01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        LinkedHashMap<String, TreeMap<String, Integer[]>> dragonStats = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String type = tokens[0];
            String dragon = tokens[1];
            int damage = tokens[2].equals("null") ? 45 : Integer.valueOf(tokens[2]);
            int health = tokens[3].equals("null") ? 250 : Integer.valueOf(tokens[3]);
            int armor = tokens[4].equals("null") ? 10 : Integer.valueOf(tokens[4]);

            dragonStats.putIfAbsent(type, new TreeMap<>());

            Integer[] stats = new Integer[3];
            stats[0] = damage;
            stats[1] = health;
            stats[2] = armor;
            dragonStats.get(type).put(dragon, stats);
        }

        dragonStats.forEach((type, dragon) -> {
            double averageDamage = dragon.values().stream().mapToDouble(e -> e[0]).sum() / dragon.size();
            double averageHealth = dragon.values().stream().mapToDouble(e -> e[1]).sum() / dragon.size();
            double averageArmor = dragon.values().stream().mapToDouble(e -> e[2]).sum() / dragon.size();
            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", type, averageDamage, averageHealth, averageArmor));
            dragon.forEach((name, stats) -> {
                System.out.println(String.format("-%s -> damage: %d, health: %d, armor: %d", name,
                        stats[0], stats[1], stats[2]));
            });


        });

    }
}

