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
        Physician objPhysician = (Physician) object;
        String sql = "INSERT INTO physicians(name,lastName,idSpecialty) VALUES(?,?,?);";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objPhysician.getName());
            objPrepare.setString(2, objPhysician.getLastName());
            objPrepare.setInt(3, objPhysician.getIdSpecialty());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objPhysician.setId(objResult.getInt(1));
            }
            objPrepare.close();
            JOptionPane.showMessageDialog(null, "Physician added successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objPhysician;
    }

    @Override
    public boolean update(Object object) {
        String sql = "UPDATE physicians SET name = ?, lastName = ?, idSpecialty = ? WHERE physicians.id = ?;";
        boolean isUpdated = false;
        Physician objPhysician = (Physician) object;
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objPhysician.getName());
            objPrepare.setString(2, objPhysician.getLastName());
            objPrepare.setInt(3, objPhysician.getIdSpecialty());
            objPrepare.setInt(4, objPhysician.getId());
            int affectedRows = objPrepare.executeUpdate();
            if (affectedRows > 0) {
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
        String sql = "DELETE FROM physicians WHERE physicians.id = ?;";
        boolean isDeleted = false;
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);
            int affectedRows = objPrepare.executeUpdate();
            if (affectedRows > 0) {
                isDeleted = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return isDeleted;
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
                physiciansList.add(extractResultSet(objResult));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return physiciansList;
    }

    public List<String> findPhysiciansBySpecialty(String specialty) {
        ResultSet objResult;
        List<String> filteredList = new ArrayList<>();
        String sql = "SELECT  physicians.id, physicians.name, physicians.lastName, specialties.name AS specialty FROM physicians INNER JOIN specialties ON physicians.idSpecialty = specialties.id WHERE specialties.name = ?;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(sql);
            objPreparedStatement.setString(1, specialty);
            objResult = objPreparedStatement.executeQuery();
            while (objResult.next()) {
                filteredList.add("- PhysicianID: " + objResult.getInt("id") + "  Name: " + objResult.getString("name") + " " + objResult.getString("lastName") + "  Specialty: " + objResult.getString("specialty"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return filteredList;
    }

    public Object extractResultSet(ResultSet objResult) {
        Physician objPhysician = new Physician();
        try {
            objPhysician.setId(objResult.getInt("id"));
            objPhysician.setIdSpecialty(objResult.getInt("idSpecialty"));
            objPhysician.setName(objResult.getString("name"));
            objPhysician.setLastName(objResult.getString("lastName"));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return objPhysician;
    }

}
