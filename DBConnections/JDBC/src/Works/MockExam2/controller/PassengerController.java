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
    }

    public void update() {
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
        StringBuilder list = new StringBuilder("Passenger List:\n");
        if (objectsList.isEmpty()) {
            list.append("No Passenger registered yet");
        } else {
            for (Object obj : objectsList) {
                Passenger objPassenger = (Passenger) obj;
                list.append(objPassenger.toString()).append("\n");
            }
        }
        return list;
    }
}
