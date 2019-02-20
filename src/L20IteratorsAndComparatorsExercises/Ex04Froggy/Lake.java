package L20IteratorsAndComparatorsExercises.Ex04Froggy;

import java.util.Iterator;
import java.util.function.BiPredicate;

public class Lake implements Iterable<Integer> {
    private int[] numbers;

    public Lake(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer> {
        private int index;

        private Frog() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < numbers.length;
        }

        @Override
        public Integer next() {
            int element = numbers[this.index];
            this.index = isFinishedWithEven.test(numbers.length, this.index + 2) ? 1 : this.index + 2;
            return element;
        }

        private BiPredicate<Integer, Integer> isFinishedWithEven = (length, index) -> index >= numbers.length && index % 2 == 0;
    }

}
