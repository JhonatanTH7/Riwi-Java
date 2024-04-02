package WorkPOO2.Exercise1.Classes;

import javax.swing.*;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> productsList;

    public Inventory() {
        this.productsList = new ArrayList<>();
    }


    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<Product> productsList) {
        this.productsList = productsList;
    }

    public void addProduct(Product product) {
        this.productsList.add(product);
    }

    public boolean deleteProduct(int id) {
        return this.productsList.removeIf(product -> product.getId() == id);
    }

    public void showProducts() {
        if (this.productsList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "The inventory is empty");
        } else {
            String listToConcat = "======== Inventory ========\n\n";
            for (Product product : this.productsList) {
                listToConcat += "ID: " + product.getId() + " Name: " + product.getName() + " Price: " + product.getPrice() + " Branch: " + product.getBrand() + " Category: " + product.getCategory() + "\n";
            }
            JOptionPane.showMessageDialog(null, listToConcat);
        }
    }

    public Product searchByName(String searchedName) {
        for (Product product : this.productsList) {
            if (product.getName().equalsIgnoreCase(searchedName)) {
                return product;
            }
        }
        return null;
    }
}
