package Selling;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        char[][] bakery = new char[n][n];

        int row = -1;
        int col = -1;

        int firstPillarRow = -1, firstPillarCol = -1, secondPillarRow = -1, secondPillarCol = -1;

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            bakery[i] = input.toCharArray();

            if (input.contains("S")) {
                row = i;
                col = input.indexOf("S");
            } else if (input.contains("O")) {
                if (firstPillarRow == -1){
                    firstPillarRow = i;
                    firstPillarCol = input.indexOf("O");
                } else {
                    secondPillarRow = i;
                    secondPillarCol = input.indexOf("O");
                }
            }
        }

        int money = 0;
        while (money<50){
            String direction = sc.nextLine();
            bakery[row][col] = '-';
            switch (direction){
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }
            if (!outOfMatrix(row,col,n)){
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }
            if (bakery[row][col] == 'O'){
                bakery[row][col] = '-';
                if (row == firstPillarRow && col == firstPillarCol){
                    row = secondPillarRow;
                    col = secondPillarCol;
                } else {
                    row = firstPillarRow;
                    col = firstPillarCol;
                }
            } else if (bakery[row][col] != '-'){
                money += Integer.parseInt(String.valueOf(bakery[row][col]));
            }
            bakery[row][col] = 'S';
        }
        if (money>=50) System.out.println("Good news! You succeeded in collecting enough money!");

        System.out.println("Money: "+ money);

        printMatrix(bakery);
    }

    private static void printMatrix(char[][] bakery) {
        for (char[] chars : bakery) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static boolean outOfMatrix(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}
