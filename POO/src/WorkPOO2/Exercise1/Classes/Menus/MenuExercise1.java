package WorkPOO2.Exercise1.Classes.Menus;

import javax.swing.*;

public class MenuExercise1 {
    public String showMenu() {
        return JOptionPane.showInputDialog(null, """
                ===== Menu =====
                                
                1.Add product
                2.Delete product
                3. Search product by name
                4.Show inventory
                5.Finish
                                
                Enter an option:
                """);
    }
}
