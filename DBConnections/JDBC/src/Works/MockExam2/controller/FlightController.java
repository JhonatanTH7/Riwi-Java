package Works.MockExam2.controller;

import Works.MockExam2.entity.Flight;
import Works.MockExam2.entity.Plane;
import Works.MockExam2.model.FlightModel;
import Works.MockExam2.model.PlaneModel;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class FlightController {
    public FlightModel instanceModel() {
        return new FlightModel();
    }

    public void add() {
        try {
            String destination = JOptionPane.showInputDialog(null, "Enter the destination of the Flight");
            Date departureDate = Date.valueOf(JOptionPane.showInputDialog(null, "Enter the Date of the departure (YYYY-MM-DD)"));
            Time departureTime = Time.valueOf(JOptionPane.showInputDialog(null, "Enter the hour of the departure (HH:MM:SS)"));
            Object[] options = new PlaneModel().findAll().toArray();
            if (options.length > 0) {
                Plane selectedOption = (Plane) JOptionPane.showInputDialog(
                        null,
                        "Select a Plane:\n",
                        "Selecting a Plane",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (selectedOption == null) {
                    JOptionPane.showMessageDialog(null, "No option selected");
                } else {
                    System.out.println(instanceModel().insert(new Flight(destination, departureDate, departureTime, selectedOption.getId())));
                }
            } else {
                JOptionPane.showMessageDialog(null, "No Planes registered yet");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error >> Not a valid format");
            System.out.println(e.getMessage());
        }
    }

    public void update() {
        Object[] options = instanceModel().findAll().toArray();
        if (options.length > 0) {
            Flight selectedOption = (Flight) JOptionPane.showInputDialog(
                    null,
                    "Select the Flight that you want to update:\n",
                    "Updating a Flight",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (selectedOption == null) {
                JOptionPane.showMessageDialog(null, "No option selected");
            } else {
                try {
                    String destination = JOptionPane.showInputDialog(null, "Enter the new destination of the Flight", selectedOption.getDestination());
                    Date departureDate = Date.valueOf(JOptionPane.showInputDialog(null, "Enter the new Date of the departure (YYYY-MM-DD)", selectedOption.getDepartureDate()));
                    Time departureTime = Time.valueOf(JOptionPane.showInputDialog(null, "Enter the new hour of the departure (HH:MM:SS)", selectedOption.getDepartureTime()));
                    Object[] planeOptions = new PlaneModel().findAll().toArray();
                    if (planeOptions.length > 0) {
                        Plane selectedPlane = (Plane) JOptionPane.showInputDialog(
                                null,
                                "Select the new Plane:\n",
                                "Updating the Plane",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                planeOptions,
                                planeOptions[0]);
                        if (selectedPlane == null) {
                            JOptionPane.showMessageDialog(null, "No option selected");
                        } else {
                            selectedOption.setDepartureDate(departureDate);
                            selectedOption.setDepartureTime(departureTime);
                            selectedOption.setDestination(destination);
                            selectedOption.setIdPlane(selectedPlane.getId());
                            if (instanceModel().update(selectedOption)) {
                                JOptionPane.showMessageDialog(null, "Flight Updated successfully");
                            } else {
                                JOptionPane.showMessageDialog(null, "Couldn't update the Flight");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No Planes registered yet");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error >> Not a valid format");
                    System.out.println(e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No Flights registered yet");
        }
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