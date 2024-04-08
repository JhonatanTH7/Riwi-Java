package Works.MockExam2.model;

import Works.MockExam2.Utils.DeleteFromTable;
import Works.MockExam2.database.CRUD;
import Works.MockExam2.database.ConfigDB;
import Works.MockExam2.entity.Plane;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneModel implements CRUD {

    @Override
    public Object insert(Object object) {
        Plane objPlane = (Plane) object;
        String sql = "INSERT INTO planes(model,capacity) VALUES(?,?);";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objPlane.getModel());
            objPrepare.setInt(2, objPlane.getCapacity());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objPlane.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Plane added successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objPlane;
    }

    @Override
    public boolean update(Object object) {
        Plane objPlane = (Plane) object;
        boolean isUpdated = false;
        String sql = "UPDATE planes SET model = ?, capacity = ? WHERE id = ?;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objPlane.getModel());
            objPrepare.setInt(2, objPlane.getCapacity());
            objPrepare.setInt(3, objPlane.getId());
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
        return DeleteFromTable.deleteInt("planes", "id", id);
    }

    @Override
    public List<Object> findAll() {
        List<Object> planesList = new ArrayList<>();
        String sql = "SELECT * FROM planes ORDER BY id ASC;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            ResultSet objResult = objConnection.prepareStatement(sql).executeQuery();
            while (objResult.next()) {
                planesList.add(new Plane(objResult.getInt("id"), objResult.getString("model"), objResult.getInt("capacity")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return planesList;
    }
}
