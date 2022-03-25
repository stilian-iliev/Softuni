package Cooking;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> liquid = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(liquid::offer);

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(ingredients::push);

        int bread = 0, cake = 0, pastry = 0, fruitPie = 0;

        while (!liquid.isEmpty() && !ingredients.isEmpty()) {
            int liq = liquid.poll();
            int ing = ingredients.pop();
            switch (liq + ing) {
                case 25:
                    bread++;
                    break;
                case 50:
                    cake++;
                    break;
                case 75:
                    pastry++;
                    break;
                case 100:
                    fruitPie++;
                    break;
                default:
                    ingredients.push(ing + 3);
                    break;
            }
        }
        if (bread == 0 || cake == 0 || pastry == 0 || fruitPie == 0){
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        } else {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }

        System.out.print("Liquids left: ");
        if (liquid.isEmpty()){
            System.out.println("none");
        } else {
            System.out.println(liquid.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        System.out.print("Ingredients left: ");
        if (ingredients.isEmpty()){
            System.out.println("none");
        } else {
            System.out.println(ingredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        System.out.println("Bread: "+ bread);
        System.out.println("Cake: "+ cake);
        System.out.println("Fruit Pie: "+ fruitPie);
        System.out.println("Pastry: "+ pastry);
    }
}
