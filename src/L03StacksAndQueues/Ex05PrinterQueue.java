package L03StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex05PrinterQueue {
    private static final String END_COMMAND = "print";
    private static final String CANCEL = "cancel";
    private static final String PRINTER_ON_STANDBY = "Printer is on standby";
    private static final String CANCELED = "Canceled %s";

    private static Deque<String> printerQueue;
    private static BufferedReader reader;

    static {
        printerQueue = new ArrayDeque<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (! END_COMMAND.equals(input = reader.readLine())) {
            if (CANCEL.equals(input)) {
                if (printerQueue.isEmpty()) {
                    System.out.println(PRINTER_ON_STANDBY);
                } else {
                    System.out.println(String.format(CANCELED, printerQueue.removeFirst()));
                }
            } else {
                printerQueue.addLast(input);
            }
        }

        while (! printerQueue.isEmpty()) {
            System.out.println(printerQueue.removeFirst());
        }
    }
}
