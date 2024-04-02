package WorkLists.Exercise2;

import Utilities.ImprimirListas;

import javax.swing.*;

public class Exercise2 {
    public static void main(String[] args) {
//      2. Buscador de Número Mayor y Menor: Utiliza un array de int para almacenar 5
//      números enteros ingresados por el usuario (puedes usar la clase Scanner para la
//      entrada de datos). El programa debe encontrar y mostrar el número mayor y el
//      menor de la lista.
        ImprimirListas IL = new ImprimirListas();
        int[] arrayNumbers = new int[5];
        arrayNumbers = readNumbers(arrayNumbers);
        IL.imprimirListaInt(arrayNumbers);
        highestNumber(arrayNumbers);
        lowestNumber(arrayNumbers);
    }

    public static int[] readNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresar el numero"));
        }
        return array;
    }

    public static void highestNumber(int[] array) {
        int highest = -1;
        for (int element : array) {
            if (element > highest) {
                highest = element;
            }
        }
        JOptionPane.showMessageDialog(null, "El número más grande es: " + highest);
    }

    public static void lowestNumber(int[] array) {
        int lowest = 9999999;
        for (int element : array) {
            if (element < lowest) {
                lowest = element;
            }
        }
        JOptionPane.showMessageDialog(null, "El número más pequeño es: " + lowest);
    }
}
