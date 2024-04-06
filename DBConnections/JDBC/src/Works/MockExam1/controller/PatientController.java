package Works.MockExam1.controller;

import Works.MockExam1.entity.Patient;
import Works.MockExam1.model.PatientModel;

import javax.swing.*;
import java.sql.Date;
import java.util.List;

public class PatientController {
    public PatientModel instanceModel() {
        return new PatientModel();
    }

    public void add() {
        try {
            String name = JOptionPane.showInputDialog(null, "Enter the name of the Patient");
            String lastName = JOptionPane.showInputDialog(null, "Enter the lastname of the Patient");
            Date dateOfBirth = Date.valueOf(JOptionPane.showInputDialog(null, "Enter the Date of Birth of the Patient (YYYY-MM-DD)"));
            String identityDocument = JOptionPane.showInputDialog(null, "Enter the identity document of the Patient");
            System.out.println(instanceModel().insert(new Patient(name, lastName, dateOfBirth, identityDocument)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error >> Not a valid Date format");

        }
    }

    public void update() {
        Object[] options = instanceModel().findAll().toArray();
        if (options.length > 0) {
            Patient selectedOption = (Patient) JOptionPane.showInputDialog(
                    null,
                    "Select the Patient that you want to update:\n",
                    "Updating a Patient",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (selectedOption == null) {
                JOptionPane.showMessageDialog(null, "No option selected");
            } else {
                try {
                    selectedOption.setName(JOptionPane.showInputDialog(null, "Enter the new name of the Patient", selectedOption.getName()));
                    selectedOption.setLastName(JOptionPane.showInputDialog(null, "Enter the new lastname of the Patient", selectedOption.getLastName()));
                    Date dateOfBirth = Date.valueOf(JOptionPane.showInputDialog(null, "Enter the new Date of Birth of the Patient (YYYY-MM-DD)", selectedOption.getDateOfBirth()));
                    selectedOption.setDateOfBirth(dateOfBirth);
                    selectedOption.setIdentityDocument(JOptionPane.showInputDialog(null, "Enter the new identity document of the Patient", selectedOption.getIdentityDocument()));
                    if (instanceModel().update(selectedOption)) {
                        JOptionPane.showMessageDialog(null, "Patient Updated successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Couldn't update the Patient");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error >> Not a valid Date format");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "There is no Patients yet");
        }
    }

    public void delete() {
        Object[] options = instanceModel().findAll().toArray();
        if (options.length > 0) {
            Patient selectedOption = (Patient) JOptionPane.showInputDialog(
                    null,
                    "Select the Patient that you want to delete:\n",
                    "Deleting a Patient",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (selectedOption == null) {
                JOptionPane.showMessageDialog(null, "No option selected");
            } else {

                int confirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete the Patient " + selectedOption.getName() + " " + selectedOption.getLastName());
                if (confirm == 0) {
                    if (instanceModel().delete(selectedOption.getId())) {
                        JOptionPane.showMessageDialog(null, "Patient successfully deleted");
                    } else {
                        JOptionPane.showMessageDialog(null, "Couldn't delete the Patient");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No Patient was deleted");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "There is no Patient yet");
        }
    }

    public void getAll() {
        JOptionPane.showMessageDialog(null, this.getAll(instanceModel().findAll()));
    }

    public StringBuilder getAll(List<Object> objectsList) {
        StringBuilder list = new StringBuilder("                                                          ==== Patients List ====                                                          \n");
        if (objectsList.isEmpty()) {
            list.append("No Patients registered");
        } else {
            for (Object obj : objectsList) {
                Patient objPhysician = (Patient) obj;
                list.append(objPhysician.toString()).append("\n");
            }
        }
        return list;
    }

    public void getByIdentityDocument() {
        String identityDocSearched = JOptionPane.showInputDialog(null, "Enter the identity document of the patient that you want to search");
        List<Object> resultList = instanceModel().findByIdentityDocument(identityDocSearched);
        StringBuilder list = new StringBuilder("                                                          ==== Results List ====                                                          \n");
        list.append("Filtered by: ").append(identityDocSearched).append("\n");
        list.append(getAll(resultList));
        JOptionPane.showMessageDialog(null, list);
    }
}
