package L04StacksAndQueuesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex08SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<String> processedText = new ArrayDeque<>();

        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] command = reader.readLine().split("\\s+");

            switch (command[0]) {
                case "1":
                    sb.append(command[1]);
                    processedText.push(sb.toString());
                    break;
                case "2":
                    int count = Integer.valueOf(command[1]);
                    int length = sb.length();
                    int end = (length - count < 0) ? 0 : length - count;
                    sb = new StringBuilder(sb.substring(0,end));
                    processedText.push(sb.toString());
                    break;
                case "3":
                    int index = Integer.valueOf(command[1]) - 1;
                    if (index >= 0 && index < sb.length()) {
                        System.out.println(sb.charAt(index));
                    }
                    break;
                case "4":
                    if (!processedText.isEmpty()) {
                        processedText.pop();
                    }
                    if (processedText.isEmpty()) {
                        sb = new StringBuilder();
                    } else {
                        sb = new StringBuilder(processedText.peek());
                    }
                    break;
            }
        }

    }

}


