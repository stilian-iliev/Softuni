package MakeASalad;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> vegetables = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .forEach(vegetables::offer);

        ArrayDeque<Integer> calories = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(calories::push);

        ArrayDeque<Integer> salads = new ArrayDeque<>();

        while (!vegetables.isEmpty() && !calories.isEmpty()) {
            int calorie = calories.peek();
            while (!vegetables.isEmpty() && calorie > 0) {
                switch (vegetables.poll()) {
                    case "tomato":
                        calorie -= 80;
                        break;
                    case "carrot":
                        calorie -= 136;
                        break;
                    case "lettuce":
                        calorie -= 109;
                        break;
                    case "potato":
                        calorie -= 215;
                        break;
                }
            }
            salads.add(calories.pop());

        }
        System.out.println(salads.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        if (calories.isEmpty()) {
            System.out.println(vegetables.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        } else {
            System.out.println(calories.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
