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
        Passenger objPassenger = (Passenger) object;
        String sql = "INSERT INTO passengers(name,lastName,identityDocument) VALUES(?,?,?);";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objPassenger.getName());
            objPrepare.setString(2, objPassenger.getLastName());
            objPrepare.setString(3, objPassenger.getIdentityDocument());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objPassenger.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Passenger added successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objPassenger;
    }

    @Override
    public boolean update(Object object) {
        Passenger objPassenger = (Passenger) object;
        boolean isUpdated = false;
        String sql = "UPDATE passengers SET name = ?, lastName = ?, identityDocument = ? WHERE id = ?;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objPassenger.getName());
            objPrepare.setString(2, objPassenger.getLastName());
            objPrepare.setString(3, objPassenger.getIdentityDocument());
            objPrepare.setInt(4, objPassenger.getId());
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
        return DeleteFromTable.deleteInt("passengers", "id", id);
    }

    @Override
    public List<Object> findAll() {
        List<Object> passengersList = new ArrayList<>();
        String sql = "SELECT * FROM passengers ORDER BY id ASC;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            ResultSet objResult = objConnection.prepareStatement(sql).executeQuery();
            while (objResult.next()) {
                passengersList.add(extractResultSet(objResult));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return passengersList;
    }

    public List<Object> findByName(String nameSearched) {
        String sql = "SELECT * FROM passengers WHERE name LIKE ?;";
        List<Object> passengersList = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(sql);
            objPreparedStatement.setString(1, "%" + nameSearched + "%");
            ResultSet objResult = objPreparedStatement.executeQuery();
            while (objResult.next()) {
                passengersList.add(extractResultSet(objResult));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return passengersList;
    }

    private Passenger extractResultSet(ResultSet objResult) throws SQLException {
        return new Passenger(objResult.getInt("id"), objResult.getString("name"), objResult.getString("lastName"), objResult.getString("identityDocument"));
    }
}
