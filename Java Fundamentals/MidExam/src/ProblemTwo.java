import java.util.*;

public class ProblemTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(", ");
        List<String> names = new ArrayList<>(Arrays.asList(input));
        String[] command = sc.nextLine().split(" ");
        List<String> blacklisted = new ArrayList<>();
        while (!command[0].equals("Report")) {
            switch (command[0]) {
                case "Blacklist":
                    if (names.contains(command[1])) {
                        for (int i = 0; i < names.size(); i++) {
                            if (names.get(i).equals(command[1])) {
                                names.set(i, "Blacklisted");
                            }
                        }
                        blacklisted.add(command[1]);
                        System.out.println(command[1] + " was blacklisted.");
                    } else {
                        System.out.println(command[1] + " was not found.");
                    }
                    break;
                case "Error":
                    if (names.get(Integer.parseInt(command[1])).equals("Lost") && Integer.parseInt(command[1])<names.size()) {
                    } else if (!names.get(Integer.parseInt(command[1])).equals("Blacklisted") && Integer.parseInt(command[1])<names.size()) {
                        System.out.println(names.get(Integer.parseInt(command[1])) + " was lost due to an error.");
                        names.set(Integer.parseInt(command[1]), "Lost");
                    }
                    break;
                case "Change":
                    if (Integer.parseInt(command[1]) < names.size() && Integer.parseInt(command[1])>=0) {
                        String temp = names.get(Integer.parseInt(command[1]));
                        names.set(Integer.parseInt(command[1]), command[2]);
                        System.out.printf("%s changed his username to %s.%n", temp, command[2]);
                    }
                    break;
            }
            command = sc.nextLine().split(" ");
        }
        int lostNames = 0;
        for (String name : names) {
            if (name.equals("Lost")) {
                lostNames++;
            }
        }
        System.out.println("Blacklisted names: " + blacklisted.size());
        System.out.println("Lost names: " + lostNames);
        System.out.println(String.join(" ", names));
    }
}
