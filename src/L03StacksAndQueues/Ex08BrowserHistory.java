package L03StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex08BrowserHistory {
    private static final String END_COMMAND = "Home";
    private static final String BACK = "back";
    private static final String FORWARD = "forward";
    private static final String NO_PREVIOUS_URL = "no previous URLs";
    private static final String NO_NEXT_URL = "no next URLs";

    private static Deque<String> backHistory;
    private static Deque<String> nextHistory;
    private static BufferedReader reader;
    private static String currentUrl;

    static {
        backHistory = new ArrayDeque<>();
        nextHistory = new ArrayDeque<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {

        String input;
        while (! END_COMMAND.equals(input = reader.readLine())) {
            if (BACK.equals(input)) {
                if (backHistory.isEmpty()) {
                    System.out.println(NO_PREVIOUS_URL);
                    continue;
                } else {
                    nextHistory.addLast(currentUrl);
                    currentUrl = backHistory.removeFirst();
                }
            } else if (FORWARD.equals(input)) {
                if (nextHistory.isEmpty()) {
                    System.out.println(NO_NEXT_URL);
                    continue;
                } else {
                    backHistory.addFirst(currentUrl);
                    currentUrl = nextHistory.removeLast();
                }
            } else if (currentUrl == null) {
                currentUrl = input;
            } else {
                backHistory.addFirst(currentUrl);
                currentUrl = input;
                nextHistory.clear();
            }

            if (currentUrl != null) {
                System.out.println(currentUrl);
            }
        }

    }
}
