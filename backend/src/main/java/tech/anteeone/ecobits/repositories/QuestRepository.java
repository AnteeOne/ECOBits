package tech.anteeone.ecobits.repositories;

import tech.anteeone.ecobits.models.Quest;
import tech.anteeone.ecobits.services.JDBCConnectionService;

import java.sql.SQLException;
import java.util.ArrayList;

public class QuestRepository extends Repository implements CrudRepository<Quest> {

    private static QuestRepository repository = null;

    public ArrayList getAll(){
        ArrayList<Quest> list = new ArrayList();
        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("SELECT id,title,description,bitsreward from quests");
            rs = ps.executeQuery();
            while (rs.next()){
                Integer idSQL = rs.getInt(1);
                String titleSQL = rs.getString(2);
                String descriptionSQL = rs.getString(3);
                Integer bitsRewardSQL = rs.getInt(4);
                list.add(new Quest(idSQL,titleSQL,descriptionSQL,bitsRewardSQL));
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
            ps = con.prepareStatement("INSERT INTO quests (title, description, bitsreward) values (?,?,?)");
            ps.setString(1,entity.getTitle());
            ps.setString(2,entity.getDescription());
            ps.setInt(3,entity.getBitsReward());
            rs = ps.executeQuery();
            return true;

        }
        catch (SQLException e) {
            //TODO
        } catch (ClassNotFoundException e) {
            //TODO
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("DELETE FROM quests WHERE id = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            return true;

        }
        catch (SQLException e) {
            //TODO
        } catch (ClassNotFoundException e) {
            //TODO
        }
        return false;
    }

    @Override
    public Quest getById(Integer id) {

        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("SELECT id,title,description,bitsreward from quests where quests.id = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                Integer idSQL = rs.getInt(1);
                String titleSQL = rs.getString(2);
                String descriptionSQL = rs.getString(3);
                Integer bitsRewardSQL = rs.getInt(4);
                return new Quest(idSQL,titleSQL,descriptionSQL,bitsRewardSQL);
            }
        }
        catch (SQLException e) {
            //TODO
        } catch (ClassNotFoundException e) {
            //TODO
        }
        return null;
    }


    public static QuestRepository getInstance(){
        if(repository == null) repository = new QuestRepository();
        return repository;
    }




}
