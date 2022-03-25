import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rowsAndCols = readIntArray(sc.nextLine(), " ");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = readIntMatrix(rows, cols, sc);
        findBiggestSumInMatrix(matrix);
    }

    private static void findBiggestSumInMatrix(int[][] matrix) {
        int biggestSum = Integer.MIN_VALUE;
        int[] biggestIndex = new int[2];
        for (int r = 0; r < matrix.length - 2; r++) {
            for (int c = 0; c < matrix[r].length - 2; c++) {
                int sum = calculateSubmatrixSum(r, c, matrix, 3);
                if (sum > biggestSum) {
                    biggestSum = sum;
                    biggestIndex[0] = r;
                    biggestIndex[1] = c;
                }
            }
        }
        System.out.println("Sum = " + biggestSum);
        int[][] biggestSubmatrix = extractSubmatrix(biggestIndex, matrix, 3, 3);
        printMatrix(biggestSubmatrix);
    }

    private static int calculateSubmatrixSum(int row, int col, int[][] matrix, int size) {
        int sum = 0;
        for (int r = row, i = 0; i < size; r++, i++) {
            for (int c = col, j = 0; j < size; c++, j++) {
                sum += matrix[r][c];
            }
        }
        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[][] extractSubmatrix(int[] index, int[][] matrix, int rows, int cols) {
        int[][] submatrix = new int[rows][cols];
        for (int i = 0, r = index[0]; i < rows; i++, r++) {
            for (int j = 0, c = index[1]; j < cols; j++, c++) {
                submatrix[i][j] = matrix[r][c];
            }
        }
        return submatrix;
    }

    private static int[][] readIntMatrix(int rows, int cols, Scanner sc) {
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = readIntArray(sc.nextLine(), " ");
        }
        return matrix;
    }

    private static int[] readIntArray(String nextLine, String pattern) {
        return Arrays.stream(nextLine.split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
