import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class _10_IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();

        String[] departments = new String[]{"Engineering", "Tool Design", "Marketing", "Information Services"};
//        Integer[] departments = new Integer[]{1, 2, 3};

        manager.createQuery("update Employee set salary = salary * 1.12 where department.name in :departments")
                .setParameter("departments", Arrays.asList(departments)).executeUpdate();

        List<Employee> employees = manager.createQuery("select e from Employee e where e.department.name in :departments", Employee.class)
                .setParameter("departments", Arrays.asList(departments)).getResultList();

        employees.forEach(e -> System.out.printf("%s %s ($%.2f)%n", e.getFirstName(), e.getLastName(), e.getSalary()));

        manager.getTransaction().commit();
    }
}
