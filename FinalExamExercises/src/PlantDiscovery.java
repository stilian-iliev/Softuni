import java.util.*;
import java.util.stream.Collectors;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Integer> plantsRarity = new LinkedHashMap<>();
        Map<String, List<Integer>> plantsRating = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] plant = sc.nextLine().split("<->");
            plantsRarity.put(plant[0], Integer.parseInt(plant[1]));
            plantsRating.put(plant[0], new ArrayList<>());
        }
        String[] command = sc.nextLine().split("\\s+");
        while (!command[0].equals("Exhibition")) {
            String plant = command[1];
            if (plantsRarity.containsKey(plant)) {
                switch (command[0]) {
                    case "Rate:":
                        if (command.length == 4) {
                            String rating = command[3];
                            boolean valid = true;
                            for (int i = 0; i < rating.length(); i++) {
                                char curr = rating.charAt(i);
                                if (!Character.isDigit(curr)) {
                                    System.out.println("error");
                                    valid = false;
                                    break;
                                }
                            }
                            if (valid) {
                                plantsRating.get(plant).add(Integer.parseInt(rating));
                            }
                        }
                        break;
                    case "Update:":
                        if (command.length == 4) {
                            String newRarity = command[3];
                            boolean valid = true;
                            for (int i = 0; i < newRarity.length(); i++) {
                                char curr = newRarity.charAt(i);
                                if (!Character.isDigit(curr)) {
                                    System.out.println("error");
                                    valid = false;
                                    break;
                                }
                            }
                            if (valid){
                                plantsRarity.put(plant,Integer.parseInt(newRarity));
                            }
                        }
                        break;
                    case "Reset:":
                        plantsRating.get(plant).clear();
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
            } else {
                System.out.println("error");
            }
            command = sc.nextLine().split("\\s+");
        }
        Map <String, Double> plantAverageRating = new LinkedHashMap<>();
        for (Map.Entry<String, List<Integer>> stringListEntry : plantsRating.entrySet()) {
            if (stringListEntry.getValue().size() == 0){
                stringListEntry.getValue().add(0);
            }
            int counter = 0;
            int sum = 0;
            for (int i = 0; i < stringListEntry.getValue().size(); i++) {
                counter++;
                sum+= stringListEntry.getValue().get(i);
            }
            double average = (double)sum/counter;
            plantAverageRating.put(stringListEntry.getKey(), average);
        }
        Map<String, Integer> sorted = plantsRarity.entrySet().stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Integer> stringIntegerEntry : sorted.entrySet()) {
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",stringIntegerEntry.getKey(),stringIntegerEntry.getValue(),plantAverageRating.get(stringIntegerEntry.getKey()));
        }
    }
}
// I hope I don't get something similar on my exam.