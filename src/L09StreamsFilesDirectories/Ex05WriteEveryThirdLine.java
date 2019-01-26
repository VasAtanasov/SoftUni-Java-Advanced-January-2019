package L09StreamsFilesDirectories;

import java.io.*;

public class Ex05WriteEveryThirdLine {
    private static final String INPUT_TXT = "/L09StreamsFilesDirectories/files/input/input.txt";
    private static final String OUTPUT_TXT = "/L09StreamsFilesDirectories/files/output/05.WriteEveryThirdLineOutput.txt";

    public static void main(String[] args) throws IOException {
        readFile(INPUT_TXT, OUTPUT_TXT);
    }

    private static void readFile(String fileIn, String fileOut) throws IOException {
        String path = System.getProperty("user.dir") + "/resources/" + fileIn;
        String outPath = System.getProperty("user.dir") + "/resources/" + fileOut;
        try (
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(
                                        new File(path)
                                )
                        )
                );
                PrintWriter out = new PrintWriter(new FileWriter(outPath))
        ) {
            String line;
            int lineNumber = 1;
            while ((line = bufferedReader.readLine()) != null) {
                if (lineNumber % 3 == 0) {
                    out.println(line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
