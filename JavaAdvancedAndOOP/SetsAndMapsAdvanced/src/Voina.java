import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Voina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayer = fillDeck(sc.nextLine());
        LinkedHashSet<Integer> secondPlayer = fillDeck(sc.nextLine());

        int rounds = 50;
        while (rounds-- > 0) {
            int pOneCard = getCard(firstPlayer);
            int pTwoCard = getCard(secondPlayer);

            firstPlayer.remove(pOneCard);
            secondPlayer.remove(pTwoCard);

            if (pOneCard>pTwoCard) {
                addCards(firstPlayer, pOneCard, pTwoCard);
            } else if (pTwoCard> pOneCard){
                addCards(secondPlayer, pOneCard, pTwoCard);
            }
        }
        if (firstPlayer.size() > secondPlayer.size()) System.out.println("First player win!");
        else if (secondPlayer.size() > firstPlayer.size()) System.out.println("Second player win!");
        else System.out.println("Draw");

    }

    private static void addCards(LinkedHashSet<Integer> player, int pOneCard, int pTwoCard) {
        player.add(pOneCard);
        player.add(pTwoCard);
    }

    private static int getCard(LinkedHashSet<Integer> deck) {
        return deck.stream().findFirst().orElse(0);
    }

    public static LinkedHashSet<Integer> fillDeck(String line) {
        LinkedHashSet<Integer> deck = new LinkedHashSet<>();
        int[] cards = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int card : cards) {
            deck.add(card);
        }
        return deck;
    }
}
