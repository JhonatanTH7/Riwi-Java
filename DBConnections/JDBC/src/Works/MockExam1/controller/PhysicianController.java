package Works.MockExam1.controller;

import Works.MockExam1.entity.Physician;
import Works.MockExam1.model.PhysicianModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PhysicianController {
    PhysicianModel objPhysicianModel;

    public PhysicianController() {
        this.objPhysicianModel = new PhysicianModel();
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


