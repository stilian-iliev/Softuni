package Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<Student>();
        String[] input = sc.nextLine().split(" ");
        Student student = new Student(input[0], input[1], Integer.parseInt(input[2]), input[3]);
        while (!input[0].equals("end")) {
            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            String homeTown = input[3];
            for (Student student1 : students) {
                if (student1.getFirstName().equals(firstName) && student1.getLastName().equals(lastName)) {
                    student1.setAge(age);
                    student1.setHomeTown(homeTown);
                } else {
                    student = new Student(input[0], input[1], Integer.parseInt(input[2]), input[3]);
                    students.add(student);
                    break;
                }
            }
            students.add(student);
            input = sc.nextLine().split(" ");
        }
        String town = sc.nextLine();
        for (Student studentt : students) {
            if (town.equals(student.getHomeTown())) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
