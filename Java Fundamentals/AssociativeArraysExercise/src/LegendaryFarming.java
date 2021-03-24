import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> materials = new LinkedHashMap<>();

        boolean enough = false;
        String bought = "";

        while (!enough){
           String[] input = sc.nextLine().split(" ");
            for (int i = 1; i < input.length; i+=2) {
                materials.putIfAbsent(input[i].toLowerCase(Locale.ROOT),0);
                materials.put(input[i].toLowerCase(Locale.ROOT), materials.get(input[i].toLowerCase(Locale.ROOT))+Integer.parseInt(input[i-1]));
            }
            bought = checkIfEnough(materials);
            switch (bought){
                case "Shadowmourne":
                case "Valanyr":
                case "Dragonwrath":
                    enough =true;
                    break;
            }
        }
        System.out.println(bought + " obtained!");
        for (Map.Entry<String, Integer> stringIntegerEntry : materials.entrySet()) {
            System.out.printf("%s: %d%n",stringIntegerEntry.getKey(),stringIntegerEntry.getValue());
        }
    }

    private static String checkIfEnough(Map<String, Integer> materials) {
        if (materials.containsKey("shards") &&materials.get("shards")>=250){
            materials.put("shards", materials.get("shards")-250);
            return "Shadowmourne";
        } else if(materials.containsKey("fragments") &&materials.get("fragments")>=250){
            materials.put("fragments", materials.get("fragments")-250);
            return "Valanyr";
        } else if (materials.containsKey("motes") &&materials.get("motes")>=250){
            materials.put("motes", materials.get("motes")-250);
            return "Dragonwrath";
        } else return "";
    }
}
