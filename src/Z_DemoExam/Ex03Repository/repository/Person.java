package Z_DemoExam.Ex03Repository.repository;

public class Person {
    private String name;
    private int age;
    private String birthDate;

    public Person(String name, int age, String birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nAge: %d\nBirthday: %s", this.name, this.age, this.birthDate);
    }
}
