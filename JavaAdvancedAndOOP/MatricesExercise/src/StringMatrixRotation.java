import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String rotation = sc.nextLine();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(rotation);
        matcher.find();
        rotation = matcher.group(0);
        int rot = (Integer.parseInt(rotation) / 90) % 4;
        //1= 90 ; 2=180 ; 3 = 270 ; 4= 360;

        List<List<String>> matrix = new ArrayList<>();

        String string = sc.nextLine();
        while (!string.equals("END")) {
            fillMatrix(matrix, string.split(""));
            string = sc.nextLine();
        }
        int longestCol = findLongest(matrix);
        if (rot == 1) { //90
            print90Matrix(matrix, longestCol);
        } else if (rot == 2) { // 180
            print180Matrix(matrix,longestCol);
        } else if (rot == 3) { //270
            print270Matrix(matrix, longestCol);
        } else { //0
            print0Matrix(matrix);
        }
    }

    private static void print270Matrix(List<List<String>> matrix, int longestCol) {
        for (int c = longestCol; c >= 0; c--) {
            for (int r = 0; r < matrix.size(); r++) {
                if (checkIfInMatrix(matrix, r, c)){
                    System.out.print(matrix.get(r).get(c));
                } else System.out.print(" ");
            }
            System.out.println();

        }
    }

    private static void print180Matrix(List<List<String>> matrix, int longestCol) {
        for (int r = matrix.size()-1; r >= 0; r--) {
            for (int c = longestCol; c >= 0 ; c--) {
                if (checkIfInMatrix(matrix, r , c)){
                    System.out.print(matrix.get(r).get(c));
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void print90Matrix(List<List<String>> matrix, int longestCol) {
        for (int c = 0; c <= longestCol; c++) {
            for (int r = matrix.size()-1; r >= 0; r--) {
                if (checkIfInMatrix(matrix, r, c)){
                    System.out.print(matrix.get(r).get(c));
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static boolean checkIfInMatrix(List<List<String>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void print0Matrix(List<List<String>> matrix) {
        for (List<String> strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static int findLongest(List<List<String>> matrix) {
        int longest = Integer.MIN_VALUE;
        for (List<String> strings : matrix) {
            if (strings.size() > longest) longest = strings.size();
        }
        return --longest;
    }

    private static void fillMatrix(List<List<String>> matrix, String[] split) {
        List<String> list = new ArrayList<>(Arrays.asList(split));
        matrix.add(list);
    }
}
