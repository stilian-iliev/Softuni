import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = readMatrix(n, n, sc);

        printDiagonalDifference(matrix);
    }

    private static void printDiagonalDifference(int[][] matrix) {
        int firstSum = 0;
        int secondSum = 0;
        for (int i = 0, j = matrix.length-1; i < matrix.length; i++, j--) {
            firstSum += matrix[i][i];
            secondSum += matrix[j][i];
        }
        int difference = Math.abs(firstSum-secondSum);
        System.out.println(difference);
    }

    private static int[][] readMatrix(int rows, int cols, Scanner sc) {
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = readIntArray(sc.nextLine(), " ");
        }
        return matrix;
    }

    public static int[] readIntArray(String line, String pattern) {
        return Arrays.stream(line.split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
