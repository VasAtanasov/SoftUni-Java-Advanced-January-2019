package L18GenericsExercises.Ex10Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String[] firstLine = reader.readLine().split("\\s+");
        Tuple<String, String> firstTuple = new Tuple<>(firstLine[0] + " " + firstLine[1], firstLine[2]);

        String[] secondLine = reader.readLine().split("\\s+");
        Tuple<String, String> secondTuple = new Tuple<>(secondLine[0], secondLine[1]);

        String[] thirdLine = reader.readLine().split("\\s+");
        Tuple<Integer, Double> thirdTuple = new Tuple<>(
                Integer.parseInt(thirdLine[0]), Double.parseDouble(thirdLine[1]));


        System.out.println(firstTuple);
        System.out.println(secondTuple);
        System.out.println(thirdTuple);
    }
}
