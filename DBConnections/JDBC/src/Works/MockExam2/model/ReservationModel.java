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
        Reservation objReservation = (Reservation) object;
        String sql = "INSERT INTO reservations(reservationDate,seat,idPassenger,idFlight) VALUES(?,?,?,?);";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setDate(1, objReservation.getReservationDate());
            objPrepare.setString(2, objReservation.getSeat());
            objPrepare.setInt(3, objReservation.getIdPassenger());
            objPrepare.setInt(4, objReservation.getIdFlight());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objReservation.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Reservation added successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objReservation;
    }

    @Override
    public boolean update(Object object) {
        Reservation objReservation = (Reservation) object;
        boolean isUpdated = false;
        String sql = "UPDATE reservations SET reservationDate = ?, seat = ?, idPassenger = ?, idFlight = ? WHERE id = ?;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setDate(1, objReservation.getReservationDate());
            objPrepare.setString(2, objReservation.getSeat());
            objPrepare.setInt(3, objReservation.getIdPassenger());
            objPrepare.setInt(4, objReservation.getIdFlight());
            objPrepare.setInt(5, objReservation.getId());
            if (objPrepare.executeUpdate() > 0) {
                isUpdated = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdated;
    }

    @Override
    public boolean delete(int id) {
        return DeleteFromTable.deleteInt("reservations", "id", id);
    }

    @Override
    public List<Object> findAll() {
        List<Object> reservationssList = new ArrayList<>();
        String sql = "SELECT * FROM reservations ORDER BY id ASC;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            ResultSet objResult = objConnection.prepareStatement(sql).executeQuery();
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
