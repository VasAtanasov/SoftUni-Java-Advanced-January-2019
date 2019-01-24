package L08SetsAndMapsExercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ex06MinerTask {
    private static BufferedReader reader;
    private static Map<String, Long> resourses;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        resourses = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        String recourse;
        while (! "stop".equals(recourse = reader.readLine())) {
            long amount = Long.parseLong(reader.readLine());

            resourses.putIfAbsent(recourse, 0L);
            long updatedCount = resourses.get(recourse) + amount;
            resourses.put(recourse, updatedCount);
        }

        String output = getOutput();
        System.out.println(output);
    }

    private static String getOutput() {
        StringBuilder output = new StringBuilder();
        resourses.forEach((r, c) -> output.append(String.format("%s -> %d%n", r, c)));
        return output.toString();
    }
}
