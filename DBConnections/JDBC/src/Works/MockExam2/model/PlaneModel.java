package Works.MockExam2.model;

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
        Plane objPLane = (Plane) object;
        String sql = "";

        return null;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Object> findAll() {
        List<Object> planesList = new ArrayList<>();
        String sql = "SELECT * FROM planes;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
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
