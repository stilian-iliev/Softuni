import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> scoreboard = new LinkedHashMap<>();
        String[] contestants = sc.nextLine().split(", ");
        for (String contestant : contestants) {
            scoreboard.putIfAbsent(contestant,0);
        }
        String input = sc.nextLine();
        while (!input.equals("end of race")){
            StringBuilder name = new StringBuilder();
            int score = 0;
            Pattern nameReg = Pattern.compile("[A-Za-z]");
            Pattern distanceReg = Pattern.compile("\\d{1}");
            Matcher nameMatcher = nameReg.matcher(input);
            Matcher distanceMatcher = distanceReg.matcher(input);
            while (nameMatcher.find()){
                name.append(nameMatcher.group());
                if (scoreboard.containsKey(name.toString())){
                    while (distanceMatcher.find()){
                        score += Integer.parseInt(distanceMatcher.group());
                    }
                    scoreboard.put(name.toString(), scoreboard.get(name.toString())+ score);
                }
            }
            input = sc.nextLine();
        }
        scoreboard = scoreboard.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        List<String> names = new ArrayList<>(scoreboard.keySet());
        System.out.printf("1st place: %s%n",names.get(0));
        System.out.printf("2nd place: %s%n", names.get(1));
        System.out.printf("3rd place: %s%n", names.get(2));
    }
}
