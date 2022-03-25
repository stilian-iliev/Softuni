import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Pirates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\|\\|");
        Map<String, Integer> cityGold = new LinkedHashMap<>();
        Map<String, Integer> cityPopulation = new LinkedHashMap<>();
        while (!input[0].equals("Sail")) {
            String name = input[0];
            int population = Integer.parseInt(input[1]);
            int gold = Integer.parseInt(input[2]);
            cityGold.putIfAbsent(name, 0);
            cityPopulation.putIfAbsent(name, 0);
            cityGold.put(name, cityGold.get(name) + gold);
            cityPopulation.put(name, cityPopulation.get(name) + population);
            input = sc.nextLine().split("\\|\\|");
        }
        String[] command = sc.nextLine().split("=>");
        while (!command[0].equals("End")) {
            switch (command[0]) {
                case "Plunder":
                    String town = command[1];
                    int killedPeople = Integer.parseInt(command[2]);
                    int stolenGold = Integer.parseInt(command[3]);
                    cityPopulation.put(town, cityPopulation.get(town) - killedPeople);
                    cityGold.put(town, cityGold.get(town) - stolenGold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, stolenGold, killedPeople);
                    if (cityGold.get(town) == 0 || cityPopulation.get(town) == 0) {
                        System.out.printf("%s has been wiped off the map!%n", town);
                        cityGold.remove(town);
                        cityPopulation.remove(town);
                    }
                    break;
                case "Prosper":
                    town = command[1];
                    int gold = Integer.parseInt(command[2]);
                    if (gold >= 0) {
                        cityGold.put(town, cityGold.get(town) + gold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, cityGold.get(town));
                    } else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }
            command = sc.nextLine().split("=>");
        }
        cityGold = cityGold.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.<String, Integer>comparingByKey()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        if (!(cityGold.size() == 0)) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",cityGold.size());
            for (Map.Entry<String, Integer> city : cityGold.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",city.getKey(),cityPopulation.get(city.getKey()),city.getValue());
            }
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
