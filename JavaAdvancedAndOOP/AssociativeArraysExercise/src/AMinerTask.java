import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> resources = new LinkedHashMap<>();
        String resource = sc.nextLine();
        while (!resource.equals("stop")){
            int quantity = Integer.parseInt(sc.nextLine());
            resources.putIfAbsent(resource,0);
            resources.put(resource,resources.get(resource)+quantity);

            resource = sc.nextLine();
        }
        for (Map.Entry<String, Integer> resourceEntry : resources.entrySet()) {
            System.out.printf("%s -> %s%n",resourceEntry.getKey(),resourceEntry.getValue());
        }
    }
}
