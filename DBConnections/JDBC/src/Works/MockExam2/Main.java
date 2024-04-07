package Works.MockExam2;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Menus menus = new Menus();
        String option;
        do {
            option = JOptionPane.showInputDialog(null, """

                           MAIN MENU

                    1. Manage Planes
                    2. Manage Flights
                    3. Manage Passengers
                    4. Manage Reservations
                    5. Exit

                    Choose an option:

                    """);
            switch (option) {
                case "1":
                    menus.planeMenu();
                    break;
                case "2":
                    menus.flightMenu();
                    break;
                case "3":
                    menus.passengerMenu();
                    break;
                case "4":
                    menus.reservationMenu();
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "See you next time!!!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Not a valid option");
            }
        } while (!option.equals("5"));
    }
}
