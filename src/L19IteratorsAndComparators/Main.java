package L19IteratorsAndComparators;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Book> books;

    static {
        books = new ArrayList<>() {{
            add(new Book("Animal Farm", 2003, "George Orwell"));
            add(new Book("The Documents in the Case", 2002));
            add(new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace"));
        }};
    }

    public static void main(String[] args) {

        Library<Book> library = new Library<>();
        books.forEach(library::add);
        System.out.println("=".repeat(20) + " Books Titles");
        for (Book book : library) {
            System.out.println(book.getTitle());
        }
        System.out.println();
        System.out.println("=".repeat(20) + " Compare Books");

        for (int i = 0; i < books.size() - 1; i++) {
            Book bookOne = books.get(i);
            Book bookTwo = books.get(i + 1);

            if (bookOne.compareTo(bookTwo) > 0) {
                System.out.println(String.format("%s is before %s", bookOne, bookTwo));
            } else if (bookOne.compareTo(bookTwo) < 0) {
                System.out.println(String.format("%s is before %s", bookTwo, bookOne));
            } else {
                System.out.println("Book are equal");
            }
        }

        System.out.println();
        System.out.println("=".repeat(20) + " Sorted Books");
        books.sort(new BookComparator());

        for (Book book : books) {
            System.out.println(book.getTitle() + book.getYear());
        }
    }
}
