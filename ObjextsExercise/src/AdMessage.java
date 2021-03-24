import java.util.Random;
import java.util.Scanner;

public class AdMessage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        AdverisementMessage message = new AdverisementMessage();
        message.createMessage(n);
    }
}

class AdverisementMessage {
    private String[] phrase = {"Excellent product. ", "Such a great product. ", "I always use that product. ", "Best product of its category. ", "Exceptional product. ", "I can’t live without this product. "};
    private String[] events = {"Now I feel good. ", "I have succeeded with this product. ", "Makes miracles. I am happy of the results! ", "I cannot believe but now I feel awesome. ", "Try it yourself, I am very satisfied. ", "I feel great! "};
    private String[] authors = {"Diana ", "Petya ", "Stella ", "Elena ", "Katya ", "Iva ", "Annie ", "Eva "};
    private String[] city = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

    Random rnd = new Random();

    void createMessage(int n) {
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            StringBuilder output = new StringBuilder();
            int number = rnd.nextInt(phrase.length);
            output.append(phrase[number]);
            number = rnd.nextInt(events.length);
            output.append(events[number]);
            number = rnd.nextInt(authors.length);
            output.append(authors[number]);
            output.append("- ");
            number = rnd.nextInt(city.length);
            output.append(city[number]);
            System.out.println(output.toString());
        }
    }
}
