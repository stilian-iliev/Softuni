import java.util.Arrays;
import java.util.Scanner;

public class MaxSumof2x2Submatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rowsAndCols = readIntArray(sc.nextLine(), ", ");

        int[][] matrix = makeIntMatrix(rowsAndCols, sc);

        findBiggestSubmatrix(matrix);

    }

    private static void findBiggestSubmatrix(int[][] matrix) {
        String firstRow = "";
        String secondRow = "";
        int biggestSum = Integer.MIN_VALUE;
        for (int r = 0; r < matrix.length-1; r++) {
            for (int c = 0; c < matrix[r].length-1; c++) {
                int currentSum = matrix[r][c] + matrix[r+1][c] + matrix[r][c+1] + matrix[r+1][c+1];
                if (currentSum>biggestSum){
                    biggestSum = currentSum;
                    firstRow = matrix[r][c] + " " + matrix[r][c+1];
                    secondRow = matrix[r+1][c] + " " + matrix[r+1][c+1];
                }
            }
        }
        System.out.println(firstRow);
        System.out.println(secondRow);
        System.out.println(biggestSum);
    }

    public static int[] readIntArray(String line, String pattern){
        return Arrays.stream(line.split(pattern)).mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] makeIntMatrix(int[] rowsAndCols, Scanner sc){
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r]= readIntArray(sc.nextLine(), ", ");
        }
        return  matrix;
    }
}