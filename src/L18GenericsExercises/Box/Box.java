package L18GenericsExercises.Box;

public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {

    private T element;

    public Box(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", element.getClass().getName(), this.element);
    }

    @Override
    public int compareTo(Box<T> other) {
        return this.element.compareTo(other.element);
    }
}
