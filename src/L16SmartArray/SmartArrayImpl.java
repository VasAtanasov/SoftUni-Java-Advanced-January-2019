package L16SmartArray;

import java.util.Iterator;
import java.util.function.Consumer;

public class SmartArrayImpl<E> implements SmartArray<E> {
    private static final int INITIAL_CAPACITY = 4;

    private E[] elements;
    private int cursor;

    public SmartArrayImpl() {
        this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public SmartArrayImpl(int capacity) {
        this.elements = (E[]) new Object[capacity];
        this.cursor = 0;
    }

    @Override
    public int size() {
        return this.cursor;
    }

    @Override
    public void add(E element) {
        if (this.size() == this.capacity()) {
            this.grow();
        }
        this.elements[this.cursor++] = element;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        return this.elements[index];
    }

    @Override
    public E removeAt(int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }

        E element = this.elements[index];

        this.shiftLeft(index);

        this.cursor--;

        if (this.size() < this.capacity() / 4) {
            this.shrink();
        }
        return element;
    }

    @Override
    public void insertAt(int index, E element) {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException();
        }

        if (this.size() + 1 == this.capacity()) {
            this.grow();
        }
        this.shiftRight(index);
        this.elements[index] = element;
        this.cursor++;
    }

    private void shiftRight(int index) {
        for (int i = this.size(); i > 0; i--) {
            if (i == index) {
                break;
            }
            this.elements[i] = this.elements[i - 1];
        }
    }

    @Override
    public boolean contains(E element) {
        return this.contains(this.elements, element, 0);
    }

    @Override
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] newArray = (E[]) new Object[this.size()];
        this.copy(this.elements, newArray, 0);
        return newArray;
    }

    @Override
    public Iterator<E> iterator() {
        return new SmartArrayIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        for (E element : this.elements) {
            action.accept(element);
        }
    }

    @SuppressWarnings("unchecked")
    private void shrink() {
        E[] newArray = (E[]) new Object[this.elements.length / 2];
        if (this.size() >= 0) System.arraycopy(this.elements, 0, newArray, 0, this.size());
        this.elements = newArray;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        E[] newArray = (E[]) new Object[this.capacity() * 2];
        this.copy(this.elements, newArray, 0);
        this.elements = newArray;
    }

    private void shiftLeft(int index) {
        if (this.size() - 1 - index >= 0) {
            System.arraycopy(this.elements, index + 1, this.elements, index, this.size() - 1 - index);
        }
    }

    private int capacity() {
        return this.elements.length;
    }

    private void copy(E[] currentArray, E[] newArray, int index) {
        if (index >= this.size()) {
            return;
        }
        newArray[index] = currentArray[index++];
        this.copy(currentArray, newArray, index);
    }

    private boolean contains(E[] array, E element, int i) {
        if (i < this.size()) {
            if (array[i].equals(element)) {
                return true;
            } else {
                return contains(array, element, i + 1);
            }
        }
        return false;
    }

    private class SmartArrayIterator implements Iterator<E> {


        int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < size();
        }

        @Override
        public E next() {
            return elements[index++];
        }
    }
}
