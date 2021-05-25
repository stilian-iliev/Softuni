import java.util.*;

public class CompareMAtrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[][]> matrices = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int[] rowsandcols = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int rows = rowsandcols[0];
            int cols = rowsandcols[1];
            int[] numbers = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] numbers2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrices.add(makeMatrix(rows, cols, numbers, numbers2));
        }
        boolean equal = checkIfEqual(matrices);
        if (equal) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean checkIfEqual(List<int[][]> matrices) {
        if(matrices.get(0).length != matrices.get(1).length || matrices.get(0)[0].length != matrices.get(1)[0].length){
            return false;
        }
        boolean equal = true;
        for (int i = 0; i < matrices.get(0).length; i++) {
            for (int j = 0; j < matrices.get(0)[0].length; j++) {
                if (matrices.get(0)[i][j] != matrices.get(1)[i][j]) {
                    equal = false;
                    break;
                }
            }
        }
        return equal;
    }

    private static int[][] makeMatrix(int rows, int cols, int[] numbers, int[]numbers2) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int number : numbers) {
            queue.offer(number);
        }
        for (int i : numbers2) {
            queue.offer(i);
        }
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = queue.poll();
            }
        }
        return matrix;
    }
}
