package ReVolt;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());

        int[] playerPos = new int[2];

        char[][] field = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            field[i] = input.toCharArray();
            if (input.contains("f")) {
                playerPos[0] = i;
                playerPos[1] = input.indexOf("f");
            }
        }
        boolean won = false;

        while (m-- > 0 && !won) {
            String input = sc.nextLine();
            won = move(input, playerPos[0], playerPos[1], field, playerPos);

        }
        if (won) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(field);
    }

    private static boolean move(String input, int playerRow, int playerCol, char[][] field, int[] playerPos) {
        boolean hasWon = false;
        int row = playerRow;
        int col = playerCol;

        switch (input) {
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
        row = checkIfInRange(row, field.length);
        col = checkIfInRange(col, field.length);
        if (field[row][col] == 'F') {
            hasWon =true;
        } else if (field[row][col] == 'B') {
            hasWon = move(input, row, col, field, playerPos);
            row = playerPos[0];
            col = playerPos[1];
        } else if (field[row][col] == 'T'){
            return false;
        }
        field[playerPos[0]][playerPos[1]] = '-';
        playerPos[0] = row;
        playerPos[1] = col;

        field[row][col] = 'f';
        return hasWon;

    }

    private static int checkIfInRange(int pos, int length) {
        if (pos >= length) pos = 0;
        else if (pos < 0) pos = length - 1;
        return pos;
    }

    public static void printMatrix(char[][] matrix){
        for (char[] chars : matrix) {
            for (char ch : chars) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
