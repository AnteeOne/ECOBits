package tech.anteeone.ecobits.repositories;

import tech.anteeone.ecobits.configs.ConfigRepository;
import tech.anteeone.ecobits.models.User;
import tech.anteeone.ecobits.services.JDBCConnectionService;
import tech.anteeone.ecobits.services.UserSecurityService;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepository extends Repository {

    private static UserRepository repository = null;

    public boolean userSignUp(User user){
        Boolean flag = false;
        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("INSERT INTO users (username, email, password, bitscount, role,session_id) " +
                                        "VALUES (?,?,?,?,?,?)");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getEmail());
            ps.setString(3, UserSecurityService.hashPassword(user.getPassword(), ConfigRepository.SECURITY_KEY));
            ps.setInt(4,user.getBitsCount());
            ps.setString(5,user.getRole());
            ps.setString(6,UserSecurityService.generateUserSessionCode(user, ConfigRepository.SECURITY_KEY));
            int num = ps.executeUpdate();
            if (num == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        finally {
            this.close();
        }

        return flag;
    }

    public boolean checkUserData(User user){
        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("SELECT users.email," +
                                                  "users.password FROM users");
            rs = ps.executeQuery();
            while(rs.next()){
                String emailSQL = rs.getString(1);
                String passwordSQL = rs.getString(2);
                if(user.getEmail().equals(emailSQL) &&
                                passwordSQL.equals(UserSecurityService.hashPassword
                                (user.getPassword(), ConfigRepository.SECURITY_KEY))){
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

        return false;
    }

    public boolean updateUsersQuest(String session,Integer questId){
        try{
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("UPDATE users SET active_quest_id = ? where session_id = ?");
            ps.setInt(1,questId);
            ps.setString(2,session);
            rs = ps.executeQuery();
            return true;
        } catch (SQLException e) {
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }

    }

    public boolean updateUsersBits(Integer id,Integer bitsCount){
        try{
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("UPDATE users SET bitscount = bitscount + ? where id = ?");
            ps.setInt(1,bitsCount);
            ps.setInt(2,id);
            rs = ps.executeQuery();
            return true;
        } catch (SQLException e) {
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }

    }

    public boolean emailIsAvailable(User user){
        try{
            String userEmail = user.getEmail();
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("SELECT users.email FROM users");
            rs = ps.executeQuery();
            while (rs.next()){
                String emailSQL = rs.getString(1);
                if(userEmail.equals(emailSQL)){
                    return false;
                }
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        return true;
    }

    public User getUserFromSession(String session) throws NullPointerException{

        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("SELECT users.username,users.email,users.bitscount" +
                                            ",users.role,users.session_id," +
                                            "users.active_quest_id,users.completed_quests_count,id FROM users");
            rs = ps.executeQuery();
            while (rs.next()){
                String sessionSQL = rs.getString(5);
                if(session.equals(sessionSQL)){
                    String usernameSQL = rs.getString(1);
                    String emailSQL = rs.getString(2);
                    Integer bitsCountSQL = rs.getInt(3);
                    String roleSQL = rs.getString(4);
                    Integer activeQuestIdSQL = rs.getInt(6);
                    Integer completedQuestsCountSQL = rs.getInt(7);
                    Integer idSQL = rs.getInt(8);
                    return new User(idSQL,usernameSQL,emailSQL,bitsCountSQL,roleSQL,activeQuestIdSQL,completedQuestsCountSQL);
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        return null;
    }

    public ArrayList<User> getСompletedQuestUsers(){
        ArrayList<User> list = new ArrayList();
        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("SELECT users.username,users.active_quest_id,users.id from users where active_quest_id IS NOT NULL");
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new User(rs.getInt(3),rs.getString(1),rs.getInt(2)));
            }
            return list;
        }
        catch (SQLException e) {
            return list;
        } catch (ClassNotFoundException e) {
            return list;
        }

    }

    private void close() {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (ps != null) {
                ps.close();
                ps = null;
            }
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static UserRepository getInstance(){
        if(repository == null) repository = new UserRepository();
        return repository;
    }
}
