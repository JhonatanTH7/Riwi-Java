package Works.MockExam1.controller;

import Works.MockExam1.entity.Specialty;
import Works.MockExam1.model.SpecialtyModel;

import javax.swing.*;
import java.util.List;

public class SpecialtyController {
    public SpecialtyModel instanceModel() {
        return new SpecialtyModel();
    }


    public void add() {
        String name = JOptionPane.showInputDialog(null, "Enter the name of the specialty");
        String description = JOptionPane.showInputDialog(null, "Enter the description of the specialty");
        System.out.println(instanceModel().insert(new Specialty(name, description)));
    }

    public void update() {
        StringBuilder list = this.getAll(instanceModel().findAll());
        try {
            int idUpdate = Integer
                    .parseInt(JOptionPane.showInputDialog(null, list + "\n Enter the ID of the Specialty you want to update: "));
            Specialty objSpecialty = (Specialty) instanceModel().findById(idUpdate);
            if (objSpecialty != null) {
                String name = JOptionPane.showInputDialog(null, "Enter the new name", objSpecialty.getName());
                String description = JOptionPane.showInputDialog(null, "Enter the new description",
                        objSpecialty.getDescription());
                objSpecialty.setName(name);
                objSpecialty.setDescription(description);
                if (instanceModel().update(objSpecialty)) {
                    JOptionPane.showMessageDialog(null, "Specialty Updated successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Couldn't update the Specialty");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not a valid ID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Value entered is not a number");
        }
    }

    public void delete() {
        StringBuilder list = this.getAll(instanceModel().findAll());
        try {
            int idDelete = Integer.parseInt(
                    JOptionPane.showInputDialog(null, list + "\n Enter the ID of the Specialty you want to delete: "));
            int confirm;
            Specialty objSpecialty = (Specialty) instanceModel().findById(idDelete);

            if (objSpecialty != null) {
                confirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete the Specialty  === " + objSpecialty.getName() + " ===? This will delete all the information related to it.");
                if (confirm == 0) {
                    if (instanceModel().delete(idDelete)) {
                        JOptionPane.showMessageDialog(null,
                                "Specialty and the physicians who have it successfully deleted.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Couldn't delete the Speciality");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No Specialty was deleted");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not a valid ID");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Value entered is not a number");
        }
    }

    public void getAll() {
        JOptionPane.showMessageDialog(null, this.getAll(instanceModel().findAll()));
    }

    public StringBuilder getAll(List<Object> objectsList) {
        StringBuilder list = new StringBuilder("                                                                ==== Specialties List ====                                                                \n");
        if (objectsList.isEmpty()) {
            list.append("No specialties registered");
        } else {
            for (Object obj : objectsList) {
                Specialty objSpecialty = (Specialty) obj;
                list.append(objSpecialty.toString()).append("\n");
            }
        }
        return list;
    }
}
