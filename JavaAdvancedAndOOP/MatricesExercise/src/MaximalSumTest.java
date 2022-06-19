import java.util.Arrays;
import java.util.Scanner;

public class MaximalSumTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d%n",n,i,n*i);
        }
    }

    private static void findBiggestSumInMatrix(int[][] matrix, int size) {
        int biggestSum = Integer.MIN_VALUE;
        int[] biggestIndex = new int[2];
        for (int r = 0; r < matrix.length - (size-1); r++) {
            for (int c = 0; c < matrix[r].length - (size-1); c++) {
                int sum = calculateSubmatrixSum(r, c, matrix, size);
                if (sum > biggestSum) {
                    biggestSum = sum;
                    biggestIndex[0] = r;
                    biggestIndex[1] = c;
                }
            }
        }
        int[][] biggestSubmatrix = extractSubmatrix(biggestIndex, matrix, size, size);
        printMatrix(biggestSubmatrix);
        System.out.println(biggestSum);
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

    private static int[][] readIntMatrix(int rows, int cols, Scanner sc, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = readIntArray(sc.nextLine(), pattern);
        }
        return matrix;
    }

    private static int[] readIntArray(String nextLine, String pattern) {
        return Arrays.stream(nextLine.split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
