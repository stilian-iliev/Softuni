import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "toor");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", props);

        PreparedStatement statement = connection.prepareStatement("select user_name, first_name, last_name, count(users_games.game_id) as game_count from users " +
                "join users_games on users_games.user_id = users.id " +
                "where user_name = ? " +
                "group by user_id");

        String username = sc.nextLine();
        statement.setString(1, username);

        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            System.out.printf("User: %s%n%s %s has played %d games%n",
                    rs.getString("user_name"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getInt("game_count"));
        } else {
            System.out.println("No such user exists");
        }

        connection.close();
    }
}
