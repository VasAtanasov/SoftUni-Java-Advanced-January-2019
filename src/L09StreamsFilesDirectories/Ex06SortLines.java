package L09StreamsFilesDirectories;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ex06SortLines {

    private static final String INPUT_TXT = "/L09StreamsFilesDirectories/files/input/inputLetters.txt";
    private static final String OUTPUT_TXT = "/L09StreamsFilesDirectories/files/output/06.SortLinesOutput.txt";

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "/resources/" + INPUT_TXT;
        String outPath = System.getProperty("user.dir") + "/resources/" + OUTPUT_TXT;

        try (PrintWriter out = new PrintWriter(new FileWriter(outPath))) {
            Files.readAllLines(Paths.get(path))
                    .stream()
                    .filter(s -> ! s.isEmpty())
                    .sorted()
                    .forEach(out::println);
        }
    }
}
