package Introduction;

import Introduction.controller.CoderController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CoderController objCoderController = new CoderController();
        String option = "";
        do {
            option = JOptionPane.showInputDialog(null, """

                    MENU

                    1. Show all Coders
                    2. Add Coder
                    3. Update Coder
                    4. Delete Coder
                    5. Get Coder by name
                    6. Exit

                    Choose an option:

                    """);
            switch (option) {
                case "1":
                    // Show Coders
                    objCoderController.getAll();
                    break;
                case "2":
                    // Add Coder
                    objCoderController.create();
                    break;
                case "3":
                    // Update Coder
                    objCoderController.update();
                    break;
                case "4":
                    // Delete Coder
                    objCoderController.delete();
                    break;
                case "5":
                    // Filter Coder by name
                    objCoderController.getByName();
                    break;
                case "6":
                    JOptionPane.showMessageDialog(null, "See you next time!!!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Not a valid option, try again");
                    break;
            }
        } while (!option.equals("6"));
    }
}
