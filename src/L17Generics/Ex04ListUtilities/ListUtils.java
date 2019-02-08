package L17Generics.Ex04ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtils {
    private ListUtils() {

    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list!");
        }
        return Collections.max(list);
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list!");
        }
        return Collections.min(list);
    }

    public static List<Integer> getNullIndices(List<?> list) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    public static <T> void flatten(List<? super T> destination, List<List<? extends T>> source) {
        for (List<? extends T> list : source) {
            destination.addAll(list);
        }
    }

    public static <T> void addAll(List<? super T> destination, List<? extends T> source) {
        destination.addAll(source);
    }
}
