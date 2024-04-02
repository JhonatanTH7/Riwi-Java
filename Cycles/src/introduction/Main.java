package introduction;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //Punto1
        int contador = 0, sumaTotal = 0;
        while (contador < 101) {
            sumaTotal += contador;
            contador++;
        }
        System.out.println(sumaTotal);

        //Punto2
        for (int i = 1; i < 11; i++) {
            System.out.println("\n Tablas del " + i);
            for (int j = 1; j < 11; j++) {
                System.out.println(i + "x" + j + " = " + (i * j) + " ");
            }
        }

        //Punto3
        String option;
        double saldo = 0.0;
        boolean controlMenu = true;
        do {
            option = JOptionPane.showInputDialog(null, "\n \n Menú de opciones \n\n" +
                    "1. Ver saldo\n" +
                    "2. Depositar dinero\n" +
                    "3. Retirar\n" +
                    "4. Salir\n\n" +
                    "Ingrese una opción: ");

            switch (option) {
                case "1":
                    JOptionPane.showMessageDialog(null, "Tu saldo hasta el momento es: $" + saldo);
                    break;
                case "2":
                    try {
                        double deposito = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor a depositar"));
                        if (deposito > 0) {
                            saldo += deposito;
                            JOptionPane.showMessageDialog(null, "Deposito realizado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Deposito cancelado, ingrese una valor mayor a cero");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "oops, ocurrio un error...tu saldo no fue despositado, " +
                                "los caracteres ingresados no son validos");
                    }
                    ;
                    break;
                case "3":
                    try {
                        double retiro = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor a retirar"));
                        if (retiro > saldo) {
                            JOptionPane.showMessageDialog(null, "No tienes suficiente saldo para realizar este retiro - Saldo: $" + saldo);
                        } else {
                            saldo -= retiro;
                            JOptionPane.showMessageDialog(null, "Retiro realizado correctamente" +
                                    "tu nuevo saldo es: $" + saldo);
                        }


                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "oops, ocurrio un error...el saldo no fue debitado de tu cuenta, " +
                                "los caracteres ingresados no son validos");
                    }
                    ;
                    break;
                case "4":
                    controlMenu = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "La opción ingresada no es valida, ingresela nuevamente");
                    break;
            }
        } while (controlMenu);

        //Primos
        int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número a verificar si es primo"));

    }
}
