package Works.MockExam1.controller;

import Works.MockExam1.entity.Specialty;
import Works.MockExam1.model.SpecialtyModel;

import javax.swing.*;
import java.util.List;

public class SpecialtyController {

    SpecialtyModel objSpecialtyModel;

    public SpecialtyController() {
        this.objSpecialtyModel = new SpecialtyModel();
    }

    public void getAll() {
        String list = this.getAll(this.objSpecialtyModel.findAll());
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List<Object> objectsList) {
        String list = "                           ==== Specialties List ==== \n";
        for (Object obj : objectsList) {
            Specialty objSpecialty = (Specialty) obj;
            list += "- ID: " + objSpecialty.getId() + " Name: " + objSpecialty.getName() + " Description: "
                    + objSpecialty.getDescription() + "\n";
        }
        return list;
    }
}
