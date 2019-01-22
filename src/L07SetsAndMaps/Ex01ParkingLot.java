package L07SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Ex01ParkingLot {
    private static BufferedReader reader;
    private static Set<String> parkingLot;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        parkingLot = new HashSet<>();
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! "END".equals(input = reader.readLine())) {
            String[] tokens = input.split(", ");
            String command = tokens[0];
            String carNumber = tokens[1];

            switch (command) {
                case "IN":
                    parkingLot.add(carNumber);
                    break;
                case "OUT":
                    parkingLot.remove(carNumber);
                    break;
            }
        }


        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parkingLot.forEach(System.out::println);
        }

    }
}
