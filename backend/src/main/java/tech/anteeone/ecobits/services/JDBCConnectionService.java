package tech.anteeone.ecobits.services;

import tech.anteeone.ecobits.configs.ConfigRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionService {

    private Connection connection = null;

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(ConfigRepository.DB_URI,
                                                     ConfigRepository.DB_USER,
                                                     ConfigRepository.DB_PASSWORD);
        }
        catch (SQLException e){
            throw new IllegalStateException(e);
        }
        catch (Exception e){
            throw new IllegalStateException(e);
        }
        return connection;
    }

}
