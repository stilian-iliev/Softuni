import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] input = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        String[][] matrix = makeAMatrix(rows,cols);
        readMatrix(matrix);

    }
    private static void readMatrix(String[][] matrix) {
        for (String[] ints : matrix) {
            for (String anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static String[][] makeAMatrix(int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char outer = (char)(r+97);
                char inner = (char)(c+r+97);
                matrix[r][c] = "" + outer + inner + outer;
            }
        }
        return matrix;
    }
}
