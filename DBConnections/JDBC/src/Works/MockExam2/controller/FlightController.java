package Works.MockExam2.controller;

import Works.MockExam2.entity.Flight;
import Works.MockExam2.model.FlightModel;

import javax.swing.*;
import java.util.List;

public class FlightController {
    public FlightModel instanceModel() {
        return new FlightModel();
    }

    public void add() {
    }

    public void update() {
    }

    public void delete() {
        Object[] options = instanceModel().findAll().toArray();
        if (options.length > 0) {
            Flight selectedOption = (Flight) JOptionPane.showInputDialog(
                    null,
                    "Select the Flight that you want to delete:\n",
                    "Deleting a Flight",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (selectedOption == null) {
                JOptionPane.showMessageDialog(null, "No option selected");
            } else {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete this Flight?");
                if (confirm == 0) {
                    if (instanceModel().delete(selectedOption.getId())) {
                        JOptionPane.showMessageDialog(null, "Flight successfully deleted");
                    } else {
                        JOptionPane.showMessageDialog(null, "Couldn't delete the Flight");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No Flight was deleted");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "There is no Flights yet");
        }
    }

    public void getAll() {
        JOptionPane.showMessageDialog(null, getAll(instanceModel().findAll()));
    }

    public StringBuilder getAll(List<Object> objectsList) {
        StringBuilder list = new StringBuilder("Flights List:\n");
        if (objectsList.isEmpty()) {
            list.append("No Flights registered yet");
        } else {
            for (Object obj : objectsList) {
                Flight objFlight = (Flight) obj;
                list.append(objFlight.toString()).append("\n");
            }
        }
        return list;
    }
}