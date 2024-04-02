package WorkIntroduction.Exercise1.Classes.Operations;

import WorkIntroduction.Exercise1.Classes.GetNumber;

import javax.swing.*;

public class Division {
    public void divideNow() {
        GetNumber getNumber = new GetNumber();
        double nr1 = getNumber.get("Enter the first number");
        double nr2;
        while (true) {
            nr2 = getNumber.get("Enter the second number");
            if (nr2 != 0) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "El denominador debe ser diferente de cero");
            }
        }
        JOptionPane.showMessageDialog(null, nr1 + " / " + nr2 + " = " + (nr1 / nr2));
    }
}
