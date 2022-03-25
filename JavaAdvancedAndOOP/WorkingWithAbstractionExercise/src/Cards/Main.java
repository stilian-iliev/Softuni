package Cards;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CardRank rank = CardRank.valueOf(sc.nextLine());
        CardSuit suit = CardSuit.valueOf(sc.nextLine());

        int cardPower = CardPowerCalculator.calculate(rank,suit);
        System.out.printf("Card name: %s of %s; Card power: %d%n",rank,suit,cardPower);

//        if (input.equals("Card Suits")){
//            System.out.println("Card Suits:");
//            printCardSuit();
//        } else if (input.equals("Card Ranks")){
//            System.out.println("Card Ranks:");
//            printCardRanks();
//        }
    }

    private static void printCardRanks() {
        for (CardRank value : CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",value.ordinal(),value);
        }
    }

    private static void printCardSuit(){
        for (CardSuit value : CardSuit.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",value.ordinal(),value);
        }
    }
}
