package Bombs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // daturaBomb = 40, cherryBomb = 60, smokeDecoyBomb = 120
        int daturaBombCount = 0, cherryBombCount = 0, smokeDecoyBombCount = 0;

        ArrayDeque<Integer> effect = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(effect::offer);

        ArrayDeque<Integer> casing = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(casing::push);

        while (!effect.isEmpty() && !casing.isEmpty() && !bombPouchFilled(daturaBombCount,cherryBombCount,smokeDecoyBombCount)){
            int sum = effect.peek() + casing.peek();
            switch (sum){
                case 40:
                    daturaBombCount++;
                    effect.poll();
                    casing.pop();
                    break;
                case 60:
                    cherryBombCount++;
                    effect.poll();
                    casing.pop();
                    break;
                case 120:
                    smokeDecoyBombCount++;
                    effect.poll();
                    casing.pop();
                    break;
                default:
                    casing.push(casing.pop()-5);
                    break;
            }

        }
        if (bombPouchFilled(daturaBombCount,cherryBombCount,smokeDecoyBombCount)){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (effect.isEmpty()){
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.printf("Bomb Effects: %s%n",effect.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (casing.isEmpty()){
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.printf("Bomb Casings: %s%n",casing.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println("Cherry Bombs: " + cherryBombCount);
        System.out.println("Datura Bombs: " + daturaBombCount);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoyBombCount);

    }
    private static boolean bombPouchFilled(int datura, int cherry, int smoke){
        return datura >= 3 && cherry>= 3 && smoke>=3;
    }
}
