package CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> list = new ArrayList<>();

    public void add(T element) {
        list.add(element);
    }

    public T remove(int index) {
        return list.remove(index);
    }

    public boolean contains(T element) {
        return list.contains(element);
    }

    public void swap(int first, int second) {
        Collections.swap(list, first, second);
    }

    public int countGreaterThan(T element) {
        return (int) list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return Collections.max(list);
    }

    public T getMin() {
        return Collections.min(list);
    }

    public void sort() {
        Collections.sort(list);
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = -1;

            @Override
            public boolean hasNext() {
                try {
                    list.get(++index);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }

            @Override
            public T next() {
                return list.get(index);
            }
        };

    }
}
