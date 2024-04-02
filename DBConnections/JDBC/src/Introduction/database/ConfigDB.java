package Introduction.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    static Connection objConnection = null;

    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/_01_jdbc";
            String user = "root";
            String password = "Rlwl2023.";
            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Properly connected to DB");
        } catch (ClassNotFoundException e) {
            System.out.println("Error >> Driver not installed");
        } catch (SQLException e) {
            System.out.println("Error >> Couldn't establish a connection with the DB");
        }
        return objConnection;
    }

    public static void closeConnection() {
        try {
            if (objConnection != null) {
                objConnection.close();
                System.out.println("DB connection closed");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
