package tech.anteeone.ecobits.repositories;

import tech.anteeone.ecobits.models.Quest;
import tech.anteeone.ecobits.services.JDBCConnectionService;

import java.sql.SQLException;
import java.util.ArrayList;

public class QuestRepository extends Repository implements CrudRepository<Quest> {

    public ArrayList getAll(){
        ArrayList<Quest> list = new ArrayList();
        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("SELECT title,description,bitsreward from quests");
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

    @Override
    public boolean create(Quest entity) {
        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("INSERT INTO quests values (?,?,?)");
            ps.setString(1,entity.getTitle());
            ps.setString(2,entity.getDescription());
            ps.setInt(3,entity.getBitsReward());
            rs = ps.executeQuery();

        }
        catch (SQLException e) {
            //TODO
        } catch (ClassNotFoundException e) {
            //TODO
        }
        return false;
    }

    @Override
    public boolean delete(Quest entity) {
        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("");
            rs = ps.executeQuery();
            while (rs.next()){
            }
        }
        catch (SQLException e) {
            //TODO
        } catch (ClassNotFoundException e) {
            //TODO
        }
        return false;
    }

    @Override
    public Quest getByParameter(Object object) {
        return null;
    }

    public static QuestRepository getInstance(){
        return new QuestRepository();
    }



}
