package WorkLists.Exercise4.Classes;

import javax.swing.*;
import java.util.ArrayList;

public class RemoveCity {
    public void remove(ArrayList<String> itinerary) {
        if (!itinerary.isEmpty()) {
            String selectedCity = JOptionPane.showInputDialog(null, "Ingrese la ciudad a eliminar del itinerario");
            if (itinerary.remove(selectedCity)) {
                JOptionPane.showMessageDialog(null, "Ciudad eliminada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Ciudad no encontrada en el itinerario verifique nuevamente");
            }
        }
    }
}
