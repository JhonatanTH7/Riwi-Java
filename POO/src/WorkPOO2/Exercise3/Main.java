package WorkPOO2.Exercise3;

import WorkPOO2.Exercise3.Classes.Course;
import WorkPOO2.Exercise3.Classes.Menus.MenusExercise3;
import WorkPOO2.Exercise3.Classes.Menus.OptionsExercise3;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
/*        Ejercicio 3: Sistema de Gestión de Cursos
        Objetivo: Implementar un sistema para gestionar cursos y estudiantes, aplicando
        abstracción y polimorfismo, y utilizando ArrayList para manejar las inscripciones.

        Principios de POO aplicados: Abstracción, Polimorfismo.

            Requisitos:

        Clase Curso: Con propiedades como código, nombre, y listaEstudiantes, donde
        listaEstudiantes es un ArrayList de objetos Estudiante.
        Clase Estudiante: Con propiedades como id, nombre, y email.
        Clase GestionCursos: Encargada de administrar los cursos, incluyendo métodos para
        agregar cursos, inscribir estudiantes en cursos y listar estudiantes inscritos en un curso
        específico.*/
        MenusExercise3 menu = new MenusExercise3();
        OptionsExercise3 options = new OptionsExercise3();
        String option;
        do {
            option = menu.showMainMenu();
            options.mainOptions(option);
        } while (!option.equals("3"));
    }
}
