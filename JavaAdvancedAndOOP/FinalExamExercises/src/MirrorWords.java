import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Pattern pattern = Pattern.compile("([#@])(?<word>[A-Za-z]{3,})\\1\\1(?<word2>[A-Za-z]{3,})\\1");
        Matcher first = pattern.matcher(text);
        List<String> matches = new ArrayList<>();
        while (first.find()){
            String whole = first.group("word").concat(first.group("word2"));
            matches.add(whole);
        }
        List<String> pairs = new ArrayList<>();
        for (int i = 0; i < matches.size(); i++) {
            String one = matches.get(i);
            String two = new StringBuilder(one).reverse().toString();
            if (one.equals(two)){
                String onee = one.substring(0,one.length()/2);
                String twoo = one.substring(one.length()/2);
                String pair = onee + " <=> "+ twoo;
                pairs.add(pair);
            }
        }
        if (matches.size()==0){
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n",matches.size());
        } if (pairs.size()==0){
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ",pairs));
        }

    }
}
