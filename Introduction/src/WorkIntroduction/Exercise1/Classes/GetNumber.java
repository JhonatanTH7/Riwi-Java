package WorkIntroduction.Exercise1.Classes;

import javax.swing.*;

public class GetNumber {
    public double get(String msg) {
        while (true) {
            try {
                return Double.parseDouble(JOptionPane.showInputDialog(null, msg));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Caracteres no validos, ingrese un número entero");
            }
        }
    }
}
