package Works.Exercise.controller;

import java.util.List;

import javax.swing.JOptionPane;

import Works.Exercise.entity.Author;
import Works.Exercise.model.AuthorModel;

public class AuthorController {
    AuthorModel objAuthorModel;

    public AuthorController() {
        this.objAuthorModel = new AuthorModel();
    }

    public void create() {
        Author objAuthor = new Author();
        String name = JOptionPane.showInputDialog(null, "Enter Author's name");
        String nationality = JOptionPane.showInputDialog(null, "Enter Author's nationality");
        objAuthor.setName(name);
        objAuthor.setNationality(nationality);
        objAuthor = (Author) this.objAuthorModel.insert(objAuthor);
        JOptionPane.showMessageDialog(null, objAuthor.toString());
    }

    public void update() {
        String list = this.getAll(this.objAuthorModel.findAll());
        int idUpdate = Integer
                .parseInt(JOptionPane.showInputDialog(null, list + "\n Enter the ID of the Author you want to update"));
        Author objAuthorUpdate = (Author) this.objAuthorModel.findById(idUpdate);
        if (objAuthorUpdate == null) {
            JOptionPane.showMessageDialog(null, "Author not found");
        } else {
            String name = JOptionPane.showInputDialog(null, "Enter the new name", objAuthorUpdate.getName());
            String nationality = JOptionPane.showInputDialog(null, "Enter the new Nationality",
                    objAuthorUpdate.getNationality());
            objAuthorUpdate.setName(name);
            objAuthorUpdate.setNationality(nationality);
            if (this.objAuthorModel.update(objAuthorUpdate)) {
                JOptionPane.showMessageDialog(null, "Author Updated successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Couldn't update the Author");
            }
        }
    }

    public void delete() {
        String list = this.getAll(this.objAuthorModel.findAll());
        int confirm;
        int idDelete = Integer.parseInt(
                JOptionPane.showInputDialog(null, list + "\n Enter the ID of the Author you want to delete: "));
        Author objAuthorDelete = (Author) this.objAuthorModel.findById(idDelete);
        if (objAuthorDelete == null) {
            JOptionPane.showMessageDialog(null, "Author not found");
        } else {
            confirm = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete the Author == " + objAuthorDelete.getName()
                            + "== ,this will delete the Books that the Author has published too");
            if (confirm == 0) {
                if (this.objAuthorModel.delete(objAuthorDelete)) {
                    JOptionPane.showMessageDialog(null,
                            "Author and the Books published by him/her deleted successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Couldn't delete the Author");
                }

            } else {
                JOptionPane.showMessageDialog(null, "No Author was deleted");
            }
        }
    }

    public void getById() {
        int idSearched = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Enter the ID of the Author you are searching for"));
        Author objAuthor = (Author) this.objAuthorModel.findById(idSearched);
        if (objAuthor == null) {
            JOptionPane.showMessageDialog(null, "Author not found");
        } else {
            JOptionPane.showMessageDialog(null, "Author with ID-> " + idSearched + " = Name: " + objAuthor.getName()
                    + " Nationality: " + objAuthor.getNationality());
        }
    }

    public void getAll() {
        String list = this.getAll(this.objAuthorModel.findAll());
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List<Object> objectsList) {
        String list = "                           ==== Authors List ==== \n";
        for (Object obj : objectsList) {
            Author objAuthor = (Author) obj;
            list += "- ID: " + objAuthor.getId() + " Name: " + objAuthor.getName() + " Nationality: "
                    + objAuthor.getNationality() + "\n";
        }
        return list;
    }

    public String getAllStringList() {
        String list = this.getAll(this.objAuthorModel.findAll());
        return list;
    }
}
