package L18GenericsExercises.CustomList;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CustomListImpl<T extends Comparable<T>> implements CustomList<T> {

    private Map<Integer, T> elements;
    private T min;
    private T max;
    private int index;

    public CustomListImpl() {
        this.elements = new LinkedHashMap<>();
        this.min = null;
        this.max = null;
        this.index = 0;
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public void add(T element) {
        this.elements.put(this.index++, element);

        if (this.min == null) {
            this.min = element;
        } else if (this.min.compareTo(element) > 0) {
            this.min = element;
        }

        if (this.max == null) {
            this.max = element;
        } else if (this.max.compareTo(element) < 0) {
            this.max = element;
        }
    }

    @Override
    public T remove(int index) {
        if (! this.elements.containsKey(index)) {
            throw new IndexOutOfBoundsException();
        }
        T element = this.elements.get(index);
        this.index--;
        this.shiftLeft(index);
        return element;
    }

    private void shiftLeft(int index) {
        while (index < this.index) {
            this.elements.put(index++, this.elements.get(index));
        }
        this.elements.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.elements
                .values()
                .contains(element);
    }

    @Override
    public void swap(int targetIndex, int destinationIndex) {
        if (! this.elements.containsKey(targetIndex) || ! this.elements.containsKey(destinationIndex)) {
            throw new IndexOutOfBoundsException();
        }

        T temp = this.elements.get(targetIndex);
        this.elements.put(targetIndex, this.elements.get(destinationIndex));
        this.elements.put(destinationIndex, temp);
    }

    @Override
    public long countGreaterThan(T element) {
        return this.elements.values()
                .stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    @Override
    public T getMax() {
        return this.max;
    }

    @Override
    public T getMin() {
        return this.min;
    }

    @Override
    public void sort() {
        this.elements = this.elements
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        this.elements.values().forEach(action);
    }

    @Override
    public Iterator<T> iterator() {
        return new SmartListIterator();
    }

    private class SmartListIterator implements Iterator<T> {

        private Deque<T> items = new ArrayDeque<>(elements.values());

        @Override
        public boolean hasNext() {
            return ! items.isEmpty();
        }

        @Override
        public T next() {
            return this.items.removeFirst();
        }
    }
}
