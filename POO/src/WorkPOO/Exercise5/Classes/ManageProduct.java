package WorkPOO.Exercise5.Classes;

import javax.swing.*;

public class ManageProduct {
    public void Manage() {
        Menu menu = new Menu();

        String option;
        do {
            option = menu.showProductMenu();
            switch (option) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Caracteres invalidos");
                    break;
            }
        } while (!option.equals("4"));
    }
}
