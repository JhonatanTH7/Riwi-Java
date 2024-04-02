package Works.MockExam1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    static Connection objConnection = null;

    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://bujzhsftxday9f2tu5cn-mysql.services.clever-cloud.com:3306/bujzhsftxday9f2tu5cn";
            String user = "u4cfu9qh3kdszyju";
            String password = "5dVuakHvxLwwPmAb2p1l";
            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Properly connected to DB");
        } catch (ClassNotFoundException e) {
            System.out.println("Error >> Driver not found");
        } catch (SQLException e) {
            System.out.println("Couldn't establish a connection with DB");
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
            System.out.println("Error >> " + e.getMessage());
        }
    }
}
