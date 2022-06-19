import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class courses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> initialSchedule = Arrays.stream(sc.nextLine().split(", ")).collect(Collectors.toList());
        String[] command = sc.nextLine().split(":");
        while (!command[0].equals("course start")) {
            switch (command[0]) {
                case "Add":
                    if (!initialSchedule.contains(command[1])) {
                        initialSchedule.add(command[1]);
                    }
                    break;
                case "Insert":
                    if (!initialSchedule.contains(command[1])) {
                        initialSchedule.add(Integer.parseInt(command[2]), command[1]);
                    }
                    break;
                case "Remove":
                    if (initialSchedule.contains(command[1])) {
                        initialSchedule.remove(command[1]);
                        if(initialSchedule.contains(command[1]+"-Exercise")){
                            initialSchedule.remove(command[1]+"-Exercise");
                        }
                    }

                    break;
                case "Swap":
                    swapLessons(initialSchedule, command[1], command[2]);
                    break;
                case "Exercise":
                    addExercise(initialSchedule, command[1]);
                    break;
            }
            command = sc.nextLine().split(":");
        }
        for (int i = 1; i <= initialSchedule.size(); i++) {
            System.out.printf("%d.%s%n", i, initialSchedule.get(i - 1));
        }
    }

    private static void addExercise(List<String> initialSchedule, String lesson) {
        for (int i = 0; i < initialSchedule.size(); i++) {
            if (initialSchedule.get(i).equals(lesson)) {
                initialSchedule.add(i + 1, lesson + "-Exercise");
                return;
            }
        }
        initialSchedule.add(lesson);
        initialSchedule.add(lesson + "-Exercise");
    }

    private static void swapLessons(List<String> initialSchedule, String first, String second) {
        int firstIndex = initialSchedule.indexOf(first);
        int secondIndex = initialSchedule.indexOf(second);
        //move first to second index
        initialSchedule.set(secondIndex,first);
        if(firstIndex+1<initialSchedule.size() &&initialSchedule.get(firstIndex+1).equals(first+"-Exercise")){
            initialSchedule.add(secondIndex+1,first+"-Exercise");
            initialSchedule.remove(secondIndex+1);
            secondIndex = initialSchedule.indexOf(second);
        }


        //move second to firstIndex
        initialSchedule.set(firstIndex,second);
        if(secondIndex+1<initialSchedule.size() &&initialSchedule.get(secondIndex+1).equals(second+"-Exercise")){
            initialSchedule.remove(secondIndex+1);
            initialSchedule.add(firstIndex+1,second+"-Exercise");
        }
    }
}
