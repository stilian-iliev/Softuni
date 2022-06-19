import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(", ");
        int n = Integer.parseInt(tokens[0]);
        String method = tokens[1];
        int[][] matrix = new int[n][n];
        if (method.equals("A")) {
            matrix = firstMethod(n);
        } else if (method.equals("B")) {
            matrix = secondMethod(n);
        }

        readMatrix(matrix);
    }

    private static void readMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[][] firstMethod(int n) {
        int[][] matrix = new int[n][n];
        int counter = 1;
        for (int c = 0; c < n; c++) {
            for (int r = 0; r < n; r++) {
                matrix[r][c] = counter;
                counter++;
            }
        }
        return matrix;
    }

    private static int[][] secondMethod(int n) {
        int[][] matrix = new int[n][n];
        int counter = 1;
        int r = 0;
        for (int c = 0; c < n; c++) {
            if (c % 2 == 0) {
                r = 0;
            } else {
                r = n-1;
            }
            for (int i = 0; i < n; i++) {
                matrix[r][c] = counter;
                if (c % 2 == 0) {
                    r++;
                } else {
                    r--;
                }
                counter++;
            }
        }
        return matrix;
    }
}
