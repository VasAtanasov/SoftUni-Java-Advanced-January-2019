package L05MultidimensionalArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex04SumMatrixElements {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int[] size = getMatrixParams();

        long sum = 0L;
        for (int row = 0; row < size[0]; row++) {
            sum += Arrays
                    .stream(reader.readLine().split(", "))
                    .mapToLong(Long::parseLong)
                    .sum();
        }

        System.out.println(size[0]);
        System.out.println(size[1]);
        System.out.println(sum);

    }

    private static int[] getMatrixParams() throws IOException {
        return Arrays.stream(reader.readLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
