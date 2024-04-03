package Works.MockExam1.model;

import Works.MockExam1.database.CRUD;
import Works.MockExam1.database.ConfigDB;
import Works.MockExam1.entity.Patient;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientModel implements CRUD {
    @Override
    public Object insert(Object object) {
        Patient objPatient = (Patient) object;
        String sql = "INSERT INTO patients(name, lastName, dateOfBirth, identityDocument) VALUES(?,?,?,?);";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objPatient.getName());
            objPrepare.setString(2, objPatient.getLastName());
            objPrepare.setDate(3, objPatient.getDateOfBirth());
            objPrepare.setString(4, objPatient.getIdentityDocument());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objPatient.setId(objResult.getInt(1));
            }
            objPrepare.close();
            JOptionPane.showMessageDialog(null, "Patient added successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objPatient;
    }

    @Override
    public boolean update(Object object) {
        String sql = "UPDATE patients SET name = ?, lastName = ?, dateOfBirth = ?, identityDocument = ? WHERE patients.id = ?;";
        boolean isUpdated = false;
        Patient objPatient = (Patient) object;
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, objPatient.getName());
            objPrepare.setString(2, objPatient.getLastName());
            objPrepare.setDate(3, objPatient.getDateOfBirth());
            objPrepare.setString(4, objPatient.getIdentityDocument());
            objPrepare.setInt(5, objPatient.getId());
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
        String sql = "DELETE FROM patients WHERE patients.id = ?;";
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
        String sql = "SELECT * FROM patients ORDER BY patients.id = ?;";
        List<Object> patientsList = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                Patient objPatient = new Patient();
                objPatient.setId(objResult.getInt("id"));
                objPatient.setName(objResult.getString("name"));
                objPatient.setLastName(objResult.getString("lastName"));
                objPatient.setDateOfBirth(objResult.getDate("dateOfBirth"));
                objPatient.setIdentityDocument(objResult.getString("identityDocument"));
                patientsList.add(objPatient);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return patientsList;
    }

    @Override
    public Object findById(int id) {
        String sql = "SELECT FROM patients WHERE patients.id = ?;";
        Patient objPatient = null;
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                objPatient = new Patient();
                objPatient.setId(objResult.getInt("id"));
                objPatient.setName(objResult.getString("name"));
                objPatient.setLastName(objResult.getString("lastName"));
                objPatient.setDateOfBirth(objResult.getDate("dateOfBirth"));
                objPatient.setIdentityDocument(objResult.getString("identityDocument"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objPatient;
    }

    public List<Object> findByIdentityDocument(String identityDocumentValidate) {
        Patient objPatient;
        String sql = "SELECT * FROM patients WHERE patients.identityDocument LIKE ?;";
        List<Object> patientsList = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPreparedStatement = objConnection.prepareStatement(sql);
            objPreparedStatement.setString(1, "%" + identityDocumentValidate + "%");
            ResultSet objResult = objPreparedStatement.executeQuery();
            while (objResult.next()) {
                objPatient = new Patient();
                objPatient.setId(objResult.getInt("id"));
                objPatient.setName(objResult.getString("name"));
                objPatient.setLastName(objResult.getString("lastName"));
                objPatient.setDateOfBirth(objResult.getDate("dateOfBirth"));
                objPatient.setIdentityDocument(objResult.getString("identityDocument"));
                patientsList.add(objPatient);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return patientsList;
    }
}
