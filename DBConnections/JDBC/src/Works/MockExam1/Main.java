package Works.MockExam1;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Menus menus = new Menus();
        String option;
        do {
            option = JOptionPane.showInputDialog(null, """

                           MAIN MENU

                    1. Manage Specialties
                    2. Manage Physicians
                    3. Manage Patients
                    4. Manage Appointments
                    5. Exit

                    Choose an option:

                    """);
            switch (option) {
                case "1":
                    menus.specialtyMenu();
                    break;
                case "2":
                    menus.physicianMenu();
                    break;
                case "3":
                    menus.patientMenu();
                    break;
                case "4":
                    menus.appointmentMenu();
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