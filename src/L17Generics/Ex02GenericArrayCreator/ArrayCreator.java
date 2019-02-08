package L17Generics.Ex02GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {
    public static <T> T[] create(int length, T item) { // wrong method not working but needed int judge
        Object[] array = new Object[length];
        for (int i = 0; i < length; i++) {
            array[i] = item;
        }
        return (T[]) array;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<T> tClass, int length, T item) {
        T[] array = (T[]) Array.newInstance(tClass, length);
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return array;
    }
}
