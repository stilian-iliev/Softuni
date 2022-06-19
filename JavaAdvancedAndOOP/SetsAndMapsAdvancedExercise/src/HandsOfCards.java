import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<>();

        String[] input = sc.nextLine().split(": ");
        while (!input[0].equals("JOKER")) {
            String name = input[0];
            String[] cards = input[1].split(", ");
            players.putIfAbsent(name, new HashSet<>());
            for (String card : cards) {
                players.get(name).add(card);
            }
            input = sc.nextLine().split(": ");
        }
        for (Map.Entry<String, HashSet<String>> entry : players.entrySet()) {
            String name = entry.getKey();
            int value = 0;
            for (String card : entry.getValue()) {
                String number = card.substring(0, card.length() - 1);
                String multiplier = card.substring(card.length() - 1);
                int n = 0;
                switch (number) {
                    case "J":
                        n = 11;
                        break;
                    case "Q":
                        n = 12;
                        break;
                    case "K":
                        n = 13;
                        break;
                    case "A":
                        n = 14;
                        break;
                    default:
                        n = Integer.parseInt(number);
                        break;
                }
                int m = 0;
                switch (multiplier) {
                    case "S":
                        m = 4;
                        break;
                    case "H":
                        m = 3;
                        break;
                    case "D":
                        m = 2;
                        break;
                    case "C":
                        m = 1;
                        break;
                }
                value += n * m;
            }
            System.out.printf("%s: %d%n", name, value);
        }
    }
}
