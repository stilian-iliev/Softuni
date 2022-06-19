import java.util.*;

public class CompareMAtrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] rowsAndCols = readIntArray(sc.nextLine());
        int[][] firstMatrix = readMatrix(rowsAndCols, sc);
        rowsAndCols = readIntArray(sc.nextLine());
        int[][] secondMatrix = readMatrix(rowsAndCols, sc);

        if (matricesAreEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else System.out.println("not equal");

    }

    private static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length) return false;

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] readMatrix(int[] rowsAndCols, Scanner sc) {
        int row = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = new int[row][cols];
        for (int r = 0; r < row; r++) {
            matrix[r] = readIntArray(sc.nextLine());
        }
        return matrix;
    }

    private static int[] readIntArray(String nextLine) {
        return Arrays.stream(nextLine.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
