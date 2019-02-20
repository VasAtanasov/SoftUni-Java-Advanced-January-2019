package L21Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ex03SumOfCoins {
    private static BufferedReader reader;
    private static Map<Long, Long> coinsCount;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        coinsCount = new TreeMap<>(Comparator.reverseOrder());
    }

    public static void main(String[] args) throws IOException {
        Deque<Long> coins = Arrays
                .stream(reader.readLine()
                        .replaceAll("[,]", "")
                        .replaceAll("Coins: ", "")
                        .split("\\s+")
                )
                .filter(s -> ! s.isEmpty())
                .map(Long::parseLong)
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(ArrayDeque::new));

        long sum = Integer.parseInt(reader.readLine().replaceAll("Sum: ", ""));

        while (! coins.isEmpty()) {
            long coin = coins.removeLast();
            long times = sum  / coin;
            if (times == 0) {
                continue;
            }
            coinsCount.putIfAbsent(coin, times);
            sum -= (times * coin);
        }

        if (sum == 0) {
            printResult();
        } else {
            System.out.println("Error");
        }
    }

    private static void printResult() {
        long totalCount = coinsCount
                .values()
                .stream()
                .reduce((a, b) -> a + b).orElse(0L);

        System.out.println(String.format("Number of coins to take: %d", totalCount));

        List<String> result = new ArrayList<>(coinsCount.size());

        coinsCount.forEach((coin, times) -> result.add(String.format("%d coin(s) with value %d", times, coin)));

        System.out.println(String.join("\n", result));
    }
}
