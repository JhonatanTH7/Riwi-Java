package WorkPOO2.Exercise1.Classes.Menus;

import WorkPOO2.Exercise1.Classes.Inventory;
import WorkPOO2.Exercise1.Classes.Product;
import WorkPOO2.Exercise1.Classes.SpecificProduct;

import javax.swing.*;

public class OptionsExercise1 {
    public Inventory inventory = new Inventory();
    private static int id = 0;

    public void mainOptions(String option) {
        switch (option) {
            case "1":
                String name = JOptionPane.showInputDialog(null, "Enter the product's name");
                double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the product's name"));
                String category = JOptionPane.showInputDialog(null, "Enter the product category");
                String brand = JOptionPane.showInputDialog(null, "Enter the product brand");
                inventory.addProduct(new SpecificProduct(id, name, price, category, brand));
                id++;
                JOptionPane.showMessageDialog(null, "Product added successfully");
                break;
            case "2":
                inventory.showProducts();
                int deletedProduct = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the id of the product that you want to delete"));
                if (inventory.deleteProduct(deletedProduct)) {
                    JOptionPane.showMessageDialog(null, "Product deleted successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Product not found");
                }
                break;
            case "3":
                String searchedProduct = JOptionPane.showInputDialog(null, "Enter the name of the product that you want to search for");
                Product product = inventory.searchByName(searchedProduct);
                if (product != null) {
                    JOptionPane.showMessageDialog(null, "ID: " + product.getId() + " Name: " + product.getName() + " Price: " + product.getPrice() + " Branch: " + product.getBrand() + " Category: " + product.getCategory());
                } else {
                    JOptionPane.showMessageDialog(null, "Product not found");
                }
                break;
            case "4":
                inventory.showProducts();
                break;
            case "5":
                JOptionPane.showMessageDialog(null, "See you next time!!!");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Not a valid option");
                break;
        }
    }
}
