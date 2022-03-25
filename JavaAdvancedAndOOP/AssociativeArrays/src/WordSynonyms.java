import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<String>> dictionary = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            String synonym = sc.nextLine();
            dictionary.putIfAbsent(word, new ArrayList<>());
            dictionary.get(word).add(synonym);
        }
        for (Map.Entry<String, List<String>> stringListEntry : dictionary.entrySet()) {
            System.out.printf("%s - %s%n",stringListEntry.getKey(), String.join(", ", stringListEntry.getValue()));
        }
    }
}
