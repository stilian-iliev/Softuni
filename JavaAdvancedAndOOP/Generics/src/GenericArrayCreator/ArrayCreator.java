package GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.stream.IntStream;

public class ArrayCreator {

    public static <T> T[] create(int length, T item) {
        return create(item.getClass(), length, item);
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<?> clazz, int length, T item) {
        T[] array = (T[]) Array.newInstance(clazz, length);
        IntStream.range(0, length)
                .forEach(n -> array[n] = item);
        return array;
    }
}
