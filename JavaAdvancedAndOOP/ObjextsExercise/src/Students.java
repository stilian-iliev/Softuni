import java.util.*;

public class Students {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Student> students = new ArrayList<>();
        Student student;
        for (int i = 1; i <= n; i++) {
            String[] input = sc.nextLine().split(" ");
            student = new Student(input[0],input[1], Double.parseDouble(input[2]));
            students.add(student);
            if (i==n){
                students.sort(Comparator.comparing(Student::getGrade));
                for (int j = students.size()-1; j >= 0; j--) {
                    System.out.printf("%s%.2f%n",students.get(j).toString(),students.get(j).getGrade());
                }
            }
        }
    }
}
class Student{
    private String firstName;
    private String secondName;
    double grade;

    public double getGrade() {
        return grade;
    }

    public Student(String firstName, String secondName, double grade){
        this.firstName = firstName;
        this.secondName = secondName;
        this.grade = grade;
    }
    @Override
    public String toString(){
        return firstName + " " + secondName + ": ";
    }
}
