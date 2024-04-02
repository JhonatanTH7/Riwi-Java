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
        return null;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public List<Object> findAll() {
        List<Object> specialtiesList = new ArrayList<>();
        String sql = "SELECT * FROM specialties;";
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
}
