package L22AlgorithmsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex01ReverseArray {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(Arrays.toString(reverseArray(numbers)).replaceAll("[\\[\\],]",""));
    }

    private static int[] reverseArray(int[] array) {
        return reverseArray(array.clone(), 0, array.length - 1);
    }

    private static int[] reverseArray(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) { // base condition, nothing to do when there is one or no element to consider
            return array;
        }
        // swap array[startIndex] and array[endIndex]
        int temp = array[startIndex];
        array[startIndex] = array[endIndex];
        array[endIndex] = temp;
        // recurse with the decreasing bounds
        return reverseArray(array, startIndex + 1, endIndex - 1);
    }

}
