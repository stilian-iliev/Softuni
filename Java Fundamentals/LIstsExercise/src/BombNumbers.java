import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int bomb = input[0];
        int power = input[1];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(bomb)){
                explode(list,power,i);
            }
        }
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        System.out.println(sum);
    }

    private static void explode(List<Integer> list, int power, int bomb) {
        for (int i = bomb-power, j = bomb-power; j <= bomb+power; i++,j++) {
            if(i>=0 && i<list.size()){
                list.remove(i);
                i--;
            }
        }
    }
}
