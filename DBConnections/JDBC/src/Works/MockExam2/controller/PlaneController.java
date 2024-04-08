package Works.MockExam2.controller;


import Works.MockExam2.entity.Plane;
import Works.MockExam2.model.PlaneModel;

import javax.swing.*;
import java.util.List;

public class PlaneController {

    public PlaneModel instanceModel() {
        return new PlaneModel();
    }

    public void add() {
    }

    public void update() {
    }

    public void delete() {
        Object[] options = instanceModel().findAll().toArray();
        if (options.length > 0) {
            Plane selectedOption = (Plane) JOptionPane.showInputDialog(
                    null,
                    "Select the Plane that you want to delete:\n",
                    "Deleting a Plane",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (selectedOption == null) {
                JOptionPane.showMessageDialog(null, "No option selected");
            } else {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete this Plane?");
                if (confirm == 0) {
                    if (instanceModel().delete(selectedOption.getId())) {
                        JOptionPane.showMessageDialog(null, "Plane successfully deleted");
                    } else {
                        JOptionPane.showMessageDialog(null, "Couldn't delete the Plane");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No Plane was deleted");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "There is no Planes yet");
        }
    }

    public void getAll() {
        JOptionPane.showMessageDialog(null, getAll(instanceModel().findAll()));
    }

    public StringBuilder getAll(List<Object> objectsList) {
        StringBuilder list = new StringBuilder("Planes List:\n");
        if (objectsList.isEmpty()) {
            list.append("No Planes registered yet");
        } else {
            for (Object obj : objectsList) {
                Plane objPlane = (Plane) obj;
                list.append(objPlane.toString()).append("\n");
            }
        }
        return list;
    }
}