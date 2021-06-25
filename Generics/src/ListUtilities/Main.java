package ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers,13,42,69,73);

        Integer maxInteger = ListUtils.getMax(integers);
        System.out.println(maxInteger);
    }
}
