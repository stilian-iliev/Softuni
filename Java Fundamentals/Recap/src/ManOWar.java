import java.util.Arrays;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pirateShip = Arrays.stream(sc.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int[] warShip = Arrays.stream(sc.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int maxHp = Integer.parseInt(sc.nextLine());
        String[] command = sc.nextLine().split(" ");
        while (!command[0].equals("Retire")) {
            switch (command[0]) {
                case "Fire":
                    int index = Integer.parseInt(command[1]);
                    pirateAttack(Integer.parseInt(command[1]), Integer.parseInt(command[2]), warShip);
                    if (index < warShip.length && index >= 0 && warShip[index] <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                    break;
                case "Defend":
                    int start = Integer.parseInt(command[1]);
                    int end = Integer.parseInt(command[2]);
                    warshipAttack(Integer.parseInt(command[1]), Integer.parseInt(command[2]), Integer.parseInt(command[3]), pirateShip);
                    for (int i = Integer.parseInt(command[1]); i < Integer.parseInt(command[2]); i++) {
                        if (start < pirateShip.length && end < pirateShip.length && start >= 0 && end >= 0 && pirateShip[i] <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        }
                    }
                    break;
                case "Repair":
                    repairShip(Integer.parseInt(command[1]), Integer.parseInt(command[2]), pirateShip, maxHp);
                    break;
                case "Status":
                    checkStatusOfShip(pirateShip, maxHp);
                    break;
            }
            command = sc.nextLine().split(" ");
        }
        int pirate = findShipSum(pirateShip);
        int war = findShipSum(warShip);
        System.out.println("Pirate ship status: " + pirate);
        System.out.println("Warship status: " + war);
    }


    private static void pirateAttack(int index, int damage, int[] warShip) {
        if (index < warShip.length && index >= 0) {
            warShip[index] = warShip[index] - damage;
        }
    }

    private static void warshipAttack(int start, int end, int damage, int[] pirateShip) {
        if (start < pirateShip.length && end < pirateShip.length && start >= 0 && end >= 0) {
            for (int i = start; i <= end; i++) {
                pirateShip[i] = pirateShip[i] - damage;
            }
        }
    }

    private static void repairShip(int index, int hp, int[] pirateShip, int max) {
        if (index < pirateShip.length && index >= 0) {
            pirateShip[index] += hp;
            if (pirateShip[index] > max) {
                pirateShip[index] = max;
            }
        }
    }

    private static void checkStatusOfShip(int[] pirateShip, int maxHp) {
        int count = 0;
        for (int i : pirateShip) {
            if (i < (maxHp * 0.2)) {
                count++;
            }
        }
        System.out.println(count + " sections need repair.");
    }

    private static int findShipSum(int[] Ship) {
        int sum = 0;
        for (int i : Ship) {
            sum += i;
        }
        return sum;
    }
}
