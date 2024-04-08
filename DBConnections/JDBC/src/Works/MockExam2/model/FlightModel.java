package Works.MockExam2.model;

import Works.MockExam2.Utils.DeleteFromTable;
import Works.MockExam2.database.CRUD;
import Works.MockExam2.database.ConfigDB;
import Works.MockExam2.entity.Flight;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightModel implements CRUD {
    @Override
    public Object insert(Object object) {
        Flight objFlight = (Flight) object;
        String sql = "INSERT INTO flights(destination,departureDate,departureTime,idPlane) VALUES(?,?,?,?);";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objFlight.getDestination());
            objPrepare.setDate(2, objFlight.getDepartureDate());
            objPrepare.setTime(3, objFlight.getDepartureTime());
            objPrepare.setInt(4, objFlight.getIdPlane());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objFlight.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Flight added successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objFlight;
    }

    @Override
    public boolean update(Object object) {
        Flight objFlight = (Flight) object;
        boolean isUpdated = false;
        String sql = "UPDATE flights SET destination = ?, departureDate= ?, departureTime = ?, idPlane = ? WHERE id = ?;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objFlight.getDestination());
            objPrepare.setDate(2, objFlight.getDepartureDate());
            objPrepare.setTime(3, objFlight.getDepartureTime());
            objPrepare.setInt(4, objFlight.getIdPlane());
            objPrepare.setInt(5, objFlight.getId());
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
        return DeleteFromTable.deleteInt("flights", "id", id);
    }

    @Override
    public List<Object> findAll() {
        List<Object> flightsList = new ArrayList<>();
        String sql = "SELECT * FROM flights ORDER BY id ASC;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            ResultSet objResult = objConnection.prepareStatement(sql).executeQuery();
            while (objResult.next()) {
                flightsList.add(extractResultSet(objResult));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return flightsList;
    }

    public List<Object> findByDestination(String destinationValidate) {
        String sql = "SELECT * FROM flights WHERE destination LIKE ?;";
        List<Object> flightsList = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(sql);
            objPreparedStatement.setString(1, "%" + destinationValidate + "%");
            ResultSet objResult = objPreparedStatement.executeQuery();
            while (objResult.next()) {
                flightsList.add(extractResultSet(objResult));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return flightsList;
    }

    public List<Object> findByDate(Date searchedDate) {
        List<Object> resultsList = new ArrayList<>();
        String sql = "SELECT * FROM flights WHERE departureDate = ?;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setDate(1, searchedDate);
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

    private Flight extractResultSet(ResultSet objResult) throws SQLException {
        return new Flight(objResult.getInt("id"), objResult.getString("destination"), objResult.getDate("departureDate"), objResult.getTime("departureTime"), objResult.getInt("idPlane"));
    }
}
