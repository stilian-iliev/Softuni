import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, Integer> materials = new TreeMap<>();
        materials.put("shards", 0);
        materials.put("motes", 0);
        materials.put("fragments", 0);
        TreeMap<String, Integer> junk = new TreeMap<>();

        String sword = "";

        boolean bought = false;
        while (!bought) {
            String[] input = sc.nextLine().split("\\s+");
            for (int i = 0; i < input.length; i += 2) {
                String material = input[i + 1].toLowerCase(Locale.ROOT);
                int quantity = Integer.parseInt(input[i]);
                switch (material) {
                    case "shards":
                    case "fragments":
                    case "motes":
                        materials.put(material, materials.get(material) + quantity);
                        if (materials.get(material) >= 250) {
                            bought = true;
                            materials.put(material, materials.get(material) - 250);
                            switch (material) {
                                case "shards":
                                    sword = "Shadowmourne";
                                    break;
                                case "fragments":
                                    sword = "Valanyr";
                                    break;
                                case "motes":
                                    sword = "Dragonwrath";
                                    break;
                            }
                        }
                        break;
                    default:
                        junk.putIfAbsent(material, 0);
                        junk.put(material, junk.get(material) + quantity);
                        break;
                }
                if (bought) break;
            }
        }
        System.out.println(sword + " obtained!");
        LinkedHashMap<String, Integer> materialsSorted = new LinkedHashMap<>();
        materials.entrySet().

                stream()
                .

                        sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .

                        forEachOrdered(x -> materialsSorted.put(x.getKey(), x.getValue()));
        for (
                Map.Entry<String, Integer> entry : materialsSorted.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
        for (
                Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}