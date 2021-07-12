package Cards;

public class CardPowerCalculator {

    public static int calculate(CardRank rank, CardSuit suit){
        return rank.getPower()+suit.getPower();
    }
}
