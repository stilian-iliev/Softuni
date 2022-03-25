import java.util.HashMap;
import java.util.Map;

public class FindOdd {
    public static int findIt(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.putIfAbsent(i,0);
            map.put(i, map.get(i) + 1);
        }
        return map.entrySet().stream().filter(c -> c.getValue()%2 == 1).findFirst().map(Map.Entry::getKey).orElseThrow();
    }
}