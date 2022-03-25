import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pokemon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        while (list.size() > 0) {
            int inputIndex = Integer.parseInt(sc.nextLine());
            int element = 0;
            if (inputIndex >= list.size()) {
                //remove last and copy  the first element to its place
                int temp = list.get(0);
                element = list.get(list.size() - 1);
                list.set(list.size()-1,temp);
            } else if (inputIndex < 0) {
                //remove index 0 and put last on index 0
                int temp = list.get(list.size()-1);
                element = list.get(0);
                list.set(0,temp);
            } else {
                element = list.get(inputIndex);
                list.remove(inputIndex);
            }
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) <= element) {
                    list.set(i, list.get(i) + element);
                } else {
                    list.set(i, list.get(i) - element);
                }
            }
            sum += element;
        }
        System.out.println(sum);
    }
}
