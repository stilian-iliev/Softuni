import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        String input = sc.nextLine();
        while (!input.equals("END")){
            if (input.contains("IN")){
                parkingLot.add(input.split(" ")[1]);
            } else if (input.contains("OUT")){
                parkingLot.remove(input.split(" ")[1]);
            }
            input = sc.nextLine();
        }
        if (parkingLot.isEmpty()) System.out.println("Parking Lot is Empty");
        for (String car : parkingLot) {
            System.out.println(car);
        }
    }
}
