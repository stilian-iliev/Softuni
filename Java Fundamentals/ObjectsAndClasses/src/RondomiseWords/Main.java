package RondomiseWords;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        Random rnd = new Random();
        for (int i = 0; i < input.length; i++) {
            String temp = input[i];
            int rndIndex = rnd.nextInt(input.length);
            input[i] = input[rndIndex];
            input[rndIndex] = temp;
        }
        for (String s : input) {
            System.out.println(s);
        }
    }
}
