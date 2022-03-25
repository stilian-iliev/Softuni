import entities.User;
import orm.EntityManager;
import orm.MyConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException {
        MyConnector.createConnection("root", "toor", "custom-orm");
        Connection connection = MyConnector.getConnection();

        EntityManager<User> manager = new EntityManager(connection);

        User user = new User("pesho", 25);
        manager.persist(user);
    }
}
