package EqualTuples;

import java.util.Scanner;

public class EqualTuples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int biggestDiff = 0;
        int lastSum = 0;
        for (int i = 0; i < n; i++) {
            int leftNum = Integer.parseInt(sc.nextLine());
            int rightNum = Integer.parseInt(sc.nextLine());
            int tupleSum = leftNum + rightNum;

            if (i == 0){
                lastSum = tupleSum;
                continue;
            }

            int currentDiff = Math.abs(lastSum - tupleSum);

            if (currentDiff > biggestDiff) {
                biggestDiff = currentDiff;
            }

            lastSum = tupleSum;
        }

        if (biggestDiff == 0) {
            System.out.printf("Yes, value=%d%n", lastSum);
        } else {
            System.out.printf("No, maxdiff=%d%n", biggestDiff);
        }
    }
}

