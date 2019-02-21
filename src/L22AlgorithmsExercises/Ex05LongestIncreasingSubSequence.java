package L22AlgorithmsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex05LongestIncreasingSubSequence {
    private static int[] sequence;
    private static int[] len;
    private static int[] prev;
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        initArrays();

        int maxLength = 0;
        int maxIndex = - 1;

        for (int i = 0; i < sequence.length; i++) {
            int bestLength = 1;
            int current = sequence[i];
            int index = - 1;

            for (int j = 0; j < i; j++) {
                if (sequence[j] < current && bestLength < len[j] + 1) {
                    bestLength = len[j] + 1;
                    index = j;
                }
            }

            len[i] = bestLength;
            prev[i] = index;

            if (bestLength > maxLength) {
                maxLength = bestLength;
                maxIndex = i;
            }
        }

        int[] result = new int[maxLength];
        int index = maxLength - 1;
        while (maxIndex != - 1) {
            result[index--] = sequence[maxIndex];
            maxIndex = prev[maxIndex];
        }

        System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));

    }

    private static void initArrays() throws IOException {
        sequence = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        len = new int[sequence.length];
        prev = new int[sequence.length];
    }
}
