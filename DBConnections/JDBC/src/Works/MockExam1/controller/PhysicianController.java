package Works.MockExam1.controller;

import Works.MockExam1.entity.Physician;
import Works.MockExam1.model.PhysicianModel;

import java.sql.ResultSet;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class PhysicianController {
    PhysicianModel objPhysicianModel;

    public PhysicianController() {
        this.objPhysicianModel = new PhysicianModel();
    }

    public void add() {

    }

    public void update() {

    }

    public void delete() {

    }

    public void getPhysiciansBySpecialty() {
        String specialtySearched = JOptionPane.showInputDialog(null, "Enter the name of the physician's specialty");
        String list = "                     =========== Results =========== \n";
        try {
            ResultSet objResult = this.objPhysicianModel.findPhysiciansBySpecialty(specialtySearched);
            while (objResult.next()) {
                list += "- ID Physician: " + objResult.getInt("id") + "  Name: " + objResult.getString("name") + " " + objResult.getString("lastName") + "  Specialty: " + objResult.getString("specialty") + "\n";
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            list += "Error while trying to find";
        }
        JOptionPane.showMessageDialog(null, list);
    }

    public void getAll() {
        String list = this.getAll(this.objPhysicianModel.findAll());
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List<Object> objectsList) {
        String list = "                     ==== Physicians List ==== \n";
        if (objectsList.isEmpty()) {
            list += "No Physicians registered";
        } else {
            for (Object obj : objectsList) {
                Physician objPhysician = (Physician) obj;
                list += "- ID: " + objPhysician.getId() + " Name: " + objPhysician.getName() + "   Last name: "
                        + objPhysician.getLastName() + "  ID Specialty: " + objPhysician.getIdSpecialty() + "\n";
            }
        }
        return list;
    }
}


