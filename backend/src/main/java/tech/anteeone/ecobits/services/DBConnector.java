package tech.anteeone.ecobits.services;

import tech.anteeone.ecobits.ConfigReposytory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private Connection connection = null;

    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(ConfigReposytory.dbURI,
                                                     ConfigReposytory.dbUser,
                                                     ConfigReposytory.dbPassword);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

}
