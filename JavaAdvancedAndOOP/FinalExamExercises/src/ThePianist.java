import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThePianist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String,String > pieceComposer = new LinkedHashMap<>();
        Map<String,String > pieceKey = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\|");
            String piece = input[0];
            String composer = input[1];
            String key = input[2];
            addNewPiece(piece,composer,key,pieceKey,pieceComposer);
        }
        String[] command = sc.nextLine().split("\\|");
        while (!command[0].equals("Stop")){
            String piece = command[1];
            switch (command[0]){
                case "Add":
                    if (pieceComposer.containsKey(piece)){
                        System.out.printf("%s is already in the collection!%n",piece);
                    } else {
                        String composer = command[2];
                        String key = command[3];
                        addNewPiece(piece,composer,key,pieceKey,pieceComposer);
                        System.out.printf("%s by %s in %s added to the collection!%n",piece,composer,key);
                    }
                    break;
                case "Remove":
                    if (pieceComposer.containsKey(piece)){
                        pieceComposer.remove(piece);
                        pieceKey.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }
                    break;
                case "ChangeKey":
                    if (pieceComposer.containsKey(piece)){
                        pieceKey.put(piece,command[2]);
                        System.out.printf("Changed the key of %s to %s!%n",piece,command[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }
                    break;
            }
            command = sc.nextLine().split("\\|");
        }
        pieceComposer = pieceComposer.entrySet()
                .stream()
                .sorted((Map.Entry.<String, String>comparingByKey()).thenComparing(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        for (Map.Entry<String, String> piece : pieceComposer.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n",piece.getKey(),piece.getValue(),pieceKey.get(piece.getKey()));
        }
    }

    private static void addNewPiece(String piece, String composer, String key, Map<String, String> pieceKey, Map<String, String> pieceComposer) {
        pieceComposer.put(piece,composer);
        pieceKey.put(piece,key);
    }
}
