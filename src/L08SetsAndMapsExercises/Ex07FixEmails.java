package L08SetsAndMapsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex07FixEmails {
    private static BufferedReader reader;
    private static Map<String, String> users;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        users = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        String name;
        while (! "stop".equals(name = reader.readLine())) {
            String email = reader.readLine();
            if (isValidEmail(email.toLowerCase())) {
                users.putIfAbsent(name, email);
            }
        }

        System.out.println(getOutput());

    }

    private static String getOutput() {
        StringBuilder output = new StringBuilder();
        users.forEach((key, value) -> output.append(String.format("%s -> %s%n", key, value)));
        return output.toString();
    }

    private static boolean isValidEmail(String email) {
        return ! email.endsWith("us") && ! email.endsWith("uk") && ! email.endsWith("com");
    }
}
