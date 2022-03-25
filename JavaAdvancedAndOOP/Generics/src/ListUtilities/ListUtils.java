package ListUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils<T extends Comparable<T>> {

    public static <T extends Comparable<T>> T getMin(List<T> input){
        error(input);
        return Collections.min(input);
    }
    public static <T extends Comparable<T>> T getMax(List<T> input){
        error(input);
        return Collections.max(input);
    }
    private static <T extends Comparable<T>> void error(List<T> list){
        if (list.isEmpty()) throw new IllegalArgumentException();
    }
}
