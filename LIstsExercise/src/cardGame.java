import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class cardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> firstPlayer = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        //loop until one deck has 0 cards
        //check the values of index 0
        //remove the smaller one
        //add the bigger then the smaller one in the bigger card deck
        while (firstPlayer.size()>0&&secondPlayer.size()>0){
            if (firstPlayer.get(0)>secondPlayer.get(0)){
                checkWinner(firstPlayer,secondPlayer);
            } else if (secondPlayer.get(0)>firstPlayer.get(0)){
                checkWinner(secondPlayer,firstPlayer);
            } else {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }
        }
        int sum = 0;
        if (firstPlayer.size()>secondPlayer.size()){
            for (Integer integer : firstPlayer) {
                sum+=integer;
            }
            System.out.printf("First player wins! Sum: %d%n",sum);
        } else if (secondPlayer.size()>firstPlayer.size()){
            for (Integer integer : secondPlayer) {
                sum+=integer;
            }
            System.out.printf("Second player wins! Sum: %d%n", sum);
        }
    }

    private static void checkWinner(List<Integer> winner, List<Integer> loser) {
        winner.add(winner.get(0));
        winner.add(loser.get(0));
        winner.remove(0);
        loser.remove(0);
    }
}
