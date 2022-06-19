import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _6_RemoveVillain {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "toor");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        int villainId = Integer.parseInt(sc.nextLine());

        try {
            connection.setAutoCommit(false);

            PreparedStatement deleteMappingEntries = connection.prepareStatement("delete from minions_villains where villain_id = ?");
            deleteMappingEntries.setInt(1, villainId);
            int freedMinions = deleteMappingEntries.executeUpdate();

            PreparedStatement getVillainName = connection.prepareStatement("select name from villains where id = ?");
            getVillainName.setInt(1, villainId);
            ResultSet villainSet = getVillainName.executeQuery();
            villainSet.next();
            String villainName = villainSet.getString("name");

            PreparedStatement deleteVillain = connection.prepareStatement("delete from villains where id = ?");
            deleteVillain.setInt(1, villainId);
            deleteVillain.executeUpdate();

            System.out.printf("%s was deleted%n%d minions released%n", villainName, freedMinions);

            connection.commit();
        } catch (SQLException e) {
            System.out.println("No such villain was found");
            connection.rollback();
        }
    }
}
