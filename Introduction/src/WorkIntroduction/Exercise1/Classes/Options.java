package WorkIntroduction.Exercise1.Classes;

import WorkIntroduction.Exercise1.Classes.Operations.Division;
import WorkIntroduction.Exercise1.Classes.Operations.Multiplication;
import WorkIntroduction.Exercise1.Classes.Operations.Subtraction;
import WorkIntroduction.Exercise1.Classes.Operations.Sum;

import javax.swing.*;

public class Options {

    public void cases(String option) {
        switch (option) {
            case "1":
                Sum sum = new Sum();
                sum.sumNow();
                break;
            case "2":
                Subtraction subtraction = new Subtraction();
                subtraction.subtractNow();
                break;
            case "3":
                Multiplication multiplication = new Multiplication();
                multiplication.multiplicateNow();
                break;
            case "4":
                Division division = new Division();
                division.divideNow();
                break;
            case "5":
                JOptionPane.showMessageDialog(null, "Until next time");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción invalida");
        }
    }
}
