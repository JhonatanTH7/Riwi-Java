package WorkPOO.Exercise4.Classes;

public class Rectangle extends Figure {
    private double length;

    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }


    @Override
    public Double calculateArea() {
        return this.width * this.length;
    }
}
