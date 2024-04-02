package WorkPOO2.Exercise1;

import WorkPOO2.Exercise1.Classes.Inventory;
import WorkPOO2.Exercise1.Classes.Menus.MenuExercise1;
import WorkPOO2.Exercise1.Classes.Menus.OptionsExercise1;
import WorkPOO2.Exercise1.Classes.Product;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
/*        Ejercicio 1: Sistema de Control de Inventarios
        Objetivo: Crear un sistema para manejar el inventario de un almacén, aplicando
        encapsulamiento y herencia, y utilizando ArrayList para almacenar los productos.

        Principios de POO aplicados: Encapsulamiento, Herencia.

                Requisitos:

        Clase Producto: Base para todos los productos, con propiedades como id, nombre, y
        precio. Implementa getters y setters para aplicar el encapsulamiento.
        Clase ProductoEspecifico: Hereda de Producto y añade propiedades específicas, como
        categoria o marca.
                Clase Inventario: Utiliza un ArrayList de objetos Producto para gestionar el inventario.
        Implementa métodos para añadir, eliminar, y listar productos, además de buscar productos
        por nombre o categoría.*/
        MenuExercise1 menu = new MenuExercise1();
        OptionsExercise1 options = new OptionsExercise1();
        String option;
        do {
            option = menu.showMenu();
            options.mainOptions(option);
        } while (!option.equals("5"));
    }
}
