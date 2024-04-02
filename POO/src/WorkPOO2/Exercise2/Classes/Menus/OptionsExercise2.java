package WorkPOO2.Exercise2.Classes.Menus;

import WorkPOO2.Exercise2.Classes.EmployeeManagement;

import javax.swing.*;

public class OptionsExercise2 {
    public EmployeeManagement employeeManagement = new EmployeeManagement();

    public void mainOptions(String option) {
        switch (option) {
            case "1":
                employeeManagement.addEmployee();
                break;
            case "2":
                employeeManagement.deleteEmployee();
                break;
            case "3":
                employeeManagement.showEmployees();
                break;
            case "4":
                JOptionPane.showMessageDialog(null, "See you next time!!!");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Not a valid option");
                break;
        }
    }
}
