import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] initial = sc.nextLine().split("\\|");
        List<String> chest = new ArrayList<>();
        for (String item : initial) {
            chest.add(item);
        }
        String[] input = sc.nextLine().split(" ");
        while (!input[0].equals("Yohoho!")) {
            switch (input[0]) {
                case "Loot":
                    addLoot(chest, input);
                    break;
                case "Drop":
                    dropLoot(Integer.parseInt(input[1]), chest);
                    break;
                case "Steal":
                    stealLoot(Integer.parseInt(input[1]), chest);
                    break;
            }
            input = sc.nextLine().split(" ");
        }
        if (chest.size() == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            double gain = (double) findTreasureGain(chest) / chest.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", gain);
        }
    }

    private static int findTreasureGain(List<String> chest) {
        int sum = 0;
        for (String item : chest) {
            sum += item.length();
        }
        return sum;
    }

    private static void stealLoot(int count, List<String> chest) {
        List<String> stolen = new ArrayList<>();
        for (int i = 0; i < count && chest.size() > 0; i++) {
            stolen.add(chest.get(chest.size() - 1));
            chest.remove(chest.size() - 1);
        }
        Collections.reverse(stolen);
        System.out.println(String.join(", ",stolen));
    }

    private static void dropLoot(int i, List<String> chest) {
        if (i >= 0 && i < chest.size()) {
            String temp = chest.get(i);
            chest.remove(i);
            chest.add(temp);
        }
    }

    private static void addLoot(List<String> chest, String[] input) {
        for (int i = 1; i < input.length; i++) {
            if (!chest.contains(input[i])) {
                String item = input[i];
                chest.add(0, item);
            }
        }
    }
}
