package L18GenericsExercises.CustomList;

public interface CustomList<T extends Comparable<T>> extends Iterable<T> {

    int size();

    void add(T element);

    T remove(int index);

    boolean contains(T element);

    void swap(int targetIndex, int destinationIndex);

    long countGreaterThan(T element);

    T getMax();

    T getMin();

    void sort();
}
