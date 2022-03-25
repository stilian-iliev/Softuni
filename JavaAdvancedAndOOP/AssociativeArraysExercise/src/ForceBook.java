import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<String, List<String>> book = new LinkedHashMap<>();
        while (input.equals("Lumpawaroo")){
            if(input.split(" | ").length==2){
                String side = input.split(" | ")[0];
                String user = input.split(" | ")[1];
                if(!book.containsValue(user)){
                    book.putIfAbsent(side,new ArrayList<>());
                    book.get(side).add(user);
                }
            } else if (input.split(" -> ").length==2){
                String side = input.split(" -> ")[1];
                String user = input.split(" -> ")[0];
                if(book.containsValue(user)){
                    book.remove(user);
                }
            }

            input = sc.nextLine();
        }
        System.out.println("");
    }
}
