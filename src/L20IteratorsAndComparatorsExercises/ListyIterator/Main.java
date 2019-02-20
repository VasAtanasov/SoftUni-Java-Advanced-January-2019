package L20IteratorsAndComparatorsExercises.ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static BufferedReader reader;
    private static final String END_COMMAND = "END";
    private static ListyIterator<String> listyIterator;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! END_COMMAND.equals(input = reader.readLine())) {
            String[] strings = input.split("\\s+");
            String command = strings[0];
            switch (command) {
                case "Create":
                    //noinspection unchecked
                    listyIterator = new ListyIterator(Arrays.stream(strings).skip(1).toArray());
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        System.out.println(listyIterator.peek());
                    } catch (Exception ex) {
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case "PrintAll":
                    System.out.println(String.join(" ", listyIterator));
                    break;
            }
        }

    }
}
