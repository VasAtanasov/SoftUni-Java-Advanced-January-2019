package L10StreamsFilesDirectoriesExercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ex11SerializeCustomObject {

    private static final String COURSE_SER = "/L10StreamsFilesDirectoriesExercises/otherFiles/course.ser";

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/resources/" + COURSE_SER;
        List<Course> courses = new ArrayList<>();

        courses.add(new Course("Java Fundamentals", 133));
        courses.add(new Course("Python Fundamentals", 56));
        courses.add(new Course("ReactJs", 168));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(courses);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        List<Course> deserializeList = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
            //noinspection unchecked
            deserializeList = (List<Course>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }

        deserializeList.forEach(System.out::println);
    }
}

class Course implements Serializable {
    private String name;
    private int studentsCount;

    public Course(String name, int studentsCount) {
        this.name = name;
        this.studentsCount = studentsCount;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentsCount() {
        return this.studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    @Override
    public String toString() {
        return String.format("Course: %s; Students Count: %d", this.name, this.studentsCount);
    }
}
