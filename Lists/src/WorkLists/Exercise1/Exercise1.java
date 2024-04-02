package WorkLists.Exercise1;

import Utilities.ImprimirListas;

import javax.swing.*;

public class Exercise1 {
    public static void main(String[] args) {
//      1. Calculadora de Promedios: Escribe un programa que utilice un array de tipo
//      double para almacenar las calificaciones finales de 10 estudiantes en un curso. El
//      programa debe calcular y mostrar el promedio de estas calificaciones.
        ImprimirListas IL = new ImprimirListas();
        double[] calculadoraPromedios = new double[3];
        double acumuladorNotas = 0.0;
        for (int i = 0; i < calculadoraPromedios.length; i++) {
            try {
                double nota = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la nota de el estudiante Nro. " + (i + 1)));
                calculadoraPromedios[i] = nota;
                acumuladorNotas += nota;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nota no valida, ingresala nuevamente");
                i--;
            }
        }
        JOptionPane.showMessageDialog(null, "El promedio de notas es: " + (acumuladorNotas / (calculadoraPromedios.length)));
        IL.imprimirListaDouble(calculadoraPromedios);
    }
}