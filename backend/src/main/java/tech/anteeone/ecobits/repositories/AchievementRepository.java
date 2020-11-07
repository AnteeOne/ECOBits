package tech.anteeone.ecobits.repositories;

import tech.anteeone.ecobits.models.Achievement;
import tech.anteeone.ecobits.models.User;
import tech.anteeone.ecobits.services.JDBCConnectionService;

import java.sql.SQLException;
import java.util.ArrayList;

public class AchievementRepository extends Repository {

    private static AchievementRepository repository;

    public ArrayList<Integer> getUsersAchievementId(User user){
        ArrayList<Integer> list = null;

        try {
            list = new ArrayList<Integer>();
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("SELECT achievement_id FROM user_achievements where user_id = ?");
            ps.setInt(1,user.getId());
            rs = ps.executeQuery();
            while (rs.next()){
                    Integer achievementIdSQL = rs.getInt(1);
                    list.add(rs.getInt(1));

            }
            return list;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

    }

    public Achievement getById(Integer id){
        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("SELECT achievement.id,achievement.title,achievement.description " +
                                                "FROM achievement WHERE id = ?");
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Achievement(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        }
        catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        return null;
    }


    public static AchievementRepository getInstance(){
        if(repository == null) repository = new AchievementRepository();
        return repository;
    }

}
