package WorkPOO2.Exercise2.Classes;

import javax.swing.*;
import java.util.ArrayList;

public class EmployeeManagement {
    private ArrayList<Employee> EmployeesList;
    private static int idEmployee = 0;

    public EmployeeManagement() {
        this.EmployeesList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeesList() {
        return EmployeesList;
    }

    public void setEmployeesList(ArrayList<Employee> employeesList) {
        EmployeesList = employeesList;
    }

    public void addEmployee() {
        try {
            JOptionPane.showMessageDialog(null, "Adding employee");
            String name = JOptionPane.showInputDialog(null, "Enter the employee's name");
            int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the employee's age"));
            String cc = JOptionPane.showInputDialog(null, "Enter the employee's identification");
            double salary = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the employee's salary"));
            String[] options = {"Temporal employee", "Permanent employee"};
            String type = (String) JOptionPane.showInputDialog(
                    null,
                    "Select an option:",
                    "Choosing a type of employee",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (type != null) {
                if (type.equals("Temporal employee")) {
                    TemporalEmployee temporalEmployee = new TemporalEmployee(name, age, cc, idEmployee, salary, type);
                    this.EmployeesList.add(temporalEmployee);
                } else {
                    PermanentEmployee permanentEmployee = new PermanentEmployee(name, age, cc, idEmployee, salary, type);
                    this.EmployeesList.add(permanentEmployee);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No option selected");
            }

            /*this.EmployeesList.add(new Employee(name, age, cc, idEmployee, salary));*/
            idEmployee++;
            JOptionPane.showMessageDialog(null, "Employee added successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Not a valid option");
        }
    }

    public void deleteEmployee() {
        try {
            showEmployees();
            JOptionPane.showMessageDialog(null, "Deleting employee");
            int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the id of the employee that you want to delete"));
            if (EmployeesList.removeIf(employee -> employee.getIdEmployee() == id)) {
                JOptionPane.showMessageDialog(null, "Employee deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null, "The id does not match any current employee");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Not a valid option");
        }
    }

    public void showEmployees() {
        String concatList = "===== Employees list =====\n\n";
        for (Employee employee : EmployeesList) {
            concatList += "- ID:" + employee.getIdEmployee() + " Name: " + employee.getName() + " CC: " + employee.getCC() + " Salary: " + employee.getSalary() + " Age: " + employee.getAge() + " Tpe: " + employee.getType() + "\n";
            ;
        }
        JOptionPane.showMessageDialog(null, concatList);
    }
}
