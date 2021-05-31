import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rowsAndCols = readIntArray(sc.nextLine(), " ");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        List<List<Integer>> matrix = makeMatrix(rows, cols);

        String command = sc.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            int row = Integer.parseInt(command.split(" ")[0]);
            int col = Integer.parseInt(command.split(" ")[1]);
            int radius = Integer.parseInt(command.split(" ")[2]);
            //remove vertical
            for (int v = row-radius; v <= row+radius; v++) {
                if (isInMatrix(matrix,v,col)){
                    matrix.get(v).remove(col);
                }
            }
            //remove horizontal
            for (int h = col+radius; h >= col-radius; h--) {
                if (isInMatrix(matrix, row, h)){
                    matrix.get(row).remove(h);
                }
            }
            matrix.removeIf(List::isEmpty);
            command = sc.nextLine();
        }
        printMatrix(matrix);
    }
    public static boolean isInMatrix(List<List<Integer>> matrix, int row, int col){
        return row>=0 && row < matrix.size() && col>= 0 && col < matrix.get(row).size();
    }

    public static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> makeMatrix(int rows, int cols) {
        List<List<Integer>> matrix = new ArrayList<>();
        int count = 1;
        for (int r = 0; r < rows; r++) {
            matrix.add(new ArrayList<>());
            for (int c = 0; c < cols; c++) {
                matrix.get(r).add(count++);
            }
        }
        return matrix;
    }

    public static int[] readIntArray(String line, String pattern) {
        return Arrays.stream(line.split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
