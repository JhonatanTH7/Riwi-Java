package Works.MockExam1;

import Works.MockExam1.controller.PhysicianController;
import Works.MockExam1.controller.SpecialtyController;

import javax.swing.*;

public class Menus {
    public void specialtyMenu() {
        SpecialtyController objSpecialtyController = new SpecialtyController();
        String option2 = "";
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
                    objSpecialtyController.getAll();
                    break;
                case "2":
                    objSpecialtyController.add();
                    break;
                case "3":
                    objSpecialtyController.update();
                    break;
                case "4":
                    objSpecialtyController.delete();
                    break;
                case "5":
                    PhysicianController objPhysicianController = new PhysicianController();
                    objPhysicianController.getPhysiciansBySpecialty();
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

    public void physicianMenu() {
        PhysicianController objPhysicianController = new PhysicianController();
        String option2 = "";
        do {
            option2 = JOptionPane.showInputDialog(null, """

                        PHYSICIANS MENU

                    1. Show all Physicians
                    2. Add Physician
                    3. Update Physician
                    4. Delete Physician
                    5. Show all Physicians in a Specialty
                    6. Exit

                    Choose an option:

                    """);
            switch (option2) {
                case "1":
                    objPhysicianController.getAll();
                    break;
                case "2":
                    objPhysicianController.add();
                    break;
                case "3":
                    objPhysicianController.update();
                    break;
                case "4":
                    objPhysicianController.delete();
                    break;
                case "5":
                    objPhysicianController.getPhysiciansBySpecialty();
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

    public void patientMenu() {
        String option2 = "";
        do {
            option2 = JOptionPane.showInputDialog(null, """

                        PHYSICIANS MENU

                    1. Show all Physicians
                    2. Add Physician
                    3. Update Physician
                    4. Delete Physician
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

    public void appointmentMenu() {
        String option2 = "";
        do {
            option2 = JOptionPane.showInputDialog(null, """

                        PHYSICIANS MENU

                    1. Show all Physicians
                    2. Add Physician
                    3. Update Physician
                    4. Delete Physician
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
}
