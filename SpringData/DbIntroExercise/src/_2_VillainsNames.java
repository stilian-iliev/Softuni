import java.sql.*;
import java.util.Properties;

public class _2_VillainsNames {
    public static void main(String[] args) throws SQLException {
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "toor");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        PreparedStatement statement = connection.prepareStatement("select villains.name as villain_name, count(distinct minion_id) as minions_count from villains\n" +
                "join minions_villains on villains.id = minions_villains.villain_id\n" +
                "group by villain_id\n" +
                "having minions_count > 15\n" +
                "order by minions_count desc;");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.printf("%s %d%n", resultSet.getString("villain_name"), resultSet.getInt("minions_count"));
        }

        connection.close();
    }
}
