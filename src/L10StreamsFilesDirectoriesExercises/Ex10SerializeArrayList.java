package L10StreamsFilesDirectoriesExercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ex10SerializeArrayList {
    private static final String LIST_SER = "/L10StreamsFilesDirectoriesExercises/otherFiles/list.ser";

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/resources/" + LIST_SER;
        List<Double> doubles = new ArrayList<>();


        doubles.add(0.1D);
        doubles.add(1231.4D);
        doubles.add(653.6D);
        doubles.add(3.14D);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(doubles);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        List<Double> deserializeList = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            //noinspection unchecked
            deserializeList = (List<Double>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }

        System.out.println(deserializeList.toString());
    }
}
