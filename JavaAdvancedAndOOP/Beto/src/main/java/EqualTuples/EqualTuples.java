package EqualTuples;

import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Scanner;
import java.util.Set;

public class EqualTuples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int lowestSum = Integer.MAX_VALUE;
        int highestSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int leftNum = Integer.parseInt(sc.nextLine());
            int rightNum = Integer.parseInt(sc.nextLine());
            int tupleSum = leftNum + rightNum;

            if (tupleSum < lowestSum) {
                lowestSum = tupleSum;
            }

            if (tupleSum > highestSum){
                highestSum = tupleSum;
            }
        }

        if (lowestSum == highestSum) {
            System.out.printf("Yes, value=%d%n", lowestSum);
        } else {
            System.out.printf("No, maxdiff=%d%n", highestSum - lowestSum);
        }
    }



}

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = Integer.parseInt(sc.nextLine());
//
//        Set<Integer> tuplesSums = new HashSet<>();
//
//        for (int i = 0; i < n; i++) {
//            int leftNum = Integer.parseInt(sc.nextLine());
//            int rightNum = Integer.parseInt(sc.nextLine());
//            tuplesSums.add(leftNum + rightNum);
//        }
//
//        if (tuplesSums.size() == 1) {
//            System.out.printf("Yes, value=%d%n", tuplesSums.stream().findFirst().orElseThrow());
//        } else {
//            IntSummaryStatistics statistics = tuplesSums.stream()
//                    .mapToInt(e -> e)
//                    .summaryStatistics();
//
//            System.out.printf("No, maxdiff=%d%n", statistics.getMax() - statistics.getMin());
//        }
//    }
//
//    public static void main2(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = Integer.parseInt(sc.nextLine());
//
//        int[] tuplesSums = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            int leftNum = Integer.parseInt(sc.nextLine());
//            int rightNum = Integer.parseInt(sc.nextLine());
//            tuplesSums[i] = leftNum + rightNum;
//        }
//
//        int lowestSum = Integer.MAX_VALUE;
//        int highestSum = Integer.MIN_VALUE;
//
//        for (int tupleSum : tuplesSums) {
//            if (tupleSum < lowestSum) {
//                lowestSum = tupleSum;
//            }
//
//            if (tupleSum > highestSum){
//                highestSum = tupleSum;
//            }
//        }
//
//        if (lowestSum == highestSum) {
//            System.out.printf("Yes, value=%d%n", lowestSum);
//        } else {
//            System.out.printf("No, maxdiff=%d%n", highestSum - lowestSum);
//        }
//    }




