import java.util.Scanner;

public class CharMultiplier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String firstName = input[0];
        String secondName = input[1];
        int sum = findSum(firstName, secondName);
        System.out.println(sum);
    }

    private static int findSum(String firstName, String secondName) {
        int sum = 0;
        String bigger = "";
        int biggest = 0;
        int smallest = 0;
        if (firstName.length() > secondName.length()) {
            biggest = firstName.length();
            bigger = firstName;
            smallest = secondName.length();
        } else {
            biggest = secondName.length();
            bigger = secondName;
            smallest = firstName.length();
        }
        for (int i = 0; i < smallest; i++) {
            sum+=firstName.charAt(i)*secondName.charAt(i);
        }
        if(biggest-smallest>0){
            for (int i = smallest; i < biggest; i++) {
                sum+= bigger.charAt(i);
            }
        }
        return sum;
    }
}
