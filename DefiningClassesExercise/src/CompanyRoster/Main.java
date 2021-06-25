package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, List<Employee>> employees = new HashMap<>();

        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String[] input = sc.nextLine().split("\\s+");
            employees.putIfAbsent(input[3], new ArrayList<>());
            switch (input.length) {
                case 4:
                    employees.get(input[3]).add(new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3]));
                    break;
                case 5:
                    if (Character.isAlphabetic(input[4].charAt(0))) {
                        employees.get(input[3]).add(new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], input[4]));
                    } else {
                        employees.get(input[3]).add(new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], Integer.parseInt(input[4])));
                    }
                    break;
                case 6:
                    employees.get(input[3]).add(new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], input[4], Integer.parseInt(input[5])));
                    break;
            }
        }
        String department = findBest(employees);
        System.out.printf("Highest Average Salary: %s%n",department);

        employees.get(department)
                .stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(e-> System.out.println(e.toString()));
    }

    public static String findBest(Map<String, List<Employee>> employees) {
        String mostProfitable = "";
        double profit = 0;
        for (Map.Entry<String, List<Employee>> entry : employees.entrySet()) {
            String dep = entry.getKey();
            double sum = 0;
            int count = 0;
            for (Employee s : entry.getValue()) {
                count++;
                sum += s.getSalary();
            }
            double avg = sum / count;
            if (avg > profit) {
                profit = avg;
                mostProfitable = dep;
            }
        }
        return mostProfitable;
    }
}
