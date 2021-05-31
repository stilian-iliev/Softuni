import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rowsAndCols = readAnArray(sc.nextLine(), " ");
        int[][] matrix = readMatrix(rowsAndCols, sc);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int number = Integer.parseInt(sc.nextLine());

        boolean found = false;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (matrix[r][c] == number){
                    found =true;
                    System.out.println(r +" "+ c);
                }
            }
        }
        if (!found){
            System.out.println("not found");
        }

    }

    private static int[][] readMatrix(int[] rowsAndCols, Scanner sc) {
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r]=readAnArray(sc.nextLine()," ");
        }
        return matrix;
    }

    private static int[] readAnArray(String nextLine, String pattern) {
        return Arrays.stream(nextLine.split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
