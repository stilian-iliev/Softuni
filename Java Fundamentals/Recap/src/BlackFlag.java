import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double days = Integer.parseInt(sc.nextLine());
        double dailyPlunder = Integer.parseInt(sc.nextLine());
        double expected = Integer.parseInt(sc.nextLine());

        double plunder = 0;

        for (int i = 1; i <= days; i++) {
            plunder += dailyPlunder;
            if (i % 3 == 0) {
                plunder += dailyPlunder * 0.5;
            }
            if (i % 5 == 0) {
                plunder *= 0.70;
            }
        }
        if (plunder >= expected) {
            System.out.printf("Ahoy! %.2f plunder gained.%n", plunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", plunder / expected * 100);
        }
    }
}
