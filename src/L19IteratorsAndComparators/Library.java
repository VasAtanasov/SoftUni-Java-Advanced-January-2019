package L19IteratorsAndComparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Library<T extends Book> implements Iterable<T> {

    private List<T> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    @SafeVarargs
    public Library(T... book) {
        this();
        this.books.addAll(Arrays.asList(book));
    }

    public Library<T> add(T book) {
        this.books.add(book);
        return this;
    }

    @Override
    public Iterator<T> iterator() {
        return new LibraryIterator();
    }

    private final class LibraryIterator implements Iterator<T> {
        private int count = 0;

        @Override
        public boolean hasNext() {
            return this.count < books.size();
        }

        @Override
        public T next() {
            return books.get(count++);
        }
    }
}
