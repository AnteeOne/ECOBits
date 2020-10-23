package tech.anteeone.ecobits.services;

import tech.anteeone.ecobits.ConfigReposytory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBConnector {

    private Connection connection = null;

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(ConfigReposytory.dbURI,
                                                     ConfigReposytory.dbUser,
                                                     ConfigReposytory.dbPassword);
        }
        catch (SQLException e){
            throw e;
            //TODO(Write loggers)
        }
        catch (Exception e){
            throw e;
            //TODO(Write loggers)
        }
        return connection;
    }

}
