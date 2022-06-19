import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class problemThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> cards = new ArrayList<>();
        String[] input = sc.nextLine().split(":");
        Collections.addAll(cards, input);
        List<String> deck = new ArrayList<>();

        String[] command = sc.nextLine().split(" ");
        while (!command[0].equals("Ready")) {
            switch (command[0]) {
                case "Add":
                    if (cards.contains(command[1])) {
                        deck.add(command[1]);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    String cardName = command[1];
                    if (cards.contains(cardName) && index < deck.size() && index>=0) {
                        deck.add(index, cardName);
                    } else {
                        System.out.println("Error!");
                    }
                    break;
                case "Remove":
                    cardName = command[1];
                    if (deck.contains(command[1])) {
                        deck.remove(cardName);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    swapCards(deck, command[1], command[2]);
                    break;
                case "Shuffle":
                    shuffledeck(deck);
                    break;
            }

            command = sc.nextLine().split(" ");
        }
        System.out.println(String.join(" ", deck));
    }

    private static void swapCards(List<String> deck, String card1, String card2) {
        int firstCardIndex = 0;
        int secondCardIndex = 0;
        for (int i = 0; i < deck.size(); i++) {
            if (deck.get(i).equals(card1)) {
                firstCardIndex = i;
            }
            if (deck.get(i).equals(card2)) {
                secondCardIndex = i;
            }
            deck.set(firstCardIndex, card2);
            deck.set(secondCardIndex, card1);
        }
    }

    private static void shuffledeck(List<String> deck) {
        Collections.reverse(deck);
    }
}
