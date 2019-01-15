package L04StacksAndQueuesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex08SimpleTextEditor01 {
    private static BufferedReader reader;
    private static Deque<String> commands;
    private static String text;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        commands = new ArrayDeque<>();
        text = "";
    }

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "1":
                    appendText(tokens);
                    break;
                case "2":
                    eraseElements(tokens);
                    break;
                case "3":
                    printIndex(tokens);
                    break;
                case "4":
                    undoCommand();
                    break;
            }
        }
    }

    private static void undoCommand() {
        if (! commands.isEmpty()) {
            commands.removeLast();
        }

        if (! commands.isEmpty()) {
            text = commands.peekLast();
        } else {
            text = "";
        }
    }

    private static void printIndex(String[] tokens) {
        if (! commands.isEmpty()) {
            int index = Integer.parseInt(tokens[1]);
            System.out.println(text.charAt(index - 1));
        }
    }

    private static void eraseElements(String[] tokens) {
        if (! commands.isEmpty()) {
            int lastCount = Integer.parseInt(tokens[1]);
            String currentText = commands.peekLast();
            text = currentText.substring(0, currentText.length() - lastCount);
            commands.addLast(text);
        }
    }

    private static void appendText(String[] tokens) {
        text += tokens[1];
        commands.addLast(text);
    }

}

