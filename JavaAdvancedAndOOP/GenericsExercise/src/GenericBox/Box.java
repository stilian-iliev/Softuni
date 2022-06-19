package GenericBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> list = new ArrayList<>();

    public static <T> String toString(T input) {
        return String.format("%s: %s", input.getClass().getName(), input);
    }

    public int compare(T value) {
        return (int) list.stream().filter(e -> e.compareTo(value) > 0).count();
    }

    public void add(T element) {
        list.add(element);
    }

    public void swap(int first, int second) {
        Collections.swap(list, first, second);
    }
}
