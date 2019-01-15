package L04StacksAndQueuesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex10PoisonousPlants {
    private static BufferedReader reader;
    private static long[] plants;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        plants = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToLong(Long::parseLong)
                .toArray();

        int[] days = new int[plants.length];
        Stack<Integer> proximityStack = new Stack<>();
        proximityStack.push(0);

        for (int i = 1; i < plants.length; i++) {
            int maxDays = 0;

            while (proximityStack.size() > 0 && plants[proximityStack.peek()] >= plants[i]) {
                maxDays = Math.max(maxDays, days[proximityStack.pop()]);
            }
            if (proximityStack.size() > 0) {
                days[i] = maxDays + 1;
            }
            proximityStack.push(i);
        }

        System.out.println(Arrays.stream(days).max().getAsInt());
    }


}

