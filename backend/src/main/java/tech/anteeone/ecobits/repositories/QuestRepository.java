package tech.anteeone.ecobits.repositories;

import tech.anteeone.ecobits.models.Quest;
import tech.anteeone.ecobits.services.JDBCConnectionService;

import java.sql.SQLException;
import java.util.ArrayList;

public class QuestRepository extends Repository {

    public ArrayList getQuests(){
        ArrayList<Quest> list = new ArrayList();
        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("SELECT * from quests");
            rs = ps.executeQuery();
            while (rs.next()){
                String titleSQL = rs.getString(1);
                String descriptionSQL = rs.getString(2);
                Integer bitsRewardSQL = rs.getInt(3);
                list.add(new Quest(titleSQL,descriptionSQL,bitsRewardSQL));
            }
        }
        catch (SQLException e) {
            //TODO
        } catch (ClassNotFoundException e) {
            //TODO
        }
        return list;
    }

    public static QuestRepository getInstance(){
        return new QuestRepository();
    }



}
