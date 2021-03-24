import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Parking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, String> parking = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] command = sc.nextLine().split(" ");
            String name = command[1];
            switch (command[0]) {
                case "register":
                    String license = command[2];
                    if (parking.containsKey(name)) {
                        System.out.println("ERROR: already registered with plate number " + parking.get(name));
                    } else {
                        parking.putIfAbsent(name, license);
                        System.out.printf("%s registered %s successfully%n", name,license);
                    }
                    break;
                case "unregister":
                    if(parking.containsKey(name)){
                        parking.remove(name);
                        System.out.printf("%s unregistered successfully%n",name);
                    } else {
                        System.out.printf("ERROR: user %s not found%n",name);
                    }
                    break;
            }
        }
        for (Map.Entry<String, String> parkedVehicles : parking.entrySet()) {
            System.out.printf("%s => %s%n",parkedVehicles.getKey(),parkedVehicles.getValue());
        }
    }
}
