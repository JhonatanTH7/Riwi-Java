package Works.MockExam2.controller;


import Works.MockExam2.entity.Plane;
import Works.MockExam2.entity.Reservation;
import Works.MockExam2.model.ReservationModel;

import javax.swing.*;
import java.util.List;

public class ReservationController {

    public ReservationModel instanceModel() {
        return new ReservationModel();
    }

    public void add() {
    }

    public void update() {
    }

    public void delete() {
        Object[] options = instanceModel().findAll().toArray();
        if (options.length > 0) {
            Reservation selectedOption = (Reservation) JOptionPane.showInputDialog(
                    null,
                    "Select the Reservation that you want to delete:\n",
                    "Deleting a Reservation",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (selectedOption == null) {
                JOptionPane.showMessageDialog(null, "No option selected");
            } else {
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete this Reservation?");
                if (confirm == 0) {
                    if (instanceModel().delete(selectedOption.getId())) {
                        JOptionPane.showMessageDialog(null, "Reservation successfully deleted");
                    } else {
                        JOptionPane.showMessageDialog(null, "Couldn't delete the Reservation");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No Reservation was deleted");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "There is no Reservations yet");
        }
    }

    public void getAll() {
        JOptionPane.showMessageDialog(null, getAll(instanceModel().findAll()));
    }

    public StringBuilder getAll(List<Object> objectsList) {
        StringBuilder list = new StringBuilder("Reservations List:\n");
        if (objectsList.isEmpty()) {
            list.append("No Reservations registered yet");
        } else {
            for (Object obj : objectsList) {
                Reservation objReservation = (Reservation) obj;
                list.append(objReservation.toString()).append("\n");
            }
        }
        return list;
    }
}