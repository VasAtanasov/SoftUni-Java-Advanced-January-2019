package L03StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex01BrowserHistory {
    private static final String END_COMMAND = "Home";
    private static final String BACK = "back";
    private static final String NO_PREVIOUS_URL = "no previous URLs";

    private static Deque<String> history;
    private static BufferedReader reader;
    private static String currentUrl;

    static {
        history = new ArrayDeque<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {

        String input;
        while (! END_COMMAND.equals(input = reader.readLine())) {
            if (BACK.equals(input)) {
                if (history.isEmpty()) {
                    System.out.println(NO_PREVIOUS_URL);
                    continue;
                } else {
                    currentUrl = history.pop();
                }
            } else if (currentUrl == null) {
                currentUrl = input;
            } else {
                history.push(currentUrl);
                currentUrl = input;
            }

            if (currentUrl != null) {
                System.out.println(currentUrl);
            }
        }

    }
}
