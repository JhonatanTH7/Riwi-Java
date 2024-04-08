package Works.MockExam2;


import Works.MockExam2.controller.FlightController;
import Works.MockExam2.controller.PassengerController;
import Works.MockExam2.controller.PlaneController;
import Works.MockExam2.controller.ReservationController;

import javax.swing.*;

public class Menus {
    public void planeMenu() {
        PlaneController planeController = new PlaneController();
        String option2;
        do {
            option2 = JOptionPane.showInputDialog(null, """

                        PLANES MENU

                    1. Show all Planes
                    2. Add Plane
                    3. Update Plane
                    4. Delete Plane
                    5. Exit

                    Choose an option:

                    """);
            switch (option2) {
                case "1":
                    planeController.getAll();
                    break;
                case "2":
                    planeController.add();
                    break;
                case "3":
                    planeController.update();
                    break;
                case "4":
                    planeController.delete();
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Going back to main menu");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Not a valid option");
                    break;
            }
        } while (!option2.equals("5"));
    }

    public void flightMenu() {
        FlightController flightController = new FlightController();
        String option2;
        do {
            option2 = JOptionPane.showInputDialog(null, """

                        FLIGHTS MENU

                    1. Show all Flights
                    2. Add Flight
                    3. Update Flight
                    4. Delete Flight
                    5. Filter Flights by Destination
                    6. Exit

                    Choose an option:

                    """);
            switch (option2) {
                case "1":
                    flightController.getAll();
                    break;
                case "2":
                    flightController.add();
                    break;
                case "3":
                    flightController.update();
                    break;
                case "4":
                    flightController.delete();
                    break;
                case "5":
                    flightController.getByDestination();
                    break;
                case "6":
                    JOptionPane.showMessageDialog(null, "Going back to main menu");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Not a valid option");
                    break;
            }
        } while (!option2.equals("6"));
    }

    public void passengerMenu() {
        PassengerController passengerController = new PassengerController();
        String option2;
        do {
            option2 = JOptionPane.showInputDialog(null, """

                        PASSENGERS MENU

                    1. Show all Passengers
                    2. Add Passenger
                    3. Update Passenger
                    4. Delete Passenger
                    5. Filter Passengers by Name
                    6. Exit

                    Choose an option:

                    """);
            switch (option2) {
                case "1":
                    passengerController.getAll();
                    break;
                case "2":
                    passengerController.add();
                    break;
                case "3":
                    passengerController.update();
                    break;
                case "5":
                    passengerController.getByName();
                    break;
                case "6":
                    JOptionPane.showMessageDialog(null, "Going back to main menu");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Not a valid option");
                    break;
            }
        } while (!option2.equals("6"));
    }

    public void reservationMenu() {
        ReservationController reservationController = new ReservationController();
        String option2;
        do {
            option2 = JOptionPane.showInputDialog(null, """

                        RESERVATIONS MENU

                    1. Show all Reservations
                    2. Add Reservation
                    3. Update Reservation
                    4. Delete Reservation
                    5. Filter by Flight
                    6. Exit

                    Choose an option:

                    """);
            switch (option2) {
                case "1":
                    reservationController.getAll();
                    break;
                case "2":
                    reservationController.add();
                    break;
                case "3":
                    reservationController.update();
                    break;
                case "4":
                    reservationController.delete();
                    break;
                case "5":
                    reservationController.getByFlightId();
                    break;
                case "6":
                    JOptionPane.showMessageDialog(null, "Going back to main menu");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Not a valid option");
                    break;
            }
        } while (!option2.equals("6"));
    }
}
