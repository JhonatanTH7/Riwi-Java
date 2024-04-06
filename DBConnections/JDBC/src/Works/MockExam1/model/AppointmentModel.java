package Works.MockExam1.model;

import Works.MockExam1.database.CRUD;
import Works.MockExam1.database.ConfigDB;
import Works.MockExam1.entity.Appointment;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentModel implements CRUD {
    @Override
    public Object insert(Object object) {
        Appointment objAppointment = (Appointment) object;
        String sql = "INSERT INTO appointments(appointmentDate,appointmentTime,reason,idPatient,idPhysician) VALUES(?,?,?,?,?);";
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setDate(1, objAppointment.getAppointmentDate());
            objPrepare.setTime(2, objAppointment.getAppointmentTime());
            objPrepare.setString(3, objAppointment.getReason());
            objPrepare.setInt(4, objAppointment.getIdPatient());
            objPrepare.setInt(5, objAppointment.getIdPhysician());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();
            while (objResult.next()) {
                objAppointment.setId(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Appointment added successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return objAppointment;
    }

    @Override
    public boolean update(Object object) {
        String sql = "UPDATE appointments SET appointmentDate = ?, appointmentTime = ?, reason = ?, idPatient = ?, idPhysician = ? WHERE appointments.id = ?;";
        boolean isUpdated = false;
        Appointment objAppointment = (Appointment) object;
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setDate(1, objAppointment.getAppointmentDate());
            objPrepare.setTime(2, objAppointment.getAppointmentTime());
            objPrepare.setString(3, objAppointment.getReason());
            objPrepare.setInt(4, objAppointment.getIdPatient());
            objPrepare.setInt(5, objAppointment.getIdPhysician());
            objPrepare.setInt(6, objAppointment.getId());
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
        String sql = "DELETE FROM appointments WHERE appointments.id = ?;";
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
        String sql = "SELECT * FROM appointments ORDER BY appointments.id ASC;";
        List<Object> appointmentsList = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                appointmentsList.add(new Appointment(objResult.getInt("id"), objResult.getDate("appointmentDate"), objResult.getTime("appointmentTime"), objResult.getString("reason"), objResult.getInt("idPatient"), objResult.getInt("idPhysician")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return appointmentsList;
    }
}
