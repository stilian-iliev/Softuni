import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rowsAndCold = new int[2];
        rowsAndCold[0] = Integer.parseInt(sc.nextLine());
        rowsAndCold[1] = Integer.parseInt(sc.nextLine());

        String[][] firstMatrix = readMatrix(rowsAndCold, sc);
        String[][] secondMatrix = readMatrix(rowsAndCold, sc);

        String[][] thirdMatrix = makeThirdMatrix(firstMatrix,secondMatrix, rowsAndCold);

        printMatrix(thirdMatrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static String[][] makeThirdMatrix(String[][] firstMatrix, String[][] secondMatrix, int[]rowsandcols) {
        int rows = rowsandcols[0];
        int cols = rowsandcols[1];
        String[][] thirdMatrix = new String[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (firstMatrix[r][c].equals(secondMatrix[r][c])){
                    thirdMatrix[r][c] = firstMatrix[r][c];
                } else {
                    thirdMatrix[r][c] = "*";
                }
            }
        }
        return thirdMatrix;
    }

    private static String[][] readMatrix(int[] rowsAndCols, Scanner sc) {
        int row = rowsAndCols[0];
        int cols = rowsAndCols[1];
        String[][] matrix = new String[row][cols];
        for (int r = 0; r < row; r++) {
            matrix[r] = readCharArray(sc.nextLine());
        }
        return matrix;
    }

    private static int[] readIntArray(String nextLine) {
        return Arrays.stream(nextLine.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static String[] readCharArray(String nextLine) {
        return nextLine.split("\\s+");
    }
}

