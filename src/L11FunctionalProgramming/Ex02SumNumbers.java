package L11FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class Ex02SumNumbers {
    private static BufferedReader reader;
    private static int sum;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        sum = 0;
    }

    public static void main(String[] args) throws IOException {
       long count =  Arrays.stream(reader.readLine().split("[,\\s]+"))
                .filter(s -> ! s.isEmpty())
                .map(s -> parse.apply(s))
                .peek(n -> sum += n)
                .count();

        System.out.println(String.format("Count = %d",count));
        System.out.println(String.format("Sum = %d",sum));

    }

    private static Function<String, Integer> parse = Integer::parseInt;
}
