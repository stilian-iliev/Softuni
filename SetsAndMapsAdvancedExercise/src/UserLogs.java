import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String,Integer>> logs = new TreeMap<>();
        String[] input = sc.nextLine().split("\\s+");
        while (!input[0].equals("end")){
            String username = input[2].split("=")[1];
            String ip = input[0].split("=")[1];
            logs.putIfAbsent(username, new LinkedHashMap<>());
            logs.get(username).putIfAbsent(ip,0);
            logs.get(username).put(ip, logs.get(username).get(ip)+1);

            input = sc.nextLine().split("\\s+");
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : logs.entrySet()) {
            System.out.printf("%s:%n",entry.getKey());
            int ipCount = entry.getValue().size();
            for (Map.Entry<String, Integer> ips : entry.getValue().entrySet()) {
                if (ipCount>1){
                    System.out.printf("%s => %d, ",ips.getKey(),ips.getValue());
                }else {
                    System.out.printf("%s => %d.%n",ips.getKey(),ips.getValue());
                }
                ipCount--;
            }
        }
    }
}
