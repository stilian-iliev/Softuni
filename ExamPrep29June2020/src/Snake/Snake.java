package Snake;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        char[][] field = new char[n][n];

        int snakeRow = 0, snakeCol = 0;

        int[] bunker1 = new int[2];
        bunker1[0] = -1;
        int[] bunker2 = new int[2];

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            field[i] = input.toCharArray();
            if (input.contains("S")) {
                snakeRow = i;
                snakeCol = input.indexOf("S");
            } else if (input.contains("B")){
                if (bunker1[0]==-1){
                    bunker1[0] = i;
                    bunker1[1] = input.indexOf("B");
                } else {
                    bunker2[0] = i;
                    bunker2[1] = input.indexOf("B");
                }
            }
        }
        boolean won = false;
        int food = 0;
        while (true) {
            field[snakeRow][snakeCol] = '.';
            String direction = sc.nextLine();
            switch (direction) {
                case "up":
                    snakeRow--;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
            }

            if (!inField(snakeRow, snakeCol,n)){
                break;
            }
            if (field[snakeRow][snakeCol] == '*') food++;
            else if (field[snakeRow][snakeCol] == 'B'){
                field[snakeRow][snakeCol] = '.';
                if (snakeRow == bunker1[0] && snakeCol == bunker1[1]){
                    snakeRow = bunker2[0];
                    snakeCol = bunker2[1];
                } else {
                    snakeRow = bunker1[0];
                    snakeCol = bunker1[1];
                }
            }
            field[snakeRow][snakeCol] = 'S';
            if (food>=10){
                won =true;
                break;
            }
        }
        if (won){
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }
        System.out.println("Food eaten: "+ food);
        printMatrix(field);

    }

    private static void printMatrix(char[][] field) {
        for (char[] chars : field) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    public static boolean inField(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}
