package L11FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class Ex04AddVAT {
    private static BufferedReader reader;
    private static UnaryOperator<Double> addVat = n -> n * 1.2;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Prices with VAT:");
        Arrays.stream(reader.readLine().split("[,\\s]+"))
                .filter(s -> ! s.isEmpty())
                .map(Double::parseDouble)
                .map(n -> addVat.apply(n))
                .forEach(n -> System.out.println(String.format("%.2f",n)));
    }

}
