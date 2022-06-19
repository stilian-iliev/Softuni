import java.util.Scanner;

public class problemOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countOfOrders = Integer.parseInt(sc.nextLine());
        double sum = 0;
        for (int i = 0; i < countOfOrders; i++) {
            double price = Double.parseDouble(sc.nextLine());
            int days = Integer.parseInt(sc.nextLine());
            int capsules = Integer.parseInt(sc.nextLine());
            double formula = (days * capsules) * price;
            sum += formula;
            System.out.printf("The price for the coffee is: $%.2f%n", formula);
        }
        System.out.printf("Total: $%.2f%n", sum);
    }
}
