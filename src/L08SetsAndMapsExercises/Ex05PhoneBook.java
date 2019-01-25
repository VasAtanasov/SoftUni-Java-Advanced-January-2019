package L08SetsAndMapsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex05PhoneBook {
    private static BufferedReader reader;
    private static Map<String, String> phoneBook;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        phoneBook = new HashMap<>();
    }

    public static void main(String[] args) throws IOException {
        registerNumbers();
        searchContacts();
    }

    private static void searchContacts() throws IOException {
        String name;
        while (! "stop".equals(name = reader.readLine())) {
            if (phoneBook.containsKey(name)) {
                System.out.println(String.format("%s -> %s", name, phoneBook.get(name)));
            } else {
                System.out.println(String.format("Contact %s does not exist.", name));
            }
        }
    }

    private static void registerNumbers() throws IOException {
        String input;
        while (! "search".equals(input = reader.readLine())) {
            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];

            phoneBook.put(name, number);
        }
    }
}
