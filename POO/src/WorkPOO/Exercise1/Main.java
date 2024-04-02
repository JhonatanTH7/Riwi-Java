package WorkPOO.Exercise1;

import WorkPOO.Exercise1.Classes.Book;

public class Main {
    public static void main(String[] args) {
/*        1. Clase básica de un Libro: Crea una clase Libro que tenga los atributos
        título, autor, año de publicación y si está o no prestado. Incluye métodos
        para modificar y obtener el estado de los atributos. Por último, implementa
        un método para prestar y devolver el libro, cambiando el estado de prestado
        acorde.
        */
        Book objBook = new Book("Cien años de soledad", "Gabriel Garcia Marquez", "01-05-1967", false);
        System.out.println(objBook.isBorrowed());
        objBook.changeLendingStatus();
        System.out.println(objBook.isBorrowed());
    }
}
