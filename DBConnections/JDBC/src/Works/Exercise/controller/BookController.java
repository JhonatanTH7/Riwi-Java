package Works.Exercise.controller;

import Works.Exercise.entity.Author;
import Works.Exercise.entity.Book;
import Works.Exercise.model.AuthorModel;
import Works.Exercise.model.BookModel;

import javax.swing.*;
import java.util.List;

public class BookController {
    BookModel objBookModel;

    public BookController() {
        this.objBookModel = new BookModel();
    }

    public void create() {
        AuthorController objAuthorController = new AuthorController();
        Book objBook = new Book();
        String title = JOptionPane.showInputDialog(null, "Enter the title of the book");
        int publicationYear = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Enter the year that the book was published"));
        double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the price of the book"));
        int idAuthor = Integer.parseInt(JOptionPane.showInputDialog(null, objAuthorController.getAllStringList() +
                "\nEnter the ID of the author that published the book, if he is not registered go to the authors menu and register him"));
        objBook.setTitle(title);
        objBook.setPublicationYear(publicationYear);
        objBook.setPrice(price);
        objBook.setIdAuthor(idAuthor);
        objBook = (Book) this.objBookModel.insert(objBook);
        JOptionPane.showMessageDialog(null, objBook.toString());
    }

    public void update() {
        AuthorController objAuthorController = new AuthorController();
        String list = this.getAll(this.objBookModel.findAll());
        int idUpdate = Integer
                .parseInt(JOptionPane.showInputDialog(null, list + "\n Enter the ID of the Book you want to update"));
        Book objBookUpdate = (Book) this.objBookModel.findById(idUpdate);
        if (objBookUpdate == null) {
            JOptionPane.showMessageDialog(null, "Book not found");
        } else {
            String title = JOptionPane.showInputDialog(null, "Enter the new title", objBookUpdate.getTitle());
            int publicationYear = Integer
                    .parseInt(JOptionPane.showInputDialog(null, "Enter the year that the book was published",
                            objBookUpdate.getPublicationYear()));
            double price = Double
                    .parseDouble(
                            JOptionPane.showInputDialog(null, "Enter the price of the book", objBookUpdate.getPrice()));
            int idAuthor = Integer.parseInt(JOptionPane.showInputDialog(null, objAuthorController.getAllStringList() +
                    "\nEnter the ID of the author that published the book, if he is not registered go to the authors menu and register him",
                    objBookUpdate.getIdAuthor()));

            objBookUpdate.setTitle(title);
            objBookUpdate.setPrice(price);
            objBookUpdate.setIdAuthor(idAuthor);
            objBookUpdate.setPublicationYear(publicationYear);
            if (this.objBookModel.update(objBookUpdate)) {
                JOptionPane.showMessageDialog(null, "Book Updated successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Couldn't update the Book");
            }
        }

    }

    public void delete() {
        int confirm;
        int idDelete = Integer.parseInt(JOptionPane.showInputDialog(null,
                getAll(this.objBookModel.findAll()) + "\n Enter the ID of the book you want to delete"));
        Book objBookDelete = (Book) this.objBookModel.findById(idDelete);

        if (objBookDelete == null) {
            JOptionPane.showMessageDialog(null, "Book not found");
        } else {
            confirm = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete the Book: " + objBookDelete.getTitle());
            if (confirm == 0) {
                if (this.objBookModel.delete(objBookDelete)) {
                    JOptionPane.showMessageDialog(null, "Book deleted successfully");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No Book was deleted");
            }
        }
    }

    public void getById() {
        int idSearched = Integer
                .parseInt(JOptionPane.showInputDialog(null, "Enter the ID of the Book you are searching for"));
        Book objBook = (Book) this.objBookModel.findById(idSearched);
        String results = "                                         ====== Results ======                                         \n\n"
                + "              Book with ID: " + idSearched + "\n";
        if (objBook == null) {
            results += "Book not found";
        } else {
            results += "- ID: " + objBook.getId() + " Title: " + objBook.getTitle() + " Publication year: "
                    + objBook.getPublicationYear() + " Price: " + objBook.getPrice() + " Author: "
                    + objBook.getIdAuthor() + "\n";
        }
        JOptionPane.showMessageDialog(null, results);
    }

    public void getByName() {
        String nameSearched = JOptionPane.showInputDialog(null, "Enter the title of the Book you want to search for");
        List<Object> listBooksSearched = this.objBookModel.findByName(nameSearched);
        String results = "                                         ====== Results ======                                         \n\n"
                + "              Filtered by: " + nameSearched + "\n";
        if (!listBooksSearched.isEmpty()) {
            results += this.getAll(listBooksSearched);
        } else {
            results += "- There is not a Book with the name: " + nameSearched;
        }
        JOptionPane.showMessageDialog(null, results);
    }

    public void getByAuthorsId() {
        AuthorController objAuthorController = new AuthorController();
        AuthorModel objAuthorModel = new AuthorModel();

        int idAuthorsSearched = Integer
                .parseInt(JOptionPane.showInputDialog(null, objAuthorController.getAllStringList() +
                        "\nEnter the id of the author you want to see the published books"));
        Author objAuthor = (Author) objAuthorModel.findById(idAuthorsSearched);
        String results = "                                         ====== Results ======                                         \n\n"
                + "              Author ID: " + idAuthorsSearched;
        if (objAuthor != null) {
            List<Object> listBooksSearched = this.objBookModel.findByAuthorsId(idAuthorsSearched);
            results += " - " + objAuthor.getName() + "\n";
            if (!listBooksSearched.isEmpty()) {
                results += this.getAll(listBooksSearched);
            } else {
                results += "- This Author hasn't published any book yet";
            }
        } else {
            results += "\n- There is not an Author with the ID: " + idAuthorsSearched;
        }
        JOptionPane.showMessageDialog(null, results);
    }

    public void getAll() {
        String list = this.getAll(this.objBookModel.findAll());
        JOptionPane.showMessageDialog(null, list);
    }

    public String getAll(List<Object> objectsList) {
        String list = "                                         ====== Books List ======                                         \n";
        for (Object obj : objectsList) {
            Book objBook = (Book) obj;
            list += "- ID: " + objBook.getId() + " Title: " + objBook.getTitle() + " Publication year: "
                    + objBook.getPublicationYear() + " Price: " + objBook.getPrice() + " AuthorID: "
                    + objBook.getIdAuthor() + "\n";
        }
        return list;
    }
}
