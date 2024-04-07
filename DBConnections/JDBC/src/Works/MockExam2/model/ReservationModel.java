package Works.MockExam2.model;

import Works.MockExam2.Utils.DeleteFromTable;
import Works.MockExam2.database.CRUD;
import Works.MockExam2.database.ConfigDB;
import Works.MockExam2.entity.Reservation;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservationModel implements CRUD {
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
        return DeleteFromTable.deleteInt("reservations", "id", id);
    }

    @Override
    public List<Object> findAll() {
        List<Object> reservationssList = new ArrayList<>();
        String sql = "SELECT * FROM flights;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                reservationssList.add(new Reservation(objResult.getInt("id"), objResult.getDate("reservationDate"), objResult.getString("seat"), objResult.getInt("idPassenger"), objResult.getInt("idFlight")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return reservationssList;
    }
}
