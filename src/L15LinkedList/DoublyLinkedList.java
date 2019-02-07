package L15LinkedList;

public interface DoublyLinkedList<E> extends Iterable<E> {

    int size();

    boolean isEmpty();

    void addFirst(E element);

    void addLast(E element);

    E removeFirst();

    E removeLast();

    Node<E> find(E element);

    void insertAfter(E searchedElement, E element);

    void insertBefore(E searchedElement, E element);

    void remove(E searchedElement);

    E[] toArray();

    E[] toReversedArray();
}
