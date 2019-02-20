package L20IteratorsAndComparatorsExercises.Ex03StackIterator;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;

public class Stack<T> implements Iterable<T> {
    private List<T> elements;

    public Stack() {
        this.elements = new ArrayList<>();
    }

    public void push(T element) {
        this.elements.add(element);
    }

    public T pop() {
        if (elements.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.elements.remove(elements.size() - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<T> {
        private int cursor;

        StackIterator() {
            this.cursor = elements.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return this.cursor >= 0;
        }

        @Override
        public T next() {
            return elements.get(this.cursor--);
        }
    }
}
