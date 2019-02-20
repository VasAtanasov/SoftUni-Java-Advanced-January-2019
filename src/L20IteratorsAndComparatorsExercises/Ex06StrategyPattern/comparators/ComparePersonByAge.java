package L20IteratorsAndComparatorsExercises.Ex06StrategyPattern.comparators;

import L20IteratorsAndComparatorsExercises.Ex06StrategyPattern.models.Person;

import java.util.Comparator;

public class ComparePersonByAge implements Comparator<Person> {

    @Override
    public int compare(Person personOne, Person personTwo) {
        return personOne.getAge() - personTwo.getAge();
    }
}
