package tech.anteeone.ecobits.services;

import tech.anteeone.ecobits.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDBService {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public boolean userSignUp(User user){
        Boolean flag = false;
        try {
            DBConnector connector = new DBConnector();
            con = connector.getConnection();
            ps = con.prepareStatement("INSERT INTO users (username, email, password, bitscount, role) " +
                                        "VALUES (?,?,?,?,?)");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getEmail());
            ps.setString(3,user.getPassword());
            ps.setInt(4,user.getBitsCount());
            ps.setString(5,user.getRole());
            int num = ps.executeUpdate();
            if (num == 1) {
                flag = true;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return flag;
    }
}
