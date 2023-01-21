package OnTimeForExam;

import java.util.Scanner;

public class OnTimeForExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingExamHour = Integer.parseInt(scanner.nextLine());
        int startingExamMin = Integer.parseInt(scanner.nextLine());

        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMin = Integer.parseInt(scanner.nextLine());

        int startingTimeInMins = startingExamHour * 60 + startingExamMin;
        int arrivalTimeInMins = arrivalHour * 60 + arrivalMin;

        int difference = arrivalTimeInMins - startingTimeInMins;

        if (difference < -30) {
            System.out.println("Early");
        } else if (difference > 0){
            System.out.println("Late");
        } else {
            System.out.println("On Time");
        }

        int hours = difference / 60;
        int minutes = Math.abs(difference % 60);

        if (difference > 0) {
            if (hours > 0) {
                System.out.printf("%d:%02d hours after the start%n", hours, minutes);
            } else {
                System.out.printf("%d minutes after the start%n", minutes);
            }
        } else if (difference < 0) {
            if (hours > 0) {
                System.out.printf("%d:%02d hours before the start%n", hours, minutes);
            } else {
                System.out.printf("%d minutes before the start%n", minutes);
            }
        }
    }
}
