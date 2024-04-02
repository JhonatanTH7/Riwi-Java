package WorkPOO.Exercise4;

import WorkPOO.Exercise4.Classes.Circle;
import WorkPOO.Exercise4.Classes.Rectangle;
import WorkPOO.Exercise4.Classes.Square;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
/*        4. Figuras Geométricas: Crea una clase abstracta Figura con un método
        abstracto calcularArea(). Luego, extiende esta clase con algunas figuras
        específicas como Círculo, Rectangulo, y Cuadrado, implementando el
        cálculo del área en cada una. Utiliza el concepto de herencia y polimorfismo.*/
        Circle objCircle = new Circle(10);
        JOptionPane.showMessageDialog(null, "Area del circulo: " + objCircle.calculateArea());

        Rectangle objRectangle = new Rectangle(20, 40);
        JOptionPane.showMessageDialog(null, "Area del rectangulo: " + objRectangle.calculateArea());

        Square objSquare = new Square(40);
        JOptionPane.showMessageDialog(null, "Area del rectangulo: " + objSquare.calculateArea());
    }
}
