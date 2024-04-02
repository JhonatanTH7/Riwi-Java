package WorkPOO.Exercise5.Classes;

import javax.swing.*;

public class Menu {
    public String showMainMenu() {
        return JOptionPane.showInputDialog(null, """
                           === Menú principal  ===

                1. Agregar nuevo producto
                2. Eliminar producto
                3. Administrar stock de producto existente
                4. Finalizar

                Ingrese una opción
                """);
    }

    public String showProductMenu() {
        return JOptionPane.showInputDialog(null, """
                 === Administrando producto  ===

                1. Agregar productos al stock
                2. Quitar productos del stock
                3. Mostrar cantidad en stock
                4. Volver al menu principal

                Ingrese una opción
                """);
    }
}
