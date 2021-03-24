import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int wagonCapacity = Integer.parseInt(sc.nextLine());
        String[] input = sc.nextLine().split(" ");
        while (!input[0].equals("end")){
            switch (input[0]){
                case "Add":
                    wagons.add(Integer.parseInt(input[1]));
                    break;
                default:
                    wagons = fitPassangers(wagonCapacity,wagons,Integer.parseInt(input[0]));
            }
            input = sc.nextLine().split(" ");
        }
        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }

    private static List<Integer> fitPassangers(int capacity, List<Integer> wagons, int passangers) {
        for (int i = 0; i < wagons.size(); i++) {
            if (wagons.get(i)+passangers<=capacity){
                wagons.set(i,wagons.get(i)+passangers);
                break;
            }
        }
        return wagons;
    }
}
