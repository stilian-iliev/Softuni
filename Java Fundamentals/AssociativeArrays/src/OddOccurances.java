import java.util.*;

public class OddOccurances {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().toLowerCase(Locale.ROOT).split(" ");
        Map<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < input.length; i++) {
            map.putIfAbsent(input[i],0);
            map.put(input[i],map.get(input[i])+1);
        }
        List<String> odds = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if(stringIntegerEntry.getValue()%2==1){
                odds.add(stringIntegerEntry.getKey());
            }
        }
        System.out.printf("%s%n",String.join(", ",odds));
    }
}
