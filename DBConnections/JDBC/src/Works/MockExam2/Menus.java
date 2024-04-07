package Works.MockExam2;


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
                    break;
                case "2":
                    break;
                case "3":
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
        String option2;
        do {
            option2 = JOptionPane.showInputDialog(null, """

                        SPECIALTIES MENU

                    1. Show all Specialties
                    2. Add Specialty
                    3. Update Specialty
                    4. Delete Specialty
                    5. Show all Physicians in a Specialty
                    6. Exit

                    Choose an option:

                    """);
            switch (option2) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
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
        String option2;
        do {
            option2 = JOptionPane.showInputDialog(null, """

                        SPECIALTIES MENU

                    1. Show all Specialties
                    2. Add Specialty
                    3. Update Specialty
                    4. Delete Specialty
                    5. Show all Physicians in a Specialty
                    6. Exit

                    Choose an option:

                    """);
            switch (option2) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
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

                        SPECIALTIES MENU

                    1. Show all Specialties
                    2. Add Specialty
                    3. Update Specialty
                    4. Delete Specialty
                    5. Show all Physicians in a Specialty
                    6. Exit

                    Choose an option:

                    """);
            switch (option2) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    reservationController.delete();
                    break;
                case "5":
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
