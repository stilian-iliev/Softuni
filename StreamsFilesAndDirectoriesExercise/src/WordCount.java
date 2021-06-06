import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class WordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
        String[] words = reader.readLine().split("\\s+");
        HashMap<String, LinkedHashMap<String, Integer>> wordsList = new HashMap<>();
        Arrays.stream(words).forEach(a -> {
            wordsList.putIfAbsent(a.toLowerCase(Locale.ROOT), new LinkedHashMap<>());
            wordsList.get(a.toLowerCase(Locale.ROOT)).put(a, 0);
        });
        reader = new BufferedReader(new FileReader("C:\\Users\\sprink\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));
        String in = reader.readLine();
        while (in != null) {
            for (String s : in.split("\\s+")) {
                if (wordsList.containsKey(s.toLowerCase(Locale.ROOT))) {
                    wordsList.get(s.toLowerCase(Locale.ROOT)).forEach((s1, integer) -> wordsList.get(s.toLowerCase(Locale.ROOT)).put(s1, integer + 1));
                }
            }
            in = reader.readLine();
        }
        LinkedHashMap<String,Integer> sortedMap = sortedMap(wordsList);
        sortedMap.forEach((key, value) -> System.out.printf("%s - %d%n", key, value));
    }

    private static LinkedHashMap<String,  Integer> sortedMap(HashMap<String, LinkedHashMap<String, Integer>> wordsList) {
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

        wordsList.forEach((key, value) -> value.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue())));
        return sortedMap;
    }
}
