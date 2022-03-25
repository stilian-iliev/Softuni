import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _06_NewAddress {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();

        Address address = new Address();
        address.setText("Vitoshka 15");
        manager.persist(address);

        Scanner sc = new Scanner(System.in);
        String lastName = sc.nextLine();

        manager.createQuery("update Employee e set e.address = :address where e.lastName = :name")
                .setParameter("address", address)
                .setParameter("name", lastName)
                .executeUpdate();

        manager.getTransaction().commit();
    }
}
