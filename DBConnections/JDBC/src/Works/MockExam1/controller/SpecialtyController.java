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

    public void add() {
        String name = JOptionPane.showInputDialog(null, "Enter the name of the specialty");
        String description = JOptionPane.showInputDialog(null, "Enter the description of the specialty");
        Specialty objSpecialty = new Specialty();
        objSpecialty.setName(name);
        objSpecialty.setDescription(description);
        objSpecialty = (Specialty) this.objSpecialtyModel.insert(objSpecialty);
        JOptionPane.showMessageDialog(null, objSpecialty.toString());
    }

    public void update() {
        String list = this.getAll(this.objSpecialtyModel.findAll());
        try {
            int idUpdate = Integer
                    .parseInt(JOptionPane.showInputDialog(null, list + "\n Enter the ID of the Specialty you want to update: "));
            Specialty objSpecialty = (Specialty) this.objSpecialtyModel.findById(idUpdate);
            if (objSpecialty != null) {
                String name = JOptionPane.showInputDialog(null, "Enter the new name", objSpecialty.getName());
                String description = JOptionPane.showInputDialog(null, "Enter the new description",
                        objSpecialty.getDescription());
                objSpecialty.setName(name);
                objSpecialty.setDescription(description);
                if (this.objSpecialtyModel.update(objSpecialty)) {
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
        String list = this.getAll(this.objSpecialtyModel.findAll());
        try {
            int idDelete = Integer.parseInt(
                    JOptionPane.showInputDialog(null, list + "\n Enter the ID of the Specialty you want to delete: "));
            int confirm;
            Specialty objSpecialty = (Specialty) this.objSpecialtyModel.findById(idDelete);

            if (objSpecialty != null) {
                confirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete the Specialty  === " + objSpecialty.getName() + " ===? This will delete the Physicians who also have it.");
                if (confirm == 0) {
                    if (this.objSpecialtyModel.delete(idDelete)) {
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
        String list = this.getAll(this.objSpecialtyModel.findAll());
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List<Object> objectsList) {
        String list = "                                                                ==== Specialties List ==== \n";
        if (objectsList.isEmpty()) {
            list += "No specialties registered";
        } else {
            for (Object obj : objectsList) {
                Specialty objSpecialty = (Specialty) obj;
                list += "- ID: " + objSpecialty.getId() + " Name: " + objSpecialty.getName() + "   Description: "
                        + objSpecialty.getDescription() + "\n";
            }
        }
        return list;
    }
}
