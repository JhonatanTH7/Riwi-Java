package Works.MockExam1.model;

import Works.MockExam1.database.CRUD;
import Works.MockExam1.database.ConfigDB;
import Works.MockExam1.entity.Specialty;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialtyModel implements CRUD {

    @Override
    public Object insert(Object object) {
        Specialty objSpecialty = (Specialty) object;
        String sql = "INSERT INTO specialties(name,description) VALUES(?,?);";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objSpecialty.getName());
            objPrepare.setString(2, objSpecialty.getDescription());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objSpecialty.setId(objResult.getInt(1));
            }
            objPrepare.close();
            JOptionPane.showMessageDialog(null, "Specialty added successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        ConfigDB.closeConnection();
        return objSpecialty;
    }

    @Override
    public boolean update(Object object) {
        String sql = "UPDATE specialties SET name = ?, description = ? WHERE specialties.id = ?;";
        boolean isUpdated = false;
        Specialty objSpecialty = (Specialty) object;
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objSpecialty.getName());
            objPrepare.setString(2, objSpecialty.getDescription());
            objPrepare.setInt(3, objSpecialty.getId());
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
        String sql = "DELETE FROM specialties WHERE specialties.id = ?;";
        boolean isDeleted = false;
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);
            int rowsAffected = objPrepare.executeUpdate();
            if (rowsAffected > 0) {
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
        List<Object> specialtiesList = new ArrayList<>();
        String sql = "SELECT * FROM specialties ORDER BY specialties.id ASC;";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                Specialty objSpecialty = new Specialty(objResult.getInt("id"), objResult.getString("name"), objResult.getString("description"));
                specialtiesList.add(objSpecialty);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return specialtiesList;
    }

    @Override
    public Object findById(int id) {
        Specialty objSpecialty = null;
        Connection objConnection = ConfigDB.openConnection();
        String sql = "SELECT * FROM specialties WHERE specialties.id = ?;";
        try {
            PreparedStatement objPreparedStatement = (PreparedStatement) objConnection.prepareStatement(sql);
            objPreparedStatement.setInt(1, id);
            ResultSet objResultSet = objPreparedStatement.executeQuery();
            while (objResultSet.next()) {
                objSpecialty = new Specialty();
                objSpecialty.setId(objResultSet.getInt("id"));
                objSpecialty.setName(objResultSet.getString("name"));
                objSpecialty.setDescription(objResultSet.getString("description"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objSpecialty;
    }
}
