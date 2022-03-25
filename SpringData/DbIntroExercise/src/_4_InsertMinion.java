import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class _4_InsertMinion {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "toor");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minions_db", props);

        String[] minionInfo = sc.nextLine().split("\\s+");
        String minionName = minionInfo[1];
        int minionAge = Integer.parseInt(minionInfo[2]);
        String minionTown = minionInfo[3];
        String villainName = sc.nextLine().split("\\s+")[1];

        PreparedStatement selectTown = connection.prepareStatement("select id from towns where name = ?");
        selectTown.setString(1,minionTown);

        ResultSet townSet = selectTown.executeQuery();
        if (!townSet.next()){
            PreparedStatement insertTown = connection.prepareStatement("insert into towns(name) values(?)");
            insertTown.setString(1,minionTown);

            insertTown.executeUpdate();
            System.out.println("Town "+minionTown+" was added to the database.");
        }

        townSet = selectTown.executeQuery();
        townSet.next();
        int townId = townSet.getInt("id");


        PreparedStatement selectVillain = connection.prepareStatement("select id from villains where name = ?");
        selectVillain.setString(1, villainName);

        ResultSet villainSet = selectVillain.executeQuery();
        if (!villainSet.next()) {
            PreparedStatement insertVillain = connection.prepareStatement("insert into villains(name, evilness_factor) values(?, ?)");
            insertVillain.setString(1, villainName);
            insertVillain.setString(2, "evil");

            insertVillain.executeUpdate();
            System.out.println("Villain "+villainName+" was added to the database.");
        }

        villainSet = selectVillain.executeQuery();
        villainSet.next();
        int villainId = villainSet.getInt("id");

        PreparedStatement insertMinion = connection.prepareStatement("insert into minions(name, age, town_id) values(?, ?, ?)");
        insertMinion.setString(1,minionName);
        insertMinion.setInt(2,minionAge);
        insertMinion.setInt(3,townId);

        insertMinion.executeUpdate();

        PreparedStatement selectMinion = connection.prepareStatement("select id from minions where name = ? and age = ? and town_id = ?");
        selectMinion.setString(1, minionName);
        selectMinion.setInt(2, minionAge);
        selectMinion.setInt(3, townId);

        ResultSet minionSet = selectMinion.executeQuery();
        minionSet.next();
        int minionId = minionSet.getInt("id");

        PreparedStatement insertMap = connection.prepareStatement("insert into minions_villains(minion_id, villain_id) values(?, ?)");
        insertMap.setInt(1, minionId);
        insertMap.setInt(2, villainId);
        insertMap.executeUpdate();

        System.out.println("Successfully added "+minionName+" to be minion of " + villainName +".");
    }
}
