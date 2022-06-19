package HotelReservation;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2].toUpperCase(Locale.ROOT));

        double price = new PriceCalculator(pricePerDay, days, season, input[3]).calculate();

        System.out.printf("%.2f%n", price);
    }
}
