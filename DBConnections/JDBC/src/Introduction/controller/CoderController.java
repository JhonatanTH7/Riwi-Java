package Introduction.controller;

import Introduction.entity.Coder;
import Introduction.model.CoderModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CoderController {
    CoderModel objCoderModel;

    public CoderController() {
        //Crear una instancia del Model
        this.objCoderModel = new CoderModel();
    }

    //Método para borrar elemento
    public void delete() {
        //Definimos String para concatenar la info
        String list = this.getAll(this.objCoderModel.findAll());
        int confirm = 1;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(null, list + "\n Enter the ID of the Coder you want to delete: "));
        Coder objCoderDelete = (Coder) this.objCoderModel.findById(idDelete);
        if (objCoderDelete == null) {
            JOptionPane.showMessageDialog(null, "Coder not found");
        } else {
            confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the Coder: \n" + objCoderDelete);

            //Si el usuario escoge que si eliminamos el objeto
            //ShowConfirmDialog devuelve 1 si escogen no y 0 si escoge si
            if (confirm == 0) {
                this.objCoderModel.delete(objCoderDelete);
                JOptionPane.showMessageDialog(null, "Coder deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null, "No Coder was deleted");
            }
        }
    }

    //Método para listar los elementos (Coders)
    public void getAll() {
        //Definimos String para concatenar la info
        String list = this.getAll(this.objCoderModel.findAll());

        //Imprimimos la lista
        JOptionPane.showMessageDialog(null, list);
    }

    //Método para crear elemento
    public void create() {
        Coder objCoder = new Coder();
        String name = JOptionPane.showInputDialog(null, "Enter the Coder's name");
        int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Coder's age"));
        String clan = JOptionPane.showInputDialog(null, "Enter the clan you want to add the Coder to");
        objCoder.setName(name);
        objCoder.setAge(age);
        objCoder.setClan(clan);
        objCoder = (Coder) this.objCoderModel.insert(objCoder);
        JOptionPane.showMessageDialog(null, objCoder.toString());
    }

    //Método para filtrar por nombre
    public void getByName() {
        String nameSearched = JOptionPane.showInputDialog(null, "Enter the name of the Coder you want to search for");
        ArrayList<Coder> listCodersSearched = this.objCoderModel.findByName(nameSearched);

        String results = "           ====== Results ======\n\n";
        if (listCodersSearched != null) {
            for (Coder objCoder : listCodersSearched)
                results += "- ID: " + objCoder.getId() + " Name: " + objCoder.getName() + " Age: " + objCoder.getAge() + " Clan: " + objCoder.getClan() + "\n";
        } else {
            results += "- There is not a Coder with the name: " + nameSearched;
        }
        JOptionPane.showMessageDialog(null, results);
    }

    public String getAll(List<Object> objectsList) {
        //Definimos String para concatenar la info
        String list = "                             ==== Coders List ==== \n";
        //Iteramos sobre la lista que devuelve el método find all
        for (Object obj : objectsList) {
            //Casteamos el tipo Object a tipo Coder
            Coder objCoder = (Coder) obj;
            //Concatenamos la info
            list += "- ID: " + objCoder.getId() + " Name: " + objCoder.getName() + " Age: " + objCoder.getAge() + " Clan: " + objCoder.getClan() + "\n";
        }
        return list;
    }

    //Método para actualizar elemento
    public void update() {
        String listCoders = this.getAll(this.objCoderModel.findAll());
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(null, listCoders + "\n Enter the ID of the student you want to update"));

        Coder objCoder = (Coder) this.objCoderModel.findById(idUpdate);

        if (objCoder == null) {
            JOptionPane.showMessageDialog(null, "Coder not found");
        } else {
            String name = JOptionPane.showInputDialog(null, "Enter new name", objCoder.getName());
            int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter new name", String.valueOf(objCoder.getAge())));
            String clan = JOptionPane.showInputDialog(null, "Enter new clan", objCoder.getClan());
            objCoder.setName(name);
            objCoder.setAge(age);
            objCoder.setClan(clan);
            this.objCoderModel.update(objCoder);
        }
    }
}
