package SmartArray;

import java.util.function.Consumer;

public class SmartArray {
    final int INITIAL_CAPACITY = 4;
    private int[] array = new int[INITIAL_CAPACITY];
    private int size;

    public void add(int element) {

        if (size == array.length - 1) {
            grow();
        }
        array[size] = element;
        size++;
    }

    public void add(int index, int element) {
        validate(index);
        size++;
        if (size == array.length) grow();
        if (size + 1 - index >= 0) {
            System.arraycopy(array, index - 1, array, index, size + 1 - index);
        }
        array[index] = element;
    }

    public void remove(int index) {
        validate(index);
        if (size - index >= 0) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        size--;
        if (size < (array.length / 2 - INITIAL_CAPACITY)) {
            shrink();
        }
    }

    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                return true;
            }
        }
        return false;
    }

    private void grow() {
        int[] newArr = new int[array.length * 2];
        System.arraycopy(array, 0, newArr, 0, array.length);
        array = newArr;
    }

    private void shrink() {
        int[] newArr = new int[array.length / 2];
        if (size >= 0) {
            System.arraycopy(array, 0, newArr, 0, size);
        }
        array = newArr;
    }

    public int get(int index) {
        validate(index);
        return array[index];
    }

    private void validate(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}
