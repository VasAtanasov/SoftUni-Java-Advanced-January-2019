package L08SetsAndMapsExercises;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Ex11LogAggregator {
    private static Map<String, UserLogAggregator> users;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        users = new TreeMap<>();
        int lines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lines; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String ip = tokens[0];
            String userName = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            users.putIfAbsent(userName, new UserLogAggregator(userName));
            users.get(userName).updateLog(ip, duration);
        }

        users.values().forEach(System.out::println);

    }

    private static class UserLogAggregator {
        private String name;
        private Set<String> log;
        private int totalDuration;

        UserLogAggregator(String name) {
            this.name = name;
            this.log = new TreeSet<>();
            this.totalDuration = 0;
        }

        private String getName() {
            return this.name;
        }

        private Set<String> getLog() {
            return this.log;
        }

        private int getTotalDuration() {
            return this.totalDuration;
        }

        void updateLog(String ip, int duration) {
            this.log.add(ip);
            this.totalDuration += duration;
        }

        @Override
        public String toString() {
            return String.format("%s: %d %s", this.getName(), this.getTotalDuration(), this.getLog());
        }
    }
}

