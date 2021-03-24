import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Ranking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] contestInput = sc.nextLine().split(":");
        Map<String, String> contests = new LinkedHashMap<>();
        while (!contestInput[0].equals("end of contests")) {
            String contest = contestInput[0];
            String password = contestInput[1];
            contests.put(contest, password);
            contestInput = sc.nextLine().split(":");
        }
        String[] submissionsInput = sc.nextLine().split("=>");
        Map<String, Map<String, Integer>> submissions = new LinkedHashMap<>();
        while (!submissionsInput[0].equals("end of submissions")) {
            String contest = submissionsInput[0];
            String password = submissionsInput[1];
            String name = submissionsInput[2];
            int points = Integer.parseInt(submissionsInput[2]);
            if (contests.containsKey(contest) && contests.get(contest).equals(password)) {
                Map<String,Integer> contestPoints = new LinkedHashMap<>();
                contestPoints.putIfAbsent(contest,0);
                if(contestPoints.get(contest)<points){
                    contestPoints.put(contest,points);
                }
                submissions.put(name, contestPoints);
            }
            submissionsInput = sc.nextLine().split("=>");
        }
    }
}
