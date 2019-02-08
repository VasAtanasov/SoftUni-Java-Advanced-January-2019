package L18GenericsExercises.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static BufferedReader reader;

    static {

        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
//        ex01GenericBox();
//        ex02GenericBoxOfIntegers();
//        ex03GenericSwapStrings();
//        ex04GenericSwapIntegers();
//        ex05GenericCountStrings();
//        ex06GenericCountDoubles();

    }

    private static void ex06GenericCountDoubles() throws IOException {
        Shelf<Box<Double>> shelf = readBoxOfDoubles();
        Box<Double> element = new Box<>(Double.parseDouble(reader.readLine()));
        filterShelf(shelf, element);
        System.out.println(shelf.size());
    }

    private static void ex05GenericCountStrings() throws IOException {
        Shelf<Box<String>> shelf = readBoxOfStrings();
        Box<String> element = new Box<>(reader.readLine());
        filterShelf(shelf, element);
        System.out.println(shelf.size());
    }

    private static <T extends Comparable<T>> void filterShelf(Shelf<T> shelf, T box) {
        shelf.filter(box);
    }

    private static void ex04GenericSwapIntegers() throws IOException {
        Shelf<Box<Integer>> shelf = readBoxOfIntegers();
        swapElements(shelf);
        print(shelf);
    }

    private static void ex03GenericSwapStrings() throws IOException {
        Shelf<Box<String>> shelf = readBoxOfStrings();
        swapElements(shelf);
        print(shelf);
    }

    private static void ex02GenericBoxOfIntegers() throws IOException {
        Shelf<Box<Integer>> shelf = readBoxOfIntegers();
        print(shelf);
    }

    private static void ex01GenericBox() throws IOException {
        Shelf<Box<String>> shelf = readBoxOfStrings();
        print(shelf);
    }

    private static <T extends Comparable<T>> void swapElements(Shelf<T> shelf) throws IOException {
        int[] indexes = Arrays
                .stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        shelf.swap(indexes[0], indexes[1]);
    }

    private static Shelf<Box<Double>> readBoxOfDoubles() throws IOException {
        Shelf<Box<Double>> shelf = new ShelfImpl<>();

        int n = getN();
        for (int i = 0; i < n; i++) {
            shelf.add(new Box<>(Double.parseDouble(reader.readLine())));
        }
        return shelf;
    }

    private static Shelf<Box<Integer>> readBoxOfIntegers() throws IOException {
        Shelf<Box<Integer>> shelf = new ShelfImpl<>();

        int n = getN();
        for (int i = 0; i < n; i++) {
            shelf.add(new Box<>(Integer.parseInt(reader.readLine())));
        }
        return shelf;
    }

    private static Shelf<Box<String>> readBoxOfStrings() throws IOException {
        Shelf<Box<String>> shelf = new ShelfImpl<>();
        int n = getN();
        for (int i = 0; i < n; i++) {
            shelf.add(new Box<>(reader.readLine()));
        }
        return shelf;
    }

    private static <T extends Comparable<T>> void print(Shelf<T> shelf) {
        shelf.forEach(System.out::println);
    }

    private static int getN() throws IOException {
        return Integer.parseInt(reader.readLine());
    }
}
