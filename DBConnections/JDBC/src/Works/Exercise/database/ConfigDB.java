package Works.Exercise.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    static Connection objConnection = null;

    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://br9t0eyu1xjgshu5koum-mysql.services.clever-cloud.com:3306/br9t0eyu1xjgshu5koum";
            String user = "un1raksiq8ohfxd1";
            String password = "IJvLwWlFKFx5gOM38yYJ";
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
