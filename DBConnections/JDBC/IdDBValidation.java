import Works.MockExam1.database.ConfigDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdDBValidation {
    public boolean validate(int idValidate, String tableValidate) {
        String sql = "SELECT * FROM " + tableValidate + " WHERE id = ?;";
        boolean existsInDB = false;
        Connection objConnection = ConfigDB.openConnection();
        try {
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, idValidate);
            ResultSet objResult = (ResultSet) objPrepare.executeQuery();
            if (objResult.next()) {
                existsInDB = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        ConfigDB.closeConnection();
        return existsInDB;
    }
}
