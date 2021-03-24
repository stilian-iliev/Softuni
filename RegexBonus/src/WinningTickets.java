import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTickets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<first>[@#$\\^]+)[^@#$\\^]*(?<second>[@#$\\^]+)");
        String[] input = sc.nextLine().split("\\s*,\\s*");
        for (String ticket : input) {
            if (ticket.length() == 20) {
                boolean valid = false;
                Matcher matcher = pattern.matcher(ticket);
                int dollars = 0;
                char symbol = 'a';
                if (matcher.find()) {
                    int first = matcher.group("first").length();
                    int second = matcher.group("second").length();
                    int smaller = Integer.min(first, second);
                    dollars = smaller;
                    symbol = matcher.group("first").charAt(0);
                    if(smaller>=6) valid = true;
                    if (first == 19){
                        valid = true;
                        dollars = 10;
                    }

                }
                if (valid && dollars == 10) {
                    System.out.printf("ticket \"%s\" - %d%c Jackpot!%n", ticket, dollars, symbol);
                } else if (valid) {
                    System.out.printf("ticket \"%s\" - %d%c%n", ticket, dollars, symbol);
                } else {
                    System.out.printf("ticket \"%s\" - no match%n", ticket);
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }
}
