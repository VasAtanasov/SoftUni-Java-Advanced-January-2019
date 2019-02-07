package L15LinkedList;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.Iterator;
import java.util.function.Consumer;

public class DoublyLinkedListImpl<E> implements DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void addFirst(E element) {
        if (this.size == 0) {
            this.head = this.tail = new Node<>(element);
        } else {
            Node<E> newHead = new Node<>(element);

            newHead.setNext(this.head);

            this.head.setPrev(newHead);
            this.head = newHead;
        }
        this.size++;
    }

    @Override
    public void addLast(E element) {
        if (this.size == 0) {
            this.head = this.tail = new Node<>(element);
        } else {

            Node<E> newTail = new Node<>(element);

            newTail.setPrev(this.tail);

            this.tail.setNext(newTail);
            this.tail = newTail;
        }
        this.size++;
    }

    @Override
    public E removeFirst() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }
        Node<E> first = this.head;
        this.head = this.head.getNext();
        if (this.head != null) {
            this.head.setPrev(null);
        } else {
            this.tail = null;
        }
        this.size--;
        return first.getValue();
    }

    @Override
    public E removeLast() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }
        Node<E> last = this.tail;
        this.tail = this.tail.getPrev();
        if (this.tail != null) {
            this.tail.setNext(null);
        } else {
            this.head = null;
        }
        this.size--;
        return last.getValue();
    }

    @Override
    public Node<E> find(E element) {
        return this.find(this.head, element);
    }

    private Node<E> find(Node<E> node, E element) {
        if (node == null) {
            return null;
        }

        if (node.getValue().equals(element)) {
            return node;
        }

        this.find(node.getNext(), element);

        return node;
    }

    @Override
    public void insertAfter(E searchedElement, E element) {
        this.checkIfEmpty();

        Node<E> prev = this.isElement(searchedElement);

        Node<E> newNode = new Node<>(element);

        newNode.setNext(prev.getNext());
        newNode.setPrev(prev);

        prev.setNext(newNode);

        if (newNode.getNext() != null) {
            newNode.getNext().setPrev(newNode);
        }

        this.size++;
    }

    @Override
    public void insertBefore(E searchedElement, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(E searchedElement) {
        this.checkIfEmpty();

        Node<E> foDelete = this.isElement(searchedElement);

        Node<E> prev = foDelete.getPrev();
        Node<E> next = foDelete.getNext();

        if (prev == null) {
            this.head = foDelete.getNext();
            if (this.head != null) {
                this.head.setPrev(null);
            }
        }

        if (next == null) {
            this.tail = foDelete.getPrev();
            if (this.tail != null) {
                this.tail.setNext(null);
            }
        }

        if (prev != null || next != null) {
            Node<E> temp = foDelete.getPrev();
            if (temp != null) {
                temp.setNext(next);
            }
            temp = foDelete.getNext();
            if (temp != null) {
                temp.setPrev(foDelete.getPrev());
            }
        }

        this.size--;
    }

    private Node<E> isElement(E searchedElement) {
        Node<E> current = this.head;
        while (current != null) {
            if (current.getValue().equals(searchedElement)) {
                break;
            }
            current = current.getNext();
        }

        if (current == null) {
            throw new InvalidDnDOperationException("Element not found");
        }
        return current;
    }

    private void checkIfEmpty() {
        if (this.isEmpty()) {
            throw new InvalidDnDOperationException("Collection is empty!");
        }
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public E[] toArray() {
        E[] array = (E[]) new Object[this.size];
        this.traverseForward(this.head, array, 0);
        return array;
    }

    @SuppressWarnings({"unchecked"})
    @Override
    public E[] toReversedArray() {
        E[] array = (E[]) new Object[this.size];
        this.traverseBackward(this.tail, array, 0);
        return array;
    }

    private void traverseForward(Node<E> node, E[] array, int index) {
        if (node == null) {
            return;
        }
        array[index++] = node.getValue();
        traverseForward(node.getNext(), array, index);
    }

    private void traverseBackward(Node<E> node, E[] array, int index) {
        if (node == null) {
            return;
        }
        array[index++] = node.getValue();
        traverseBackward(node.getPrev(), array, index);
    }

    @Override
    public Iterator<E> iterator() {
        return new DoubleLinkedListIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Node<E> currentNode = this.head;
        while (currentNode != null) {
            action.accept(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
    }

    private class DoubleLinkedListIterator implements Iterator<E> {

        private int index;
        private Node<E> node;

        DoubleLinkedListIterator() {
            this.index = 0;
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return this.index < size;
        }

        @Override
        public E next() {
            E element = this.node.getValue();
            this.index++;
            this.node = this.node.getNext();
            return element;
        }
    }
}
