package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
    public static Connection connection;
    static{
        try{
            connection = DbConfig.connect("valuate-db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection connect(String dbName) throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/" + dbName;
        String username = "postgres";
        String password = "25052001Dm.";
        return DriverManager.getConnection(url, username, password);
    }
}
