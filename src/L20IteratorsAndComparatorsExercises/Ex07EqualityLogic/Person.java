package L20IteratorsAndComparatorsExercises.Ex07EqualityLogic;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                getName().equals(person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public int compareTo(Person other) {
        int compare = this.getName().compareTo(other.getName());
        return compare != 0 ? compare : Integer.compare(this.getAge(), other.getAge());
    }
}
