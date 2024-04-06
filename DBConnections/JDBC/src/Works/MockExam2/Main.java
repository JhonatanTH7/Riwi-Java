package Works.MockExam2;

import Works.MockExam2.database.ConfigDB;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection objConnection = ConfigDB.openConnection();
        ConfigDB.closeConnection();
    }
}
