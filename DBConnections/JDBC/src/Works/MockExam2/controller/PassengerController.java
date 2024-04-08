package Works.MockExam2.controller;

import Works.MockExam2.entity.Passenger;
import Works.MockExam2.model.PassengerModel;

import javax.swing.*;
import java.util.List;

public class PassengerController {
    public PassengerModel instanceModel() {
        return new PassengerModel();
    }

    public void add() {
        String name = JOptionPane.showInputDialog(null, "Enter the name of the Passenger");
        String lastName = JOptionPane.showInputDialog(null, "Enter the lastname of the Passenger");
        String identityDocument = JOptionPane.showInputDialog(null, "Enter the identity document of the Passenger");
        System.out.println(instanceModel().insert(new Passenger(name, lastName, identityDocument)));
    }

    public void update() {
        Object[] options = instanceModel().findAll().toArray();
        if (options.length > 0) {
            Passenger selectedOption = (Passenger) JOptionPane.showInputDialog(
                    null,
                    "Select the Passenger that you want to update:\n",
                    "Updating a Passenger",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (selectedOption == null) {
                JOptionPane.showMessageDialog(null, "No option selected");
            } else {
                selectedOption.setName(JOptionPane.showInputDialog(null, "Enter the new name of the Passenger", selectedOption.getName()));
                selectedOption.setLastName(JOptionPane.showInputDialog(null, "Enter the new lastname of the Passenger", selectedOption.getLastName()));
                selectedOption.setIdentityDocument(JOptionPane.showInputDialog(null, "Enter the new identity document of the Passenger", selectedOption.getIdentityDocument()));
                if (instanceModel().update(selectedOption)) {
                    JOptionPane.showMessageDialog(null, "Passenger Updated successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Couldn't update the Passenger");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No Passengers registered yet");
        }
    }

    public void delete() {
        Object[] options = instanceModel().findAll().toArray();
        if (options.length > 0) {
            Passenger selectedOption = (Passenger) JOptionPane.showInputDialog(
                    null,
                    "Select the Passenger that you want to delete:\n",
                    "Deleting a Passenger",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (selectedOption == null) {
                JOptionPane.showMessageDialog(null, "No option selected");
            } else {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete this Passenger?");
                if (confirm == 0) {
                    if (instanceModel().delete(selectedOption.getId())) {
                        JOptionPane.showMessageDialog(null, "Passenger successfully deleted");
                    } else {
                        JOptionPane.showMessageDialog(null, "Couldn't delete the Passenger");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No Passenger was deleted");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "There is no Passengers yet");
        }
    }

    public void getAll() {
        JOptionPane.showMessageDialog(null, getAll(instanceModel().findAll()));
    }

    public StringBuilder getAll(List<Object> objectsList) {
        StringBuilder list = new StringBuilder("Passengers List:\n");
        if (objectsList.isEmpty()) {
            list.append("No Passengers registered yet");
        } else {
            for (Object obj : objectsList) {
                Passenger objPassenger = (Passenger) obj;
                list.append(objPassenger.toString()).append("\n");
            }
        }
        return list;
    }

    public void getByName() {
        String nameSearched = JOptionPane.showInputDialog(null, "Enter the name of the passenger you want to search");
        StringBuilder list = new StringBuilder("Filtered by Name: " + nameSearched + "\n");
        list.append(getAll(instanceModel().findByName(nameSearched)));
        JOptionPane.showMessageDialog(null, list);
    }
}
