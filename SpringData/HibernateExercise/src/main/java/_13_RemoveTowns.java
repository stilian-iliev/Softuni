import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class _13_RemoveTowns {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = emf.createEntityManager();

        manager.getTransaction().begin();

        Scanner sc = new Scanner(System.in);
        String townToDelete = sc.nextLine();


        int deletedAddresses = manager.createQuery("delete from Address where town.name = :town")
                .setParameter("town", townToDelete)
                .executeUpdate();
        manager.createQuery("delete from Town where name = :town")
                .setParameter("town", townToDelete);

        System.out.printf("%d %s in %s deleted%n", deletedAddresses, deletedAddresses==1 ? "address" : "addresses", townToDelete);

        manager.getTransaction().commit();
    }
}
