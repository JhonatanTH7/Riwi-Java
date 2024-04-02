package WorkPOO2.Exercise2.Classes.Menus;

import javax.swing.*;

public class MenuExercise2 {
    public String showMenu() {
        return JOptionPane.showInputDialog(null, """
                ===== Menu =====
                                
                1.Add employee
                2.Delete employee
                3.Show employees list
                4.Finish
                                
                Enter an option:
                """);
    }
}
