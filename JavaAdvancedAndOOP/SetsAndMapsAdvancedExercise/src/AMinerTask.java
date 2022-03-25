import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, Integer> map =  new LinkedHashMap<>();
        String resource = sc.nextLine();
        while (!resource.equals("stop")){
            int quantity = Integer.parseInt(sc.nextLine());
            map.putIfAbsent(resource,0);
            map.put(resource,map.get(resource)+quantity);
            resource = sc.nextLine();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s -> %d%n",entry.getKey(),entry.getValue());
        }
    }
}
