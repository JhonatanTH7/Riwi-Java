package Works.MockExam1.controller;

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
        String name = JOptionPane.showInputDialog(null, "Enter the name of the Physician");
        String lastName = JOptionPane.showInputDialog(null, "Enter the lastname of the Physician");
        Object[] options = new SpecialtyModel().findAll().toArray();
        if (options.length > 0) {
            Specialty selectedOption = (Specialty) JOptionPane.showInputDialog(
                    null,
                    "Select a Specialty:\n",
                    "Selecting a Specialty",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (selectedOption == null) {
                JOptionPane.showMessageDialog(null, "No option selected");
            } else {
                System.out.println(instanceModel().insert(new Physician(name, lastName, selectedOption.getId())));
            }
        } else {
            JOptionPane.showMessageDialog(null, "There is no specialties yet");
        }
    }

    public void update() {
        Object[] options = instanceModel().findAll().toArray();
        if (options.length > 0) {
            Physician selectedOption = (Physician) JOptionPane.showInputDialog(
                    null,
                    "Select the Physician that you want to update:\n",
                    "Updating a Physician",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (selectedOption == null) {
                JOptionPane.showMessageDialog(null, "No option selected");
            } else {
                String name = JOptionPane.showInputDialog(null, "Enter the new name of the Physician", selectedOption.getName());
                String lastName = JOptionPane.showInputDialog(null, "Enter the new lastname of the Physician", selectedOption.getLastName());
                Object[] optionsSpecialty = new SpecialtyModel().findAll().toArray();
                if (optionsSpecialty.length > 0) {
                    Specialty selectedSpecialty = (Specialty) JOptionPane.showInputDialog(
                            null,
                            "Select the new Specialty:\n",
                            "Selecting a Specialty",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            optionsSpecialty,
                            optionsSpecialty[selectedOption.getIdSpecialty() - 1]);
                    if (selectedSpecialty == null) {
                        JOptionPane.showMessageDialog(null, "No option selected");
                    } else {
                        selectedOption.setName(name);
                        selectedOption.setLastName(lastName);
                        selectedOption.setIdSpecialty(selectedSpecialty.getId());
                        if (instanceModel().update(selectedOption)) {
                            JOptionPane.showMessageDialog(null, "Physician Updated successfully");
                        } else {
                            JOptionPane.showMessageDialog(null, "Couldn't update the Physician");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "There is no specialties yet");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "There is no Physicians yet");
        }
    }

    public void delete() {
        Object[] options = instanceModel().findAll().toArray();
        if (options.length > 0) {
            Physician selectedOption = (Physician) JOptionPane.showInputDialog(
                    null,
                    "Select the Physician that you want to delete:\n",
                    "Deleting a Physician",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (selectedOption == null) {
                JOptionPane.showMessageDialog(null, "No option selected");
            } else {

                int confirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete the Physician?" + selectedOption.getName() + " " + selectedOption.getLastName());
                if (confirm == 0) {
                    if (instanceModel().delete(selectedOption.getId())) {
                        JOptionPane.showMessageDialog(null, "Physician successfully deleted");
                    } else {
                        JOptionPane.showMessageDialog(null, "Couldn't delete the Physician");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No Physician was deleted");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "There is no Physicians yet");
        }
    }

    public void getPhysiciansBySpecialty() {
        List<String> filteredList;
        StringBuilder list = new StringBuilder("                     =========== Results ===========                     \n");
        Object[] options = new SpecialtyModel().findAll().toArray();
        if (options.length > 0) {
            Specialty selectedOption = (Specialty) JOptionPane.showInputDialog(
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
                filteredList = instanceModel().findPhysiciansBySpecialty(selectedOption.getName());
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
        JOptionPane.showMessageDialog(null, this.getAll(instanceModel().findAll()));
    }

    public StringBuilder getAll(List<Object> objectsList) {
        StringBuilder list = new StringBuilder("                     ==== Physicians List ====                     \n");
        if (objectsList.isEmpty()) {
            list.append("No Physicians registered");
        } else {
            for (Object obj : objectsList) {
                Physician objPhysician = (Physician) obj;
                list.append(objPhysician.toString()).append("\n");
            }
        }
        return list;
    }
}


