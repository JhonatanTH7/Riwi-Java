package Works.MockExam2.model;

import Works.MockExam2.Utils.DeleteFromTable;
import Works.MockExam2.database.CRUD;
import Works.MockExam2.database.ConfigDB;
import Works.MockExam2.entity.Reservation;

import javax.swing.*;
import java.sql.*;
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
                reservationssList.add(extractResultSet(objResult));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return reservationssList;
    }

    public int findTotalReservationsOfAFlight(int idFlight) {
        String sql = "SELECT COUNT(*) FROM reservations WHERE idFlight = ?;";
        int count = 0;
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, idFlight);
            ResultSet objResult = objPrepare.executeQuery();
            if (objResult.next()) {
                count = objResult.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return count;
    }

    public int findSeatAvailabilityInSpecificFlight(int idFlight, String seat) {
        String sql = "SELECT COUNT(*) FROM reservations WHERE idFlight = ? AND seat = ?;";
        int count = 0;
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, idFlight);
            objPrepare.setString(2, seat);
            ResultSet objResult = objPrepare.executeQuery();
            if (objResult.next()) {
                count = objResult.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return count;
    }

    public int findCapacityOfPLane(int idFlight) {
        String query = "SELECT capacity FROM planes WHERE id = (SELECT idPlane FROM flights WHERE id = ?)";
        int count = 0;
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(query);
            objPrepare.setInt(1, idFlight);
            ResultSet objResult = objPrepare.executeQuery();
            if (objResult.next()) {
                count = objResult.getInt("capacity");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return count;
    }

    public List<Object> findByFlightId(int idFlight) {
        List<Object> resultsList = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE idFlight = ?;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, idFlight);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                resultsList.add(extractResultSet(objResult));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return resultsList;
    }

    private Reservation extractResultSet(ResultSet objResult) throws SQLException {
        return new Reservation(objResult.getInt("id"), objResult.getDate("reservationDate"), objResult.getString("seat"), objResult.getInt("idPassenger"), objResult.getInt("idFlight"));
    }
}
