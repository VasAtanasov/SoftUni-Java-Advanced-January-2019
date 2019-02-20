package L21Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex01RecursiveArraySum {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

//        System.out.println(sumOfArray(numbers, numbers.length - 1));
        System.out.println(sum(numbers));
    }

    private static int sumOfArray(int[] a, int n) {
        if (n == 0) return a[n];
        return a[n] + sumOfArray(a, n - 1);
    }

    public static int sum(int[] array) {
        if (array.length == 1) return array[0];
        int[] subArr = Arrays.copyOfRange(array, 1, array.length);
        return array[0] + sum(subArr);
    }
}
