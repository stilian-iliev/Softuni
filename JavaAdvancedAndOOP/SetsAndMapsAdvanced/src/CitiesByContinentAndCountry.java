import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Map<String, List<String>>> continents = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            String continent = input[0];
            String country = input[1];
            String city = input[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            continents.get(continent).putIfAbsent(country,new ArrayList<>());
            continents.get(continent).get(country).add(city);
        }

        for (Map.Entry<String, Map<String, List<String>>> continent : continents.entrySet()) {
            System.out.printf("%s:%n",continent.getKey());
            for (Map.Entry<String, List<String>> country : continent.getValue().entrySet()) {
                System.out.printf("  %s -> %s%n",country.getKey(), String.join(", ", country.getValue()));

            }
        }
    }
}
