package L20IteratorsAndComparatorsExercises.Ex09LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Main {
    private static DoublyLinkedList<Integer> list;
    private static BufferedReader reader;

    private enum Command {
        Add, Remove
    }

    static {
        list = new DoublyLinkedList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            Command command = Command.valueOf(tokens[0]);
            int element = Integer.parseInt(tokens[1]);
            switch (command) {
                case Add:
                    list.addLast(element);
                    break;
                case Remove:
                    list.remove(element);
                    break;
            }
        }

        System.out.println(list.getSize());

        StringBuilder output = new StringBuilder();
        for (Integer integer : list) {
            output.append(integer).append(" ");
        }
        System.out.println(output.toString());
    }
}
