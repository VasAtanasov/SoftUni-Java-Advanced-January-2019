package L15LinkedList;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList<Integer> list = new DoublyLinkedListImpl<>();

        list.forEach(System.out::println);
        System.out.println("################################");

        list.addLast(5);
        list.addLast(6);
        list.addLast(90);
        list.addLast(8);
        list.addLast(2);
//        list.addFirst(3);
//        list.addFirst(2);
//        list.addLast(10);
        System.out.printf("Count = %d\n", list.size());
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println();
        list.insertAfter(5,34234);
        System.out.printf("Count = %d\n", list.size());
        System.out.println(Arrays.toString(list.toArray()));

//        list.forEach(System.out::println);
//        System.out.println("################################");

//        list.removeFirst();
//        list.removeLast();
//        list.removeFirst();
//
//        list.forEach(System.out::println);
//        System.out.println("################################");
//
//        list.removeLast();
//
//        list.forEach(System.out::println);
//        System.out.println("################################");

    }
}
