package Works.MockExam2.controller;


import Works.MockExam2.entity.Flight;
import Works.MockExam2.entity.Passenger;
import Works.MockExam2.entity.Reservation;
import Works.MockExam2.model.FlightModel;
import Works.MockExam2.model.PassengerModel;
import Works.MockExam2.model.ReservationModel;

import javax.swing.*;
import java.sql.Date;
import java.util.List;

public class ReservationController {

    public ReservationModel instanceModel() {
        return new ReservationModel();
    }

    public void add() {
        Object[] optionsFlight = new FlightModel().findByDate(Date.valueOf(JOptionPane.showInputDialog(null, "Enter the Date of the Reservation (YYYY-MM-DD)"))).toArray();
        if (optionsFlight.length > 0) {
            Flight selectedFlight = (Flight) JOptionPane.showInputDialog(
                    null,
                    "Select a Flight:\n",
                    "Selecting a Flight",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsFlight,
                    optionsFlight[0]);
            if (selectedFlight == null) {
                JOptionPane.showMessageDialog(null, "No Flight selected");
            } else {
                int capacityOfPLane = instanceModel().findCapacityOfPLane(selectedFlight.getId());
                if ((capacityOfPLane) > instanceModel().findTotalReservationsOfAFlight(selectedFlight.getId())) {
                    String seat = JOptionPane.showInputDialog(null, "Enter a number of seat between 1 - " + capacityOfPLane);
                    if (instanceModel().findSeatAvailabilityInSpecificFlight(selectedFlight.getId(), seat) > 0) {
                        JOptionPane.showMessageDialog(null, "This seat is already taken");
                    } else {
                        Object[] optionsPassenger = new PassengerModel().findAll().toArray();
                        Passenger selectedPassenger = (Passenger) JOptionPane.showInputDialog(
                                null,
                                "Select a Passenger:\n",
                                "Selecting a Passenger",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                optionsPassenger,
                                optionsPassenger[0]);
                        if (selectedPassenger == null) {
                            JOptionPane.showMessageDialog(null, "No Passenger selected");
                        } else {
                            System.out.println(instanceModel().insert(new Reservation(selectedFlight.getDepartureDate(), seat, selectedPassenger.getId(), selectedFlight.getId())));
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Max capacity reached, no seats available in this flight");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No Flights available this date");
        }
    }

    public void update() {
        Object[] reservationOptions = instanceModel().findAll().toArray();
        if (reservationOptions.length > 0) {
            Reservation selectedReservation = (Reservation) JOptionPane.showInputDialog(
                    null,
                    "Select a Reservation:\n",
                    "Updating a Reservation",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    reservationOptions,
                    reservationOptions[0]);
            if (selectedReservation == null) {
                JOptionPane.showMessageDialog(null, "No Reservation selected");
            } else {
                Object[] optionsFlight = new FlightModel().findByDate(Date.valueOf(JOptionPane.showInputDialog(null, "Enter the new Date of the Reservation (YYYY-MM-DD)", selectedReservation.getReservationDate()))).toArray();
                if (optionsFlight.length > 0) {
                    Flight selectedFlight = (Flight) JOptionPane.showInputDialog(
                            null,
                            "Select the new Flight:\n",
                            "Updating the Flight",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            optionsFlight,
                            optionsFlight[0]);
                    if (selectedFlight == null) {
                        JOptionPane.showMessageDialog(null, "No Flight selected");
                    } else {
                        int capacityOfPLane = instanceModel().findCapacityOfPLane(selectedFlight.getId());
                        if ((capacityOfPLane) > instanceModel().findTotalReservationsOfAFlight(selectedFlight.getId())) {
                            String seat = JOptionPane.showInputDialog(null, "Enter the new number of seat between 1 - " + capacityOfPLane, selectedReservation.getSeat());

                            if (instanceModel().findSeatAvailabilityInSpecificFlight(selectedFlight.getId(), seat) == 0 || (seat.equals(selectedReservation.getSeat()))) {
                                Object[] optionsPassenger = new PassengerModel().findAll().toArray();
                                Passenger selectedPassenger = (Passenger) JOptionPane.showInputDialog(
                                        null,
                                        "Select the new Passenger:\n",
                                        "Updating the Passenger",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        optionsPassenger,
                                        optionsPassenger[0]);
                                if (selectedPassenger == null) {
                                    JOptionPane.showMessageDialog(null, "No Passenger selected");
                                } else {
                                    selectedReservation.setReservationDate(selectedFlight.getDepartureDate());
                                    selectedReservation.setSeat(seat);
                                    selectedReservation.setIdPassenger(selectedPassenger.getId());
                                    selectedReservation.setIdFlight(selectedFlight.getId());
                                    if (instanceModel().update(selectedReservation)) {
                                        JOptionPane.showMessageDialog(null, "Reservation successfully updated");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Couldn't update the Reservation");
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "This seat is already taken");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Max capacity reached, no seats available in this flight");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No Flights available this date");
                }


            }
        } else {
            JOptionPane.showMessageDialog(null, "No Reservations registered yet");
        }
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

    public void getByFlightId() {
        Object[] flightOptions = new FlightModel().findAll().toArray();
        if (flightOptions.length > 0) {
            Flight selectedFlight = (Flight) JOptionPane.showInputDialog(
                    null,
                    "Select the new Flight:\n",
                    "Updating the Flight",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    flightOptions,
                    flightOptions[0]);
            if (selectedFlight == null) {
                JOptionPane.showMessageDialog(null, "No Flight selected");
            } else {
                StringBuilder list = new StringBuilder("Filtered by Flight: " + selectedFlight.getDestination() + "\n");
                list.append(getAll(instanceModel().findByFlightId(selectedFlight.getId())));
                JOptionPane.showMessageDialog(null, list);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No Flights found");
        }
    }
}