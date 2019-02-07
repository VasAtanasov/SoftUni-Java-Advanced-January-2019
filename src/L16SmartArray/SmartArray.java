package L16SmartArray;

public interface SmartArray<E> extends Iterable<E> {
    int size();

    void add(E element);

    E get(int index);

    E removeAt(int index);

    void insertAt(int index, E element);

    boolean contains(E element);

    E[] toArray();
}
