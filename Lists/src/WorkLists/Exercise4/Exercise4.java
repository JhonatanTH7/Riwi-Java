package WorkLists.Exercise4;

import WorkLists.Exercise4.Classes.AddCity;
import WorkLists.Exercise4.Classes.MenuExercise4;
import WorkLists.Exercise4.Classes.RemoveCity;
import WorkLists.Exercise4.Classes.ShowCities;

import javax.swing.*;
import java.util.ArrayList;

public class Exercise4 {
    public static void main(String[] args) {
/*        4. Planificador de Viajes: Escribe un programa para ayudar a planificar viajes por
        carretera. Los usuarios pueden ingresar varias ciudades que planean visitar en
        orden. Utiliza un arreglo de String para almacenar las ciudades. El programa debe
        ser capaz de:
        - Añadir y remover ciudades del itinerario.
        - Mostrar la lista completa de ciudades a visitar.
        - (Opcional) Calcular la distancia total del viaje asumiendo distancias ficticias entre
            ciudades consecutivas.*/
        ShowCities Show = new ShowCities();
        RemoveCity Remove = new RemoveCity();
        AddCity Add = new AddCity();
        MenuExercise4 Menu = new MenuExercise4();
        ArrayList<String> itinerary = new ArrayList<>();
        int option = 0;
        do {
            try {
                option = Menu.mostrar();
                switch (option) {
                    case 1:
                        itinerary = Add.add(itinerary);
                        break;
                    case 2:
                        Show.show(itinerary);
                        Remove.remove(itinerary);
                        break;
                    case 3:
                        Show.show(itinerary);
                        break;
                    case 4:
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Caracteres invalidos");
            }
        } while (option != 5);
    }
}
