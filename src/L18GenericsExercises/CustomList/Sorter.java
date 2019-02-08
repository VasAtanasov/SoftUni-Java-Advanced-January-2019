package L18GenericsExercises.CustomList;

public final class Sorter {

    private Sorter() {

    }

    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        list.sort();
    }
}
