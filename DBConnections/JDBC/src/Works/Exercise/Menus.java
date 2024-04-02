package Works.Exercise;

import javax.swing.JOptionPane;

import Works.Exercise.controller.AuthorController;
import Works.Exercise.controller.BookController;

public class Menus {
    public void authorMenu() {
        AuthorController authorController = new AuthorController();
        String option2 = "";
        do {
            option2 = JOptionPane.showInputDialog(null, """

                        AUTHORS MENU

                    1. Show all Authors
                    2. Add Author
                    3. Update Author
                    4. Delete Author
                    5. Get Author by ID
                    6. Get Books by Author ID
                    7. Exit

                    Choose an option:

                    """);
            switch (option2) {
                case "1":
                    authorController.getAll();
                    break;
                case "2":
                    authorController.create();
                    break;
                case "3":
                    authorController.update();
                    break;
                case "4":
                    authorController.delete();
                    break;
                case "5":
                    authorController.getById();
                    break;
                case "6":
                    BookController objBookController = new BookController();
                    objBookController.getByAuthorsId();
                    break;
                case "7":
                    JOptionPane.showMessageDialog(null, "Going back to main menu");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Not a valid option");
                    break;
            }
        } while (!option2.equals("7"));
    }

    public void bookMenu() {
        BookController objBookController = new BookController();
        String option2 = "";
        do {
            option2 = JOptionPane.showInputDialog(null, """

                        BOOKS MENU

                    1. Show all Books
                    2. Add Book
                    3. Update Book
                    4. Delete Book
                    5. Get Book by ID
                    6. Get Books by Author ID
                    7. Get Book by Title
                    8. Exit

                    Choose an option:

                    """);
            switch (option2) {
                case "1":
                    objBookController.getAll();
                    break;
                case "2":
                    objBookController.create();
                    break;
                case "3":
                    objBookController.update();
                    break;
                case "4":
                    objBookController.delete();
                    break;
                case "5":
                    objBookController.getById();
                    break;
                case "6":
                    objBookController.getByAuthorsId();
                    break;
                case "7":
                    objBookController.getByName();
                    break;
                case "8":
                    JOptionPane.showMessageDialog(null, "Going back to main menu");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Not a valid option");
                    break;
            }
        } while (!option2.equals("8"));
    }
}
