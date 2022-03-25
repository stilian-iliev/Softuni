package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnector {

    private static Connection connection;
    private static final String host = "jdbc:mysql://localhost:3306/";

    public static void createConnection(String user, String password, String dbName) throws SQLException {
        Properties props = new Properties();
        props.put("user", user);
        props.put("password", password);

        connection = DriverManager.getConnection(host+dbName, props);
    }

    public static Connection getConnection() {
        return connection;
    }
}
