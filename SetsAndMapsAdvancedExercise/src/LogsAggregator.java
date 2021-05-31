import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> logsTime = new HashMap<>();
        TreeMap<String, TreeSet<String>> logsIps = new TreeMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String username = input[1];
            String ip = input[0];
            int time = Integer.parseInt(input[2]);

            logsTime.putIfAbsent(username, 0);
            logsTime.put(username, logsTime.get(username) + time);

            logsIps.putIfAbsent(username, new TreeSet<>());
            logsIps.get(username).add(ip);
        }
        for (Map.Entry<String, TreeSet<String>> entry : logsIps.entrySet()) {
            System.out.printf("%s: %d ",entry.getKey(), logsTime.get(entry.getKey()));
            System.out.printf("[%s]%n",String.join(", ",entry.getValue()));
        }
    }
}
