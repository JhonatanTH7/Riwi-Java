package WorkPOO2.Exercise1.Classes;

public class SpecificProduct extends Product {
    /*    Clase ProductoEspecifico: Hereda de Producto y añade propiedades específicas, como
        categoria o marca.*/
    private String brand;
    private String category;

    public SpecificProduct(int id, String name, double price, String category, String brand) {
        super(id, name, price);
        this.brand = brand;
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SpecificProduct{" + "brand='" + brand + '\'' + ", category='" + category + '\'' + '}';
    }
}
