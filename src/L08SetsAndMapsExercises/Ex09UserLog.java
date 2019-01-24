package L08SetsAndMapsExercises;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ex09UserLog {
    private static BufferedReader reader;
    private static final String REGEX;
    private static Pattern pattern;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        REGEX = "IP=(?<ip>.*)\\s+message=.*\\s+user=(?<user>.*)";
        pattern = Pattern.compile(REGEX);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, UserLog> users = new TreeMap<>();

        String input;
        while (! "end".equals(input = reader.readLine())) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String userName = matcher.group("user");
                String ip = matcher.group("ip");

                users.putIfAbsent(userName, new UserLog(userName));
                users.get(userName).updateLog(ip);
            }
        }

        users.values().forEach(System.out::println);
    }

    private static class UserLog {
        private String userName;
        private LinkedHashMap<String, Integer> log;

        UserLog(String userName) {
            this.userName = userName;
            this.log = new LinkedHashMap<>();
        }

        void updateLog(String ip) {
            this.log.putIfAbsent(ip, 0);
            this.log.put(ip, this.log.get(ip) + 1);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s:%n", this.userName));
            sb.append(log.entrySet().stream()
                    .map(e -> String.format("%s => %d", e.getKey(), e.getValue()))
                    .collect(Collectors.joining(", ")));
            sb.append(".");
            return sb.toString();
        }
    }
}

