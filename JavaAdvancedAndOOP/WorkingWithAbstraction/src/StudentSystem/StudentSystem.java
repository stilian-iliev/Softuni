package StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentMap;

    public StudentSystem() {
        this.studentMap = new HashMap<>();
    }

    public void parseCommand(String[] args) {
        String command = args[0];
        switch (command) {
            case "Create":
                String name = args[1];
                int age = Integer.parseInt(args[2]);
                double grade = Double.parseDouble(args[3]);
                create(name,age,grade);
                break;
            case "Show":
                name = args[1];
                if (studentMap.containsKey(name)) print(name);
                break;
        }
    }

    private void create(String name, int age, double grade) {
        studentMap.putIfAbsent(name, new Student(name,age,grade));
    }

    private void print(String name) {
        Student student = studentMap.get(name);
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s is %s years old. ", student.getName(), student.getAge()));

        if (student.getGrade() >= 5.00) {
            output.append("Excellent student.");
        } else if (student.getGrade() >= 3.50) {
            output.append("Average student.");
        } else {
            output.append("Very nice person.");
        }

        System.out.println(output.toString());
    }
}
