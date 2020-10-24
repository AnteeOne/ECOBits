package tech.anteeone.ecobits.services;

import tech.anteeone.ecobits.ConfigReposytory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private Connection connection = null;

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(ConfigReposytory.DB_URI,
                                                     ConfigReposytory.DB_USER,
                                                     ConfigReposytory.DB_PASSWORD);
        }
        catch (SQLException e){
            //TODO(Write loggers)
        }
        catch (Exception e){
            //TODO(Write loggers)
        }
        return connection;
    }

}
