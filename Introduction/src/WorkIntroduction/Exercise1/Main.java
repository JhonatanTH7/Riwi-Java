package WorkIntroduction.Exercise1;

import WorkIntroduction.Exercise1.Classes.MenuExercise1;
import WorkIntroduction.Exercise1.Classes.Options;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        MenuExercise1 menu = new MenuExercise1();
        Options options = new Options();
        JOptionPane.showMessageDialog(null, "==== WELCOME!!! ====");
        String option;
        do {
            option = menu.show();
            options.cases(option);
        } while (!option.equals("5"));
    }
}
