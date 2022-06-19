import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[] commands = sc.nextLine().split(",\\s+");

        char[][] field = new char[n][n];

        int snakeRow = 0, snakeCol = 0;

        int foodAvailable = 0;

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] arr = input.split(" ");
            for (int j = 0; j < n; j++) {
                field[i][j] = arr[j].charAt(0);
                if (arr[j].equals("s")){
                    snakeRow = i;
                    snakeCol = j;
                } else if (arr[j].equals("f")){
                    foodAvailable++;
                }
            }
        }
        int foodEaten = 1;

        boolean killed = false;

        for (String command : commands) {
            field[snakeRow][snakeCol] = '*';
            switch (command){
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
            snakeRow = check(snakeRow,n);
            snakeCol = check(snakeCol,n);

            switch (field[snakeRow][snakeCol]){
                case 'e':
                    System.out.println("You lose! Killed by an enemy!");
                    return;
                case 'f':
                    foodAvailable--;
                    foodEaten++;
                    break;
            }
            field[snakeRow][snakeCol] = 's';
            if (foodAvailable == 0) break;
        }
        if (foodAvailable == 0){
            System.out.println("You win! Final python length is "+ foodEaten);
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.%n",foodAvailable);
        }
    }

    private static int check(int snakeRow, int n) {
        if (snakeRow<0){
            snakeRow = n-1;
        } else if (snakeRow>=n){
            snakeRow = 0;
        }
        return snakeRow;
    }
    private static void print(char[][] matrix){
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}
