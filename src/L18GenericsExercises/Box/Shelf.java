package L18GenericsExercises.Box;

public interface Shelf<T extends Comparable<T>> extends Iterable<T> {

    int size();

    void add(T item);

    void swap(int src, int dest);

    void filter(T box);
}
