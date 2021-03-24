import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> input = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        double leftCar = 0;
        double rightCar = 0;
        for (int i = 0; i < input.size(); i++) {
            if(i<input.size()/2){
                leftCar = calculateTime(input,i,leftCar);
            } else {
                rightCar = calculateTime(input,i,rightCar);
            }
        }
        if (leftCar<rightCar){
            System.out.printf("The winner is left with total time: %s",new DecimalFormat("0.#").format(leftCar));
        } else {
            System.out.printf("The winner is right with total time: %s",new DecimalFormat("0.#").format(rightCar));
        }
    }

    private static double calculateTime(List<Integer> input, int i, double car) {
        if(input.get(i)==0){
            car *= 0.8;
        } else {
            car += input.get(i);
        }
        return car;
    }
}
