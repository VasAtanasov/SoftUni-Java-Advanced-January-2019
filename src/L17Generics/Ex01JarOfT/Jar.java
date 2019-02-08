package L17Generics.Ex01JarOfT;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {
    private Deque<T> stack;

    public Jar() {
        this.stack = new ArrayDeque<>();
    }

    public void add(T element) {
        this.stack.addLast(element);
    }

    public T remove(){
        if (!this.stack.isEmpty()) {
            return this.stack.removeLast();
        }
        return null;
    }
}
