import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = makeIntMatrix(n, n, sc);

        findMatrixDiagonals(n, matrix);
    }

    private static void findMatrixDiagonals(int n, int[][] matrix) {
        int[][] diagonals = new int[2][n];

        for (int j = 0, c=0; j < matrix.length; j++, c++) {
            diagonals[0][c] = matrix[j][j];
        }
        for (int i = matrix.length-1, c=0; i >= 0; i--, c++) {
            diagonals[1][c] = matrix[i][c];
        }
        printMatrix(diagonals);

    }
    private static void printMatrix(int[][] matrix) {
        for (int[] strings : matrix) {
            for (int string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public static int[] readIntArray(String line, String pattern) {
        return Arrays.stream(line.split(pattern)).mapToInt(Integer::parseInt).toArray();
    }

    public static int[][] makeIntMatrix(int rows, int cols, Scanner sc) {
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = readIntArray(sc.nextLine(), " ");
        }
        return matrix;
    }
}

