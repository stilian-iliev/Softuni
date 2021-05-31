import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rowsAndCols = readIntArray(sc.nextLine(), ", ");

        int[][] matrix = makeIntMatrix(rowsAndCols, sc);

        int sum = Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .sum();

        System.out.println(rowsAndCols[0]);
        System.out.println(rowsAndCols[1]);
        System.out.println(sum);


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
