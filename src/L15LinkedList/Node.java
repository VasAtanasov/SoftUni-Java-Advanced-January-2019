package L15LinkedList;

public class Node<E> {
    private E value;
    private Node<E> next;
    private Node<E> prev;

    Node(E value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public E getValue() {
        return this.value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return this.prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
}