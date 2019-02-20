package Z_DemoExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Ex01Socks {
    private static List<Integer> pairs;
    private static BufferedReader reader;
    private static int maxPair = Integer.MIN_VALUE;

    static {
        pairs = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        Deque<Integer> leftSocks = readInput();
        Deque<Integer> rightSocks = readInput();

        while (! leftSocks.isEmpty() && ! rightSocks.isEmpty()) {
            int leftSock = leftSocks.removeLast();
            int rightSock = rightSocks.removeFirst();

            if (leftSock > rightSock) {
                int pair = leftSock + rightSock;
                pairs.add(pair);
                if (pair > maxPair) {
                    maxPair = pair;
                }
            } else if (rightSock > leftSock) {
                rightSocks.addFirst(rightSock);
            } else {
                leftSocks.addLast(leftSock + 1);
            }
        }

        System.out.println(maxPair);
        System.out.println(pairs.stream().map(Objects::toString).collect(Collectors.joining(" ")));
    }

    private static Deque<Integer> readInput() throws IOException {
        return Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

}
