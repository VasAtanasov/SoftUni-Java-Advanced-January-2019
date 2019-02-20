package L20IteratorsAndComparatorsExercises.Ex09LinkedListTraversal;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class DoublyLinkedList<E> implements Iterable<E> {

    private Node head;
    private Node tail;
    private int size;

    public int getSize() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst(E element) {
        if (this.size == 0) {
            this.head = this.tail = new Node(element);
        } else {
            Node newHead = new Node(element);
            newHead.next = this.head;
            this.head.prev = newHead;
            this.head = newHead;
        }
        this.size++;
    }

    public void addLast(E element) {
        if (this.size == 0) {
            this.head = this.tail = new Node(element);
        } else {
            Node newTail = new Node(element);
            newTail.prev = this.tail;
            this.tail.next = newTail;
            this.tail = newTail;
        }
        this.size++;
    }

    public E removeFirst() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }
        Node first = this.head;
        this.head = this.head.next;
        if (this.head != null) {
            this.head.prev = null;
        } else {
            this.tail = null;
        }
        this.size--;
        return first.value;
    }

    public E removeLast() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }
        Node last = this.tail;
        this.tail = this.tail.prev;
        if (this.tail != null) {
            this.tail.next = null;
        } else {
            this.head = null;
        }
        this.size--;
        return last.value;
    }

    public Node find(E element) {
        return this.find(this.head, element);
    }

    private Node find(Node node, E element) {
        if (node == null) {
            return null;
        }

        if (node.value.equals(element)) {
            return node;
        }
        this.find(node.next, element);

        return node;
    }

    public void insertAfter(Node prev, E element) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("The given previous node cannot be NULL");
        }
        if (prev == null) {
            throw new IllegalArgumentException("Element not found");
        }

        Node newNode = new Node(element);
        newNode.next = prev.next;
        prev.next = newNode;
        newNode.prev = prev;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    @SuppressWarnings({"unchecked"})
    public E[] toArray() {
        E[] array = (E[]) new Object[this.size];
        this.traverseForward(this.head, array, 0);
        return array;
    }

    @SuppressWarnings({"unchecked"})
    public E[] toReversedArray() {
        E[] array = (E[]) new Object[this.size];
        this.traverseBackward(this.tail, array, 0);
        return array;
    }

    private void traverseForward(Node node, E[] array, int index) {
        if (node == null) {
            return;
        }
        array[index++] = node.value;
        traverseForward(node.next, array, index);
    }

    private void traverseBackward(Node node, E[] array, int index) {
        if (node == null) {
            return;
        }
        array[index++] = node.value;
        traverseBackward(node.prev, array, index);
    }

    @Override
    public Iterator<E> iterator() {
        return new DoubleLinkedListIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Node currentNode = this.head;
        while (currentNode != null) {
            action.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public boolean remove(E element) {
        Node current = this.head;

        while (current != null) {
            if (current.value.equals(element)) {

                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    this.head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    this.tail = current.prev;
                }

                this.size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    private class DoubleLinkedListIterator implements Iterator<E> {

        private int index;
        private Node node;

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
            E element = this.node.value;
            this.index++;
            this.node = this.node.next;
            return element;
        }

        @Override
        public void remove() {

        }
    }

    private class Node {
        private E value;
        private Node next;
        private Node prev;

        Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return this.value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return this.prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

}
