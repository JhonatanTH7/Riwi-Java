package Works.MockExam1.controller;

import Works.MockExam1.Utilities.Util;
import Works.MockExam1.entity.Physician;
import Works.MockExam1.entity.Specialty;
import Works.MockExam1.model.PhysicianModel;
import Works.MockExam1.model.SpecialtyModel;


import javax.swing.*;
import java.util.List;

public class PhysicianController {

    public PhysicianModel instanceModel() {
        return new PhysicianModel();
    }

    public void add() {

    }

    public void update() {

    }

    public void delete() {

    }

    public void getPhysiciansBySpecialty() {
        SpecialtyModel objSpecialtyModel = new SpecialtyModel();
        List<String> filteredList;
        StringBuilder list = new StringBuilder("                     =========== Results =========== \n");
        Object[] objects = Util.listToArray(objSpecialtyModel.findAll());
        String[] options = new String[objects.length];
        int i = 0;
        for (Object obj : objects) {
            Specialty objSpecialty = (Specialty) obj;
            options[i++] = objSpecialty.getName();
        }

        if (options.length > 0) {
            String selectedOption = (String) JOptionPane.showInputDialog(
                    null,
                    "Select a Specialty:\n",
                    "Filtering by Specialty",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (selectedOption == null) {
                list.append("No option selected");
            } else {
                filteredList = instanceModel().findPhysiciansBySpecialty(selectedOption);
                if (filteredList.isEmpty()) {
                    list.append("There is no Physicians in this Specialty yet");
                } else {
                    for (String result : filteredList) {
                        list.append(result).append("\n");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "There is no specialties yet");
        }
        JOptionPane.showMessageDialog(null, list);
    }

    public void getAll() {
        String list = this.getAll(instanceModel().findAll());
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List<Object> objectsList) {
        StringBuilder list = new StringBuilder("                     ==== Physicians List ==== \n");
        if (objectsList.isEmpty()) {
            list.append("No Physicians registered");
        } else {
            for (Object obj : objectsList) {
                Physician objPhysician = (Physician) obj;
                list.append("- ID: ").append(objPhysician.getId()).append(" Name: ").append(objPhysician.getName()).append("   Last name: ").append(objPhysician.getLastName()).append("  ID Specialty: ").append(objPhysician.getIdSpecialty()).append("\n");
            }
        }
        return list.toString();
    }
}


