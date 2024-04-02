package WorkLists.Exercise3;

import WorkLists.Exercise3.Classes.MenuExercise3;
import Utilities.ImprimirMatrices;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
//      3. Sistema de Reservas: Desarrolla un programa para un teatro para gestionar las
//      reservas de asientos. El teatro tiene 5 filas con 10 asientos cada una. Utiliza un
//      arreglo bidimensional de boolean donde true representa un asiento ocupado y false
//      uno disponible. El sistema debe permitir:
//      - Reservar y cancelar asientos.
//      - Mostrar los asientos disponibles.
//      - Contabilizar el total de asientos ocupados y disponibles.
        MenuExercise3 menu = new MenuExercise3();
        boolean[][] listaAsientos = new boolean[5][10];
        Scanner read = new Scanner(System.in);
        String option;
        do {
            menu.mostrar();
            option = read.next();
            switch (option) {
                case "1":
                    System.out.println("Ingrese la fila (1-5)");
                    int fila = read.nextInt() - 1;
                    System.out.println("Ingrese el asiento (1-10)");
                    int asiento = read.nextInt() - 1;
                    if (!listaAsientos[fila][asiento]) {
                        listaAsientos[fila][asiento] = true;
                        System.out.println("Asiento reservado correctamente");
                    } else {
                        System.out.println("Oops! Este asiento ya se encuentra reservado");
                    }
                    break;
                case "2":
                    System.out.println("Ingrese la fila (1-5)");
                    fila = read.nextInt() - 1;
                    System.out.println("Ingrese el asiento (1-10)");
                    asiento = read.nextInt() - 1;
                    if (listaAsientos[fila][asiento]) {
                        listaAsientos[fila][asiento] = false;
                        System.out.println("Reserva de asiento cancelada correctamente");
                    } else {
                        System.out.println("Este asiento ya esta libre");
                    }
                    break;
                case "3":
                    ImprimirMatrices IMH = new ImprimirMatrices();
                    IMH.imprimirMatrizBoolean(listaAsientos);
                    break;
                case "4":
                    int ocupados = 0, disponibles = 0;
                    for (boolean[] filaAsiento : listaAsientos) {
                        for (boolean disponibilidadAsiento : filaAsiento) {
                            if (!disponibilidadAsiento) {
                                disponibles++;
                            } else {
                                ocupados++;
                            }
                        }
                    }
                    System.out.println("Asientos disponibles: " + disponibles + "     Asientos ocupados: " + ocupados);
                    break;
            }
            if (!option.equals("5")) {
                read.nextLine();
                System.out.println(" ");
                System.out.println("Presione enter para volver al menú");
                read.nextLine();
            }
            System.out.println("Hasta la proxima!");
        } while (!option.equals("5"));

    }
}