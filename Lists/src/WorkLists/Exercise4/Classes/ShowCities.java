package WorkLists.Exercise4.Classes;

import javax.swing.*;
import java.util.ArrayList;

public class ShowCities {
    public void show(ArrayList<String> itinerary) {
        if (itinerary.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El itinerario esta vació");
        } else {
            String itineraryList = "=== Lista de ciudades a visitar ===\n\n";
            for (int i = 0; i < itinerary.size(); i++) {
                itineraryList += "* " + itinerary.get(i) + "\n";
            }
            JOptionPane.showMessageDialog(null, itineraryList);
        }
    }
}
