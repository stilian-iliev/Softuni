package GenericArrayCreator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arr = ArrayCreator.create(10, "Java");

        Arrays.stream(arr).forEach(System.out::println);
    }
}
