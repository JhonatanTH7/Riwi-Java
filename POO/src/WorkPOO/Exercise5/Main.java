package WorkPOO.Exercise5;


import WorkPOO.Exercise5.Classes.Menu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
/*        5. Control de Stock: Crea un sistema para gestionar el stock de productos en
        un almacén. Deberás tener una clase Producto con atributos como id,
        descripción, cantidad en stock. Añade métodos para agregar o quitar
        productos del stock, y para verificar la cantidad actual de un producto.*/
        Menu menu = new Menu();

        String option;
        do {
            option = menu.showMainMenu();
            switch (option) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Caracteres invalidos");
                    break;
            }
        } while (!option.equals("4"));
    }
}
