import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class _5_ChangeTownNames {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "toor");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        String country = sc.nextLine();

        PreparedStatement changeNames = connection.prepareStatement("update towns set name = upper(name) where country = ?");
        changeNames.setString(1, country);

        int changed = changeNames.executeUpdate();
        if (changed > 0) {
            System.out.println(changed + " town names were affected.");
            PreparedStatement selectTowns = connection.prepareStatement("select name from towns where country = ?");
            selectTowns.setString(1, country);
            ResultSet townsSet = selectTowns.executeQuery();
            List<String> towns = new ArrayList<>();
            while (townsSet.next()) {
                towns.add(townsSet.getString("name"));
            }
            System.out.printf("[%s]%n", String.join(", ", towns));

        } else {
            System.out.println("No town names were affected");
        }
    }
}
