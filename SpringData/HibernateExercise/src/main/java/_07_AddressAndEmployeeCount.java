import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class _07_AddressAndEmployeeCount {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = emf.createEntityManager();

        manager.getTransaction().begin();

        List<Address> addresses = manager.createQuery("select a from Address a order by employees.size desc", Address.class).setMaxResults(10).getResultList();

        addresses.forEach(a -> System.out.printf("%s, %s - %d employees%n", a.getText(), a.getTown() == null ? "" : a.getTown().getName(), a.getEmployees().size()));

    }
}
