import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _3_MinionsNames {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "toor");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        PreparedStatement statement = connection.prepareStatement("select name from villains where id = ?");
        int id = Integer.parseInt(sc.nextLine());
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String villainName = resultSet.getString("name");
            statement = connection.prepareStatement("SELECT minions.name, age from minions\n" +
                    "join minions_villains on minions.id = minions_villains.minion_id\n" +
                    "join villains on villains.id = minions_villains.villain_id\n" +
                    "where villains.name = ?;");

            statement.setString(1, villainName);

            ResultSet minions = statement.executeQuery();
            int counter = 1;
            System.out.printf("Villain: %s%n", villainName);
            while(minions.next()) {
                System.out.printf("%d. %s %d%n", counter, minions.getString("minions.name"), minions.getInt("age"));
                counter++;
            }
        } else {
            System.out.println("No villain with ID "+ id +" exists in the database.");
        }
        connection.close();
    }
}
