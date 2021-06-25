package BookWorm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder string = new StringBuilder(sc.nextLine());

        int n = Integer.parseInt(sc.nextLine());

        char[][] field = new char[n][n];

        int wormRow = 0, wormCol = 0;

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            field[i] = input.toCharArray();
            if (input.contains("P")) {
                wormRow = i;
                wormCol = input.indexOf("P");
            }
        }

        String input = sc.nextLine();
        while (!input.equals("end")) {
            int row = wormRow;
            int col = wormCol;
            switch (input){
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
            if (inBounds(row,col,n)){
                field[wormRow][wormCol] = '-';
                wormRow = row;
                wormCol = col;
                if (field[wormRow][wormCol] != '-'){
                    string.append(field[wormRow][wormCol]);
                }
                field[wormRow][wormCol] = 'P';
            } else {
                string.deleteCharAt(string.length()-1);
            }
            input = sc.nextLine();
        }
        System.out.println(string.toString());
        printMatrix(field);
    }

    private static boolean inBounds(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    public static void printMatrix(char[][] matrix){
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
