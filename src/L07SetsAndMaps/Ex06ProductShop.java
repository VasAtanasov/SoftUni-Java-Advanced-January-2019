package L07SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Ex06ProductShop {
    private static final String END_COMMAND = "Revision";

    private static Map<String, Shop> shopTreeMap;
    private static BufferedReader reader;

    static {
        shopTreeMap = new TreeMap<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (!END_COMMAND.equals(input = reader.readLine())) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shopTreeMap.putIfAbsent(shop, new Shop(shop));
            shopTreeMap.get(shop).add(new Product(product, price));
        }

        shopTreeMap.values().forEach(System.out::println);
    }

    private static class Shop {
        private String shopName;
        private List<Product> products;

        Shop(String shopName) {
            this.shopName = shopName;
            this.products = new ArrayList<>();
        }

        void add(Product product) {
            this.products.add(product);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(this.shopName + "->");
            if (this.products.isEmpty()) {
                return sb.toString();
            }
            sb.append(System.lineSeparator());
            products.forEach(product -> sb.append(product).append(System.lineSeparator()));
            return sb.toString().trim();
        }
    }

    private static class Product {
        private String productName;
        private double price;

        Product(String productName, double price) {
            this.productName = productName;
            this.price = price;
        }

        @Override
        public String toString() {
            return String.format("Product: %s, Price: %.1f", this.productName, this.price);
        }
    }

}
