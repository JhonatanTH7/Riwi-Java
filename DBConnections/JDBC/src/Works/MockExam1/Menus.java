package Works.MockExam1;

import Works.MockExam1.controller.AppointmentController;
import Works.MockExam1.controller.PatientController;
import Works.MockExam1.controller.PhysicianController;
import Works.MockExam1.controller.SpecialtyController;

import javax.swing.*;

public class Menus {
    public void specialtyMenu() {
        SpecialtyController objSpecialtyController = new SpecialtyController();
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
        String option2;
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
        PatientController objPatientController = new PatientController();
        String option2;
        do {
            option2 = JOptionPane.showInputDialog(null, """

                        PATIENTS MENU

                    1. Show all Patients
                    2. Add Patient
                    3. Update Patient
                    4. Delete Patient
                    5. Search Patient by identity document
                    6. Exit

                    Choose an option:

                    """);
            switch (option2) {
                case "1":
                    objPatientController.getAll();
                    break;
                case "2":
                    objPatientController.add();
                    break;
                case "3":
                    objPatientController.update();
                    break;
                case "4":
                    objPatientController.delete();
                    break;
                case "5":
                    objPatientController.getByIdentityDocument();
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
        AppointmentController objAppointmentController = new AppointmentController();
        String option2;
        do {
            option2 = JOptionPane.showInputDialog(null, """

                        APPOINTMENTS MENU

                    1. Show all Appointments
                    2. Add Appointment
                    3. Update Appointment
                    4. Delete Appointment
                    5. Search Appointments by Date
                    6. Exit

                    Choose an option:

                    """);
            switch (option2) {
                case "1":
                    objAppointmentController.getAll();
                    break;
                case "2":
                    objAppointmentController.add();
                    break;
                case "3":
                    objAppointmentController.update();
                    break;
                case "4":
                    objAppointmentController.delete();
                    break;
                case "5":
                    objAppointmentController.getByDate();
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
