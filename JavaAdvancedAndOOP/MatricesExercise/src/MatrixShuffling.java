import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rowsAndCols = readIntArray(sc.nextLine(), "\\s+");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        String[][] matrix = readStringMatrix(rows, cols, sc);

        String[] command = readStringArray(sc.nextLine(), "\\s+");
        while (!command[0].equals("END")) {
            if (command[0].equals("swap") && command.length == 5 && valid(command, rows,cols)) {
                swapElements(matrix, command);
                printMatrix(matrix);
            } else printInvalid();

            command = readStringArray(sc.nextLine(), "\\s+");
        }


    }

    private static boolean valid(String[] command, int rows, int cols) {
        boolean valid = true;
        int row1 = Integer.parseInt(command[1]);
        int col1 = Integer.parseInt(command[2]);
        int row2 = Integer.parseInt(command[3]);
        int col2 = Integer.parseInt(command[4]);
        if (row1<0 || row1>=rows) valid = false;
        if (row2<0 || row2>=rows) valid = false;
        if (col1<0 || col1>=cols) valid = false;
        if (col2<0 || col2>=cols) valid = false;
        return valid;
    }

    private static void swapElements(String[][] matrix, String[] command) {
        int row1 = Integer.parseInt(command[1]);
        int col1 = Integer.parseInt(command[2]);
        int row2 = Integer.parseInt(command[3]);
        int col2 = Integer.parseInt(command[4]);
        String firstElement = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = firstElement;
    }

    private static void printInvalid() {
        System.out.println("Invalid input!");
    }

    private static String[][] readStringMatrix(int rows, int cols, Scanner sc) {
        String[][] matrix = new String[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = readStringArray(sc.nextLine(), " ");
        }
        return matrix;
    }

    private static String[] readStringArray(String nextLine, String pattern) {
        return nextLine.split(pattern);
    }

    private static int[] readIntArray(String nextLine, String pattern) {
        return Arrays.stream(nextLine.split(pattern)).mapToInt(Integer::parseInt).toArray();
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] ints : matrix) {
            for (String anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
