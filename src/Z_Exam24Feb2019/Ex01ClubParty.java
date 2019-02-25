package Z_Exam24Feb2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Ex01ClubParty {
    private static BufferedReader reader;
    private static int capacity;
    private static Map<String, List<Integer>> halls;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        halls = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        capacity = Integer.parseInt(reader.readLine());

        String[] tokens = reader.readLine().split("\\s+");

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (token.matches("[A-Za-z]+")) {
                halls.putIfAbsent(token, new ArrayList<>());
            } else if (token.matches("[0-9]+")) {
                int reservations = Integer.parseInt(token);
                List<String> toRemove = new ArrayList<>();
                accommodateReservations(reservations, toRemove);
                removeOverflowedHalls(toRemove);
            }
        }
    }

    private static void removeOverflowedHalls(List<String> toRemove) {
        for (String hall : toRemove) {
            System.out.println(
                    String.format("%s -> %s", hall, listToString(halls.remove(hall)))
            );
        }
    }

    private static String listToString(List<Integer> hall) {
        return hall.toString().replaceAll("[\\[\\]]", "");
    }

    private static void accommodateReservations(int reservations, List<String> toRemove) {
        for (Map.Entry<String, List<Integer>> entry : halls.entrySet()) {
            int occupiedSpaces = getSum(entry.getValue());
            if (occupiedSpaces + reservations > capacity) {
                toRemove.add(entry.getKey());
            } else if (occupiedSpaces + reservations <= capacity) {
                entry.getValue().add(reservations);
                break;
            }
        }
    }

    private static int getSum(List<Integer> reservations) {
        return reservations
                .stream()
                .reduce((a, b) -> a + b)
                .orElse(0);
    }
}
