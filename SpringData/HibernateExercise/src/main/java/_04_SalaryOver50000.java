import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class _04_SalaryOver50000 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = emf.createEntityManager();

        List<String> highSalaryEmployees = manager.createQuery("select e.firstName from Employee e where e.salary > 50000", String.class).getResultList();
        highSalaryEmployees.forEach(System.out::println);
    }
}
