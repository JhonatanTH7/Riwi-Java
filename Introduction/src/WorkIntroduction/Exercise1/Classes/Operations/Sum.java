package WorkIntroduction.Exercise1.Classes.Operations;

import WorkIntroduction.Exercise1.Classes.GetNumber;
import WorkIntroduction.Exercise1.Classes.Options;

import javax.swing.*;

public class Sum {
    public void sumNow() {
        GetNumber getNumber = new GetNumber();
        double nr1 = getNumber.get("Enter the first number");
        double nr2 = getNumber.get("Enter the second number");
        JOptionPane.showMessageDialog(null, nr1 + " + " + nr2 + " = " + (nr1 + nr2));
    }
}
