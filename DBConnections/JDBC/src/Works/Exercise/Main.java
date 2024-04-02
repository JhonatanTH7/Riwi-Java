package Works.Exercise;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Menus menus = new Menus();
        String option = "";
        do {
            option = JOptionPane.showInputDialog(null, """

                            MENU

                    1. Manage Authors
                    2. Manage Books
                    3. Exit

                    Choose an option:

                    """);
            switch (option) {
                case "1":
                    menus.authorMenu();
                    break;
                case "2":
                    menus.bookMenu();
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, "See you next time!!!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Not a valid option");
            }
        } while (!option.equals("3"));
    }
}
