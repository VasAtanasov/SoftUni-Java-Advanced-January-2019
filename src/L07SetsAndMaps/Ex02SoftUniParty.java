package L07SetsAndMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Ex02SoftUniParty {
    private static BufferedReader reader;
    private static Set<String> registeredGuests;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        registeredGuests = new TreeSet<>();
    }

    public static void main(String[] args) throws IOException {
        registerGuests();
        welcomeGuestsToParty();

        System.out.println(registeredGuests.size());
        registeredGuests.forEach(System.out::println);

    }

    private static void welcomeGuestsToParty() throws IOException {
        String guest;
        while (! "END".equals(guest = reader.readLine())) {
            registeredGuests.remove(guest);
        }
    }

    private static void registerGuests() throws IOException {
        String guest;
        while (! "PARTY".equals(guest = reader.readLine())) {
            registeredGuests.add(guest);
        }
    }
}
