import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _08_EmployeesWithProjects {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = emf.createEntityManager();

        Scanner sc = new Scanner(System.in);

        int employeeId = Integer.parseInt(sc.nextLine());

        Employee employee = manager.find(Employee.class, employeeId);

        System.out.printf("%s %s - %s%n%s%n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle(),
                employee.getProjects().stream()
                        .map(Project::getName)
                        .sorted()
                        .collect(Collectors.joining("\n")));
    }
}
