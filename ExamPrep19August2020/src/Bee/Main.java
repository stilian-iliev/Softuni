package Bee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        char[][] field = new char[n][n];

        int beeRow = 0, beeCol = 0;
        int bonusRow = -1, bonusCol = -1;

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            field[i] = input.toCharArray();
            if (input.contains("B")) {
                beeRow = i;
                beeCol = input.indexOf("B");
            } else if (input.contains("O")) {
                bonusRow = i;
                bonusCol = input.indexOf("O");
            }
        }
        int pollinated = 0;

        String input = sc.nextLine();
        while (!input.equals("End")) {
            field[beeRow][beeCol] = '.';
            switch (input) {
                case "up":
                    beeRow--;
                    break;
                case "down":
                    beeRow++;
                    break;
                case "left":
                    beeCol--;
                    break;
                case "right":
                    beeCol++;
                    break;
            }
            if (!inMatrix(beeRow, beeCol, n)) {
                System.out.println("The bee got lost!");
                break;
            }
            if (field[beeRow][beeCol] == 'O') {

                continue;
            } else if (field[beeRow][beeCol] == 'f') pollinated++;
            field[beeRow][beeCol] = 'B';

            input = sc.nextLine();
        }
        if (pollinated>=5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",pollinated);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",5-pollinated);
        }
        printMatrix(field);
    }

    private static boolean inMatrix(int row, int col, int size) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
    private static void printMatrix(char[][] matrix){
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
