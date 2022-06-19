import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _8_IncreaseMinionAge {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "toor");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        String[] ids = sc.nextLine().split("\\s+");
//        int[] ids = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        PreparedStatement updateMinions = connection.prepareStatement("update minions set age = age + 1, name = lower(name) where id in ("+String.join(", ",ids)+")");
//        updateMinions.setArray(1, ids);
        updateMinions.executeUpdate();

        PreparedStatement selectMinions = connection.prepareStatement("select name, age from minions");
        ResultSet minions = selectMinions.executeQuery();

        while (minions.next()) {
            System.out.println(minions.getString("name")+" "+minions.getInt("age"));
        }

    }
}
