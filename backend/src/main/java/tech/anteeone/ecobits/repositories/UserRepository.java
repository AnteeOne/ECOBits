package tech.anteeone.ecobits.repositories;

import tech.anteeone.ecobits.configs.ConfigRepository;
import tech.anteeone.ecobits.models.User;
import tech.anteeone.ecobits.services.JDBCConnectionService;
import tech.anteeone.ecobits.services.UserSecurityService;

import java.sql.SQLException;

public class UserRepository extends Repository {


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
            //TODO(Write loggers)
        } catch (ClassNotFoundException e) {
            //TODO(Write loggers)
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
            //TODO(Write loggers)
        } catch (ClassNotFoundException e) {
            //TODO(Write loggers)
        }

        return false;
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
            //TODO(Write loggers)
        } catch (ClassNotFoundException e) {
            //TODO(Write loggers)
        }
        return true;
    }

    public User getUserFromSession(String session) throws NullPointerException{

        try {
            JDBCConnectionService connector = new JDBCConnectionService();
            con = connector.getConnection();
            ps = con.prepareStatement("SELECT users.username,users.email,users.bitscount" +
                                            ",users.role,users.session_id FROM users");
            rs = ps.executeQuery();
            while (rs.next()){
                String sessionSQL = rs.getString(5);
                if(session.equals(sessionSQL)){
                    String usernameSQL = rs.getString(1);
                    String emailSQL = rs.getString(2);
                    Integer bitsCountSQL = rs.getInt(3);
                    String roleSQL = rs.getString(4);
                    return new User(usernameSQL,emailSQL,bitsCountSQL,roleSQL);
                }
            }

        } catch (SQLException e) {
            //TODO(Write loggers)
        } catch (ClassNotFoundException e) {
            //TODO(Write loggers)
        }
        return null;
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
            //TODO(Write loggers)
        }
    }

    public static UserRepository getInstance(){
        return new UserRepository();
    }
}
