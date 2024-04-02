package WorkPOO.Exercise5.Classes.obj;

import javax.swing.*;

public class Product {
    private String drescription;

    private int stock;

    private int id;

    public Product(String drescription, int stock, int id) {
        this.drescription = drescription;
        this.stock = stock;
        this.id = id;
    }

    public String getDrescription() {
        return drescription;
    }

    public void setDrescription(String drescription) {
        this.drescription = drescription;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addProducts(int addedProducts) {
        this.stock += addedProducts;
        JOptionPane.showMessageDialog(null, "Productos agregados correctamente");
    }

    public void removeProducts(int removedProducts) {
        if (removedProducts > this.stock) {
            JOptionPane.showMessageDialog(null, "La cantidad a eliminar es más grande que el stock actual, por favor verificar los valores ingresados");
        } else {
            this.stock += removedProducts;
            JOptionPane.showMessageDialog(null, "Productos eliminados correctamente, stock actualizado: " + this.stock);
        }
    }

    public void actualStock() {
        JOptionPane.showMessageDialog(null, "Stock actual del producto: " + this.stock);
    }

    @Override
    public String toString() {
        return "Product{" +
                "drescription='" + drescription + '\'' +
                ", stock=" + stock +
                ", id=" + id +
                '}';
    }
}
