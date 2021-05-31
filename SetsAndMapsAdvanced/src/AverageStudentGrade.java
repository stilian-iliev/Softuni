import java.util.*;

public class AverageStudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        LinkedHashMap<String, List<Double>> students = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }
        for (Map.Entry<String, List<Double>> student : students.entrySet()) {
            double studentAverage = student.getValue().stream().mapToDouble(i -> i).average().getAsDouble();
            System.out.print(student.getKey() + " -> ");
            for (int i = 0; i < student.getValue().size(); i++) {
                System.out.printf("%.2f ",student.getValue().get(i) );
            }
            System.out.printf("(avg: %.2f)%n",studentAverage);
        }
    }
}
