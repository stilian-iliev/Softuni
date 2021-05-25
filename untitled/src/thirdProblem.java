import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class thirdProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = Integer.parseInt(sc.nextLine());
        String[] command = sc.nextLine().split("=");
        Map<String, Integer> userReceived = new LinkedHashMap<>();
        Map<String, Integer> userSent = new LinkedHashMap<>();
        while (!command[0].equals("Statistics")) {
            switch (command[0]) {
                case "Add":
                    String username = command[1];
                    int sent = Integer.parseInt(command[2]);
                    int received = Integer.parseInt(command[3]);
                    userSent.putIfAbsent(username, sent);
                    userReceived.putIfAbsent(username, received);
                    break;
                case "Message":
                    String sender = command[1];
                    String receiver = command[2];
                    if (userSent.containsKey(sender) && userSent.containsKey(receiver)) {
                        userSent.put(sender, userSent.get(sender) + 1);
                        removeIfReachedCapacity(capacity, sender, userSent, userReceived);
                        userReceived.put(receiver, userReceived.get(receiver) + 1);
                        removeIfReachedCapacity(capacity, receiver, userSent, userReceived);
                    }
                    break;
                case "Empty":
                    username = command[1];
                    if (username.equals("All")) {
                        userSent.clear();
                        userReceived.clear();
                    } else if (userSent.containsKey(username)) {
                        userSent.remove(username);
                        userReceived.remove(username);
                    }
                    break;
            }
            command = sc.nextLine().split("=");
        }
        userReceived = userReceived.entrySet().stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()).thenComparing(Map.Entry.comparingByKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("Users count: "+ userReceived.size());
        for (Map.Entry<String, Integer> received : userReceived.entrySet()) {
            System.out.printf("%s - %d%n",received.getKey(), received.getValue()+userSent.get(received.getKey()));
        }
    
    }

    private static void removeIfReachedCapacity(int capacity, String user, Map<String, Integer> userSent, Map<String, Integer> userReceived) {
        if (userSent.get(user) + userReceived.get(user) >= capacity) {
            userSent.remove(user);
            userReceived.remove(user);
            System.out.printf("%s reached the capacity!%n", user);
        }
    }
}
