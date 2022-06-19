import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class _02_ChangeCasing {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();

        List<Town> towns = manager.createQuery("select t from Town t where char_length(name) <= 5", Town.class).getResultList();

        towns.forEach(t -> {
            t.setName(t.getName().toUpperCase());
            manager.persist(t);
        });

        manager.getTransaction().commit();
    }
}
