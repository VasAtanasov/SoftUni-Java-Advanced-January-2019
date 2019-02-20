package L21Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02RecursiveFactorial {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        System.out.println(fact(n));
    }

    private static int fact(int n) {
        int result;
        if (n == 0 || n == 1) return 1;
        result = fact(n - 1) * n;
        return result;
    }
}
