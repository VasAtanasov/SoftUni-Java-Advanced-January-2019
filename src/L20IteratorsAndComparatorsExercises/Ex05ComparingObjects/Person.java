package L20IteratorsAndComparatorsExercises.Ex05ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person other) {
        int compareByName = this.name.compareTo(other.name);
        int compareByAge = Integer.compare(this.age, other.age);
        int compareByTown = this.town.compareTo(other.town);
        boolean isEqual = compareByName == 0 && compareByAge == 0 && compareByTown == 0;
        return isEqual ? 0 : 1;
    }
}
