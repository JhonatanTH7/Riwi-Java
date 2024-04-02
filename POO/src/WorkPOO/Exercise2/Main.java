package WorkPOO.Exercise2;

import WorkPOO.Exercise2.Classes.Employee;

public class Main {
    public static void main(String[] args) {
/*        2. Sistema de Gestión de Empleados: Diseña un sistema donde puedas
        gestionar empleados utilizando la POO. Crea una clase Empleado con
        atributos como nombre, posición, salario y id. Implementa métodos para
        obtener y modificar estos atributos, además de un método para aumentar el
        salario por un porcentaje dado.*/
        Employee employee = new Employee("Jhonatan", "Aux. Sistemas", 500.0, 1);
        System.out.println(employee.getSalary());
        employee.raiseSalary(15);
        System.out.println(employee.getSalary());
    }
}
