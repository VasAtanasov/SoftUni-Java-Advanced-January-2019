package L18GenericsExercises.Box;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ShelfImpl<T extends Comparable<T>> implements Shelf<T> {

    private List<T> items;

    public ShelfImpl() {
        this.items = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.items.size();
    }

    @Override
    public void add(T item) {
        this.items.add(item);
    }

    @Override
    public void swap(int src, int dest) {
        if (! this.inRange(src) || ! this.inRange(dest)) {
            throw new IndexOutOfBoundsException();
        }
        T temp = this.items.get(src);
        this.items.set(src, this.items.get(dest));
        this.items.set(dest, temp);
    }

    @Override
    public void filter(T box) {
        this.items = this.items
                .stream()
                .filter(t -> t.compareTo(box) > 0)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        this.items.forEach(action);
    }

    private boolean inRange(int index) {
        return index >= 0 && index < this.items.size();
    }
}
