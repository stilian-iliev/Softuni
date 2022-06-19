package DatingApp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(males::push);

        ArrayDeque<Integer> females = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(females::offer);

        int matches = 0;

        while (!males.isEmpty() && !females.isEmpty()){
            int female = females.peek();
            int male = males.peek();

            if (male <= 0){
                males.pop();
                continue;
            } else if (female <= 0){
                females.poll();
                continue;
            }

            if (female%25==0){
                females.poll();
                females.poll();
                continue;
            } else if (male%25==0){
                males.pop();
                males.pop();
                continue;
            }
            if (male == female){
                females.poll();
                males.pop();
                matches++;
            } else {
                females.poll();
                males.push(males.pop()-2);
            }
        }
        System.out.println("Matches: " + matches);

        System.out.print("Males left: ");
        if (males.isEmpty()) System.out.println("none");
        else System.out.println(males.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.print("Females left: ");
        if (females.isEmpty()) System.out.println("none");
        else System.out.println(females.stream().map(String::valueOf).collect(Collectors.joining(", ")));

    }
}
