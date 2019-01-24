package L08SetsAndMapsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex12LegendaryFarming {
    private static Map<String, Collectible> materials;
    private static Map<String, String> uniqueMaterial;
    private static final String MOTES = "motes";
    private static final String SHARDS = "shards";
    private static final String FRAGMENTS = "fragments";

    static {
        materials = new LinkedHashMap<String, Collectible>() {{
            put(FRAGMENTS, new UniqueMaterial(FRAGMENTS));
            put(SHARDS, new UniqueMaterial(SHARDS));
            put(MOTES, new UniqueMaterial(MOTES));
        }};
        uniqueMaterial = new HashMap<String, String>() {{
            put(SHARDS, "Shadowmourne");
            put(FRAGMENTS, "Valanyr");
            put(MOTES, "Dragonwrath");
        }};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isObtained = false;

        while (! isObtained) {
            String[] tokens = reader.readLine().toLowerCase().split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {
                int amount = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1];

                switch (material) {
                    case FRAGMENTS:
                    case SHARDS:
                    case MOTES:
                        materials.get(material).updateQuantity(amount);
                        break;
                    default:
                        materials.putIfAbsent(material, new Junk(material));
                        materials.get(material).updateQuantity(amount);
                        break;
                }

                if (materials.get(material).isObtained()) {
                    isObtained = true;
                    System.out.println(String.format("%s obtained!", uniqueMaterial.get(materials.get(material).getType())));
                    materials.get(material).updateQuantity(- 250);
                    break;
                }
            }
        }


        printUniqueMaterials();
        printJunk();
    }

    private static void printJunk() {
        materials.values().stream()
                .filter(m -> ! uniqueMaterial.containsKey(m.getType()))
                .sorted()
                .forEach(System.out::println);
    }

    private static void printUniqueMaterials() {
        materials.values().stream()
                .filter(m -> uniqueMaterial.containsKey(m.getType()))
                .sorted()
                .forEach(System.out::println);
    }

    private interface Collectible {
        default boolean isObtained() {
            return false;
        }

        String getType();

        void updateQuantity(int material);
    }

    private static class UniqueMaterial implements Collectible, Comparable<UniqueMaterial> {
        private String type;
        private int quantity;

        UniqueMaterial(String type) {
            this.type = type;
            this.quantity = 0;
        }

        @Override
        public String getType() {
            return this.type;
        }

        private int getQuantity() {
            return this.quantity;
        }

        @Override
        public boolean isObtained() {
            return quantity >= 250;
        }

        @Override
        public void updateQuantity(int material) {
            this.quantity += material;
        }

        @Override
        public int compareTo(UniqueMaterial other) {
            int index = Integer.compare(other.getQuantity(), this.getQuantity());
            return index != 0 ? index : this.getType().compareTo(other.getType());
        }

        @Override
        public String toString() {
            return String.format("%s: %d", this.getType(), this.getQuantity());
        }
    }

    private static class Junk implements Collectible, Comparable<Junk> {
        private String type;
        private int quantity;

        Junk(String type) {
            this.type = type;
            this.quantity = 0;
        }

        @Override
        public String getType() {
            return this.type;
        }

        private int getQuantity() {
            return this.quantity;
        }

        @Override
        public void updateQuantity(int material) {
            this.quantity += material;
        }

        @Override
        public String toString() {
            return String.format("%s: %d", this.getType(), this.getQuantity());
        }

        @Override
        public int compareTo(Junk other) {
            return this.getType().compareTo(other.getType());
        }
    }
}





