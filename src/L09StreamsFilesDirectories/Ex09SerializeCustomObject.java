package L09StreamsFilesDirectories;

import java.io.*;

public class Ex09SerializeCustomObject {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/resources/L09StreamsFilesDirectories/files/output/save.txt";

        Cube cube = new Cube("green", 15.3d, 12.4d, 3d);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static class Cube implements Serializable {
        private String color;
        private double width;
        private double height;
        private double depth;

        public Cube(String color, double width, double height, double depth) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }
}
