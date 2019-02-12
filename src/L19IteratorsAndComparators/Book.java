package L19IteratorsAndComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... values) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(values);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... values) {
        this.authors = new ArrayList<>();
        Collections.addAll(authors, values);
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    @Override
    public String toString() {
        return "Title: " + this.getTitle() +
                System.lineSeparator() +
                "Year: " + this.getYear() +
                System.lineSeparator() +
                "Authors: " + String.join(", ", this.getAuthors());
    }

    @Override
    public int compareTo(Book other) {
        int index = this.getTitle().compareTo(other.getTitle());
        return index != 0 ? index : Integer.compare(this.getYear(), other.getYear());
    }
}
