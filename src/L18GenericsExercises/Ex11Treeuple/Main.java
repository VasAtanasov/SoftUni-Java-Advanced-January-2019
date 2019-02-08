package L18GenericsExercises.Ex11Treeuple;

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
        Treeuple<String, String, String> firstTuple = new Treeuple<>(firstLine[0] + " " + firstLine[1], firstLine[2], firstLine[3]);

        String[] secondLine = reader.readLine().split("\\s+");
        Treeuple<String, String, Boolean> secondTuple = new Treeuple<>(secondLine[0], secondLine[1], secondLine[2].equals("drunk"));

        String[] thirdLine = reader.readLine().split("\\s+");
        Treeuple<String, Double, String> thirdTuple = new Treeuple<>(
                thirdLine[0], Double.parseDouble(thirdLine[1]), thirdLine[2]);


        System.out.println(firstTuple);
        System.out.println(secondTuple);
        System.out.println(thirdTuple);
    }
}
