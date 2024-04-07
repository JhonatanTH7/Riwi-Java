package Works.MockExam2.model;

import Works.MockExam2.Utils.DeleteFromTable;
import Works.MockExam2.database.CRUD;
import Works.MockExam2.database.ConfigDB;
import Works.MockExam2.entity.Passenger;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerModel implements CRUD {
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
        return DeleteFromTable.deleteInt("passengers", "id", id);
    }

    @Override
    public List<Object> findAll() {
        List<Object> passengersList = new ArrayList<>();
        String sql = "SELECT * FROM passengers;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                passengersList.add(new Passenger(objResult.getInt("id"), objResult.getString("name"), objResult.getString("lastName"), objResult.getString("identityDocument")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return passengersList;
    }
}
