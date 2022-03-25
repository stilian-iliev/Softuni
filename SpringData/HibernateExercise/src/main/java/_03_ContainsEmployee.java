import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class _03_ContainsEmployee {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        Scanner sc = new Scanner(System.in);

        String inputName = sc.nextLine();

        Query query = manager.createQuery("select e from Employee e where concat_ws(' ',e.firstName,e.lastName) = :name", Employee.class);
        query.setParameter("name", inputName);

        List<Employee> resultList = query.getResultList();

        if (resultList.size() == 0) System.out.println("No");
        else System.out.println("Yes");
    }
}
