package L08SetsAndMapsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;

public class Ex14DragonArmy {
    private static Map<String, TreeMap<String, Dragon>> dragons;

    static {
        dragons = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < lines; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            String damage = tokens[2];
            String health = tokens[3];
            String armor = tokens[4];

            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).put(name, new Dragon(name, damage, health, armor));
        }

        dragons.forEach((t, d) -> {
            System.out.println(String.format("%s::%s", t, getStats.apply(d)));
            d.values().forEach(System.out::println);
        });
    }

    private static Function<TreeMap<String, Dragon>, String> getStats = dragon -> {
        double damage = dragon.values().stream().mapToDouble(Dragon::getDamage).average().orElse(0.0);
        double health = dragon.values().stream().mapToDouble(Dragon::getHealth).average().orElse(0.0);
        double armor = dragon.values().stream().mapToDouble(Dragon::getArmor).average().orElse(0.0);
        return String.format("(%.2f/%.2f/%.2f)", damage, health, armor);
    };

    private static class Dragon {
        private String name;
        private int damage;
        private int health;
        private int armor;

        Dragon(String name, String damage, String health, String armor) {
            this.name = name;
            this.setDamage(damage);
            this.setHealth(health);
            this.setArmor(armor);
        }

        public String getName() {
            return this.name;
        }

        int getDamage() {
            return this.damage;
        }

        int getHealth() {
            return this.health;
        }

        int getArmor() {
            return this.armor;
        }

        private void setDamage(String damage) {
            this.damage = damage.equals("null") ? 45 : Integer.parseInt(damage);
        }

        private void setHealth(String health) {
            this.health = health.equals("null") ? 250 : Integer.parseInt(health);
        }

        private void setArmor(String armor) {
            this.armor = armor.equals("null") ? 10 : Integer.parseInt(armor);
        }

        @Override
        public String toString() {
            return String.format("-%s -> damage: %d, health: %d, armor: %d", this.getName(), this.getDamage(), this.getHealth(), this.getArmor());
        }
    }
}


