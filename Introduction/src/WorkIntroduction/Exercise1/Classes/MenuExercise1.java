package WorkIntroduction.Exercise1.Classes;

import javax.swing.*;

public class MenuExercise1 {

    public String show() {

        return JOptionPane.showInputDialog(null, "=== Calculator ===\n\n" +
                "1. Sum\n" +
                "2. Subtraction\n" +
                "3. Multiplication\n" +
                "4. Division\n" +
                "5. Finish\n\n" +
                "Choose an option\n");
    }
}
