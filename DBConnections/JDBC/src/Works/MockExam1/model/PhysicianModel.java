package Works.MockExam1.model;

import Works.MockExam1.database.CRUD;
import Works.MockExam1.database.ConfigDB;
import Works.MockExam1.entity.Physician;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhysicianModel implements CRUD {
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
        return false;
    }

    @Override
    public List<Object> findAll() {
        List<Object> physiciansList = new ArrayList<>();
        String sql = "SELECT * FROM physicians ORDER BY physicians.id ASC;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                Physician objPhysician = new Physician();
                objPhysician.setId(objResult.getInt("id"));
                objPhysician.setName(objResult.getString("name"));
                objPhysician.setLastName(objResult.getString("lastName"));
                objPhysician.setIdSpecialty(objResult.getInt("idSpecialty"));
                physiciansList.add(objPhysician);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return physiciansList;
    }

    @Override
    public Object findById(int id) {
        String sql = "SELECT FROM physicians WHERE physicians.id = ?;";
        Physician objPhysician = null;
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                objPhysician = new Physician();
                objPhysician.setId(objResult.getInt("id"));
                objPhysician.setIdSpecialty(objResult.getInt("idSpecialty"));
                objPhysician.setName(objResult.getString("name"));
                objPhysician.setLastName(objResult.getString("lastName"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objPhysician;
    }
}
