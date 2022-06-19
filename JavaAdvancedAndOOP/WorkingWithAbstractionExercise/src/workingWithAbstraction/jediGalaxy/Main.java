package workingWithAbstraction.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dimensions = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int x = dimensions[0];
        int y = dimensions[1];

        Matrix matrix = new Matrix();
        matrix.fill(x,y);


        String command = sc.nextLine();
        while (!command.equals("Let the Force be with you")) {
            int[] IvoCoordinates = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] evilCoordinates = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix.destroy(evilCoordinates);

            matrix.collectStars(IvoCoordinates);

            command = sc.nextLine();
        }
        System.out.println(matrix.getCollectedStars());

    }
}
