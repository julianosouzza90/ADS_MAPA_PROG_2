package mapa.ads.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author souzz
 */
public class ConnectionFactory {
      
    private static Connection connection;
    public static Connection getConnection() throws SQLException {
        if(ConnectionFactory.connection == null) {
            String url = "jdbc:mysql://localhost:3306/mapa";
            String user = "root";
            String password = "17213103";
            ConnectionFactory.connection = DriverManager.getConnection(url, user, password);
          }
        return ConnectionFactory.connection;
    }
}
