package TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] lights = sc.nextLine().split("\\s+");

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < lights.length; j++) {
                lights[j] = Signals.values()[(Signals.valueOf(lights[j]).ordinal()+1)%3].name();
                System.out.print(lights[j]+" ");
            }
            System.out.println();
        }
    }
}
