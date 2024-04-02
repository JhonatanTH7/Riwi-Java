package WorkLists.Exercise5.Classes;

import javax.swing.*;

public class MenuExercise5 {
    public int mostrar() {

        return Integer.parseInt(JOptionPane.showInputDialog(null, "=== PlayList ===\n\n" +
                "1. Agregar canción\n" +
                "2. Remover canción\n" +
                "3. Mostrar la canción actual y siguientes en la lista\n" +
                "4. Saltar a la siguiente canción\n" +
                "5. Salir\n\n" +
                "Ingrese una opción\n"));
    }
}
