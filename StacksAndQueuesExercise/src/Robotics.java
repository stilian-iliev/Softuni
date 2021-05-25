import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputOne = sc.nextLine().split(";");
        String[] inputTwo = sc.nextLine().split(":");
        Map<String, Integer> robots = new LinkedHashMap<>();
        Map<String, Integer> robotsWorkingTime = new LinkedHashMap<>();
        for (String s : inputOne) {
            robots.put(s.split("-")[0], Integer.parseInt(s.split("-")[1]));
            robotsWorkingTime.put(s.split("-")[0], 0);
        }
        int seconds = Integer.parseInt(inputTwo[2]) + (Integer.parseInt(inputTwo[1]) * 60) + (Integer.parseInt(inputTwo[0]) * 3600);

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = sc.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = sc.nextLine();
        }
        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            seconds++;
            boolean freeRobots = true;
            for (Map.Entry<String, Integer> entry : robotsWorkingTime.entrySet()) {
                if (entry.getValue() == 0) {
                    //naznachavame rabota
                    robotsWorkingTime.put(entry.getKey(), robots.get(entry.getKey()));
                    System.out.println(entry.getKey() + " - " + currentProduct + " " + printTime(seconds));
                    freeRobots = false;
                    break;
                }
            }
            if (freeRobots) {
                products.offer(currentProduct);
            }
            workTimeCountdown(robotsWorkingTime);
        }
    }

    private static void workTimeCountdown(Map<String, Integer> robotsWorkingTime) {
        for (Map.Entry<String, Integer> entry : robotsWorkingTime.entrySet()) {
            if (entry.getValue() != 0){
                entry.setValue(entry.getValue()-1);
            }
        }
    }

    private static String printTime(int seconds) {
        int hours = seconds / 3600 % 24;
        int minutes = seconds % 3600 / 60;
        int second = seconds % 3600 % 60;
        String time = String.format("[%02d:%02d:%02d]",hours,minutes,second);
        return time;
    }
}
