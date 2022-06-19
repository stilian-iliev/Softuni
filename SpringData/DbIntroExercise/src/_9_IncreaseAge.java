import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _9_IncreaseAge {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "toor");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        int id = Integer.parseInt(sc.nextLine());

        PreparedStatement callAgingProcedure = connection.prepareStatement("call usp_get_older(?)");
        callAgingProcedure.setInt(1,id);
        callAgingProcedure.executeUpdate();

        PreparedStatement selectMinion = connection.prepareStatement("select name, age from minions where id = ?");
        selectMinion.setInt(1, id);
        ResultSet minion = selectMinion.executeQuery();
        minion.next();
        System.out.println(minion.getString("name") + " " + minion.getInt("age"));
    }
}
