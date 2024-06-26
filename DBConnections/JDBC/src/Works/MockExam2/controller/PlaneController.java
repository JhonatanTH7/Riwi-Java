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
        try {
            String model = JOptionPane.showInputDialog(null, "Enter the model of the Plane");
            int capacity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the capacity of the Plane"));
            System.out.println(instanceModel().insert(new Plane(model, capacity)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error >> Value entered not valid");
            System.out.println(e.getMessage());
        }
    }

    public void update() {
        Object[] options = instanceModel().findAll().toArray();
        if (options.length > 0) {
            Plane selectedOption = (Plane) JOptionPane.showInputDialog(
                    null,
                    "Select the Plane that you want to update:\n",
                    "Updating a Plane",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (selectedOption == null) {
                JOptionPane.showMessageDialog(null, "No option selected");
            } else {
                try {
                    selectedOption.setModel(JOptionPane.showInputDialog(null, "Enter the model of the Plane", selectedOption.getModel()));
                    selectedOption.setCapacity(Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the capacity of the Plane", selectedOption.getCapacity())));
                    if (instanceModel().update(selectedOption)) {
                        JOptionPane.showMessageDialog(null, "Plane Updated successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Couldn't update the Plane");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error >> Value entered not valid");
                    System.out.println(e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No Planes registered yet");
        }
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
            JOptionPane.showMessageDialog(null, "No Planes registered yet");
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