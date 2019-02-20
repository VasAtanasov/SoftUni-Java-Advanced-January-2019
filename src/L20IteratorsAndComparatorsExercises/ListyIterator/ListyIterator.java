package L20IteratorsAndComparatorsExercises.ListyIterator;


import java.util.Iterator;

public class ListyIterator<T> implements Iterable<T> {
    private T[] strings;
    private int index;

    @SafeVarargs
    public ListyIterator(T... strings) {
        this.strings = strings;
        this.index = 0;
    }

    public boolean move() {
        if (this.hasNext()) {
            this.index += 1;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return this.index + 1 < this.strings.length;
    }

    public T peek() {
        return this.strings[index];
    }
    
    public T[] toArray() {
        return this.strings;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<T> {

        private int iteratorIndex = 0;

        @Override
        public boolean hasNext() {
            return this.iteratorIndex < strings.length;
        }

        @Override
        public T next() {
            return strings[this.iteratorIndex++];
        }
    }
}
