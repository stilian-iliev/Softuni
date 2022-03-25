import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class _12_EmployeesMaximumSalaries {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = emf.createEntityManager();

        List<String> deps = manager.createQuery("select e.department.name from Employee e group by e.department having max(e.salary) not between 30000 and 70000", String.class)
                .getResultList();

        List<BigDecimal> salaries = manager.createQuery("select e.salary from Employee e group by e.department having max(e.salary) not between 30000 and 70000", BigDecimal.class)
                .getResultList();

        for (int i = 0; i < deps.size(); i++) {
            System.out.printf("%s %.2f%n", deps.get(i), salaries.get(i));
        }
    }
}
