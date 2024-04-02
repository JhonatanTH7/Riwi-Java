package WorkLists.Exercise4.Classes;

import javax.swing.*;


public class MenuExercise4 {
    public int mostrar() {

        return Integer.parseInt(JOptionPane.showInputDialog(null, "=== Itinerario ===\n\n" +
                "1. Añadir ciudad al itinerario.\n" +
                "2. Remover ciudad del itinerario.\n" +
                "3. Mostrar la lista completa de ciudades a visitar.\n" +
                "4. Calcular la distancia total del viaje.\n" +
                "5. Salir\n\n" +
                "Ingrese una opción\n"));
    }
}
