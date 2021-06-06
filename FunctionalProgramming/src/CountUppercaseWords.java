import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Predicate<String> startsWithUpperCase = w -> Character.isUpperCase(w.charAt(0));

        ArrayList<String> wordsWithCapital = Arrays.stream(sc.nextLine()
                .split("\\s+"))
                .filter(startsWithUpperCase)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(wordsWithCapital.size());

        wordsWithCapital
                .forEach(System.out::println);
    }
}
