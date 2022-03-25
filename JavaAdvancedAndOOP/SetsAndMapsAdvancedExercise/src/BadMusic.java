import java.util.*;

public class BadMusic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, HashMap<String, Integer>> venues = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("End")) {
            int firstIndexOfNumber = 0;
            for (int i = input.indexOf("@"); i < input.length(); i++) {
                char currentSymbol = input.charAt(i);
                if(Character.isDigit(currentSymbol) && input.charAt(i - 1) == ' '){
                    firstIndexOfNumber = i;
                    break;
                }
            }
            if (valid(input)){
                String singer = input.substring(0,input.indexOf(" @"));
                String venue = input.substring(input.indexOf("@")+1,firstIndexOfNumber);
                int ticket = Integer.parseInt(input.split(" ")[input.split(" ").length-2]);
                int people = Integer.parseInt(input.split(" ")[input.split(" ").length-1]);

                venues.putIfAbsent(venue, new HashMap<>());
                venues.get(venue).putIfAbsent(singer, 0);
                venues.get(venue).put(singer,venues.get(venue).get(singer)+ticket*people);
            }
            input = sc.nextLine();
        }
        for (Map.Entry<String, HashMap<String, Integer>> entry : venues.entrySet()) {
            System.out.println(entry.getKey());
            LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
            entry.getValue().entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> sortedMap.put(x.getKey(), Math.toIntExact(x.getValue())));
            for (Map.Entry<String, Integer> stringIntegerEntry : sortedMap.entrySet()) {
                System.out.printf("#  %s -> %d%n",stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
            }
        }
    }

    private static boolean valid(String input) {
        String[] input1 = input.split(" ");

        if (!isNumeric(input1[input1.length-1]) || !isNumeric(input1[input1.length-2])){
            return false;
        }
        return input.contains(" @");
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
