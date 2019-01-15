package L04StacksAndQueuesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex05Robotics {
    private static BufferedReader reader;
    private static long startTime;
    private static String[] robots;
    private static int[] processTime;
    private static int[] processing;
    private static Deque<String> products;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        products = new ArrayDeque<>();
    }

    public static void main(String[] args) throws IOException {
        readInput();

        while (! products.isEmpty()) {
            String product = products.removeFirst();
            startTime += 1;
            process();
            boolean allBusy = true;

            for (int i = 0; i < processing.length; i++) {
                if (isIdle(i)) {
                    allBusy = false;
                    processing[i] = processTime[i];
                    System.out.println(String.format("%s - %s [%s]", robots[i], product, calculateTime(startTime)));
                    break;
                }
            }

            if (allBusy) {
                products.addLast(product);
            }
        }
    }

    private static boolean isIdle(int i) {
        return processing[i] == 0;
    }

    private static void process() {
        for (int i = 0; i < processing.length; i++) {
            processing[i] = processing[i] == 0 ? 0 : processing[i] - 1;
        }
    }

    private static String calculateTime(long seconds) {
        long sec = seconds % 60;
        long minutes = seconds % 3600 / 60;
        long hours = seconds % 86400 / 3600;
        DecimalFormat df = new DecimalFormat("00");
        return String.format("%s:%s:%s", df.format(hours), df.format(minutes), df.format(sec));
    }

    private static void readInput() throws IOException {
        getRobots();
        getStarTime();
        getProducts();
    }

    private static void getRobots() throws IOException {
        String[] tokens = reader.readLine().split(";");
        robots =  new String[tokens.length];
        processing = new int[tokens.length];
        processTime = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            String name = tokens[i].split("-")[0];
            int seconds = Integer.parseInt(tokens[i].split("-")[1]);
            robots[i] = name;
            processTime[i] = seconds;
        }

    }

    private static void getStarTime() throws IOException {
        String[] tokens = reader.readLine().split(":");
        int hours = Integer.parseInt(tokens[0]);
        int minutes = Integer.parseInt(tokens[1]);
        int seconds = Integer.parseInt(tokens[2]);
        seconds += (minutes * 60);
        seconds += (hours * 3600);
        startTime = seconds;
    }

    private static void getProducts() throws IOException {
        String input;
        while (! "End".equals(input = reader.readLine())) {
            products.addLast(input);
        }
    }
}




