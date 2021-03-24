import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<Double>> grades = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double grade = Double.parseDouble(sc.nextLine());
            grades.putIfAbsent(name, new ArrayList<>());
            grades.get(name).add(grade);
        }
        Map<String,Double> averageGrades = new LinkedHashMap<>();
        grades.forEach((key, value) -> averageGrades.put(key, value.stream().mapToDouble(Double::doubleValue).average().getAsDouble()));

        averageGrades.entrySet().stream().filter((student) -> student.getValue()>=4.5).sorted((e1,e2)-> e2.getValue().compareTo(e1.getValue())).forEach(e -> System.out.printf("%s -> %.2f%n",e.getKey(),e.getValue()));
    }
}

