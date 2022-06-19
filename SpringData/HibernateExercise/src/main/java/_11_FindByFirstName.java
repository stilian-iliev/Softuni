import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class _11_FindByFirstName {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = emf.createEntityManager();

        Scanner sc = new Scanner(System.in);

        String reg = sc.nextLine() + "%";

        List<Employee> employees = manager.createQuery("select e from Employee e where e.firstName like :reg", Employee.class)
                .setParameter("reg", reg)
                .getResultList();

        employees.forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));
    }
}
