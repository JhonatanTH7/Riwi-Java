package Works.MockExam2.model;

import Works.MockExam2.Utils.DeleteFromTable;
import Works.MockExam2.database.CRUD;
import Works.MockExam2.database.ConfigDB;
import Works.MockExam2.entity.Flight;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightModel implements CRUD {
    @Override
    public Object insert(Object object) {
        return null;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return DeleteFromTable.deleteInt("flights", "id", id);
    }

    @Override
    public List<Object> findAll() {
        List<Object> flightsList = new ArrayList<>();
        String sql = "SELECT * FROM flights;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                flightsList.add(new Flight(objResult.getInt("id"), objResult.getString("destination"), objResult.getDate("departureDate"), objResult.getTime("departureTime"), objResult.getInt("idPlane")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return flightsList;
    }
}
