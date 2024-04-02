package WorkLists.Exercise5;

import WorkLists.Exercise5.Classes.MenuExercise5;

import javax.swing.*;
import java.util.ArrayList;

public class Exercise5 {
    public static void main(String[] args) {
//        5. Lista de Reproducción Musical: Imagina que estás creando una aplicación para
//        gestionar listas de reproducción musicales. Cada canción es representada
//        simplemente por su nombre. El programa debe permitir:
//          - Añadir y remover canciones de la lista de reproducción.
//          - Mostrar la canción actual y las siguientes en la lista.
//          - Saltar a la siguiente canción.
        MenuExercise5 menu = new MenuExercise5();
        ArrayList<String> playList = new ArrayList<>();
        int option = 0;
        int playingSong = 0;
        do {
            try {

                option = menu.mostrar();
                switch (option) {
                    case 1:
                        String newSong = JOptionPane.showInputDialog(null, "Ingrese el nombre de la canción a agregar");
                        playList.add(newSong);
                        JOptionPane.showMessageDialog(null, "Canción agregada correctamente");
                        break;
                    case 2:
                        String deleteSong = JOptionPane.showInputDialog(null, "Ingrese el nombre de la canción a eliminar");
                        if (playList.remove(deleteSong.toLowerCase())) {
                            JOptionPane.showMessageDialog(null, "Canción eliminada correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "La canción indicada no se encuentra en la PlayList");
                        }
                        break;
                    case 3:
                        if (playList.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "La PlayList esta vaciá");
                        } else {
                            String totalSongList = "";
                            totalSongList += "Canción actual: " + playList.get(playingSong) + "\n\n";
                            for (int i = playingSong; i < playList.size() - 1; i++) {
                                totalSongList += "- " + playList.get(i + 1) + "\n";
                            }
                            JOptionPane.showMessageDialog(null, totalSongList);
                        }
                        break;
                    case 4:
                        if (playList.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "La PlayList esta vaciá");
                        } else {
                            if ((playList.size() - 1) == playingSong) {
                                playingSong = 0;
                                JOptionPane.showMessageDialog(null, "La PlayList finalizó");
                            } else {
                                playingSong++;
                            }
                        }
                        break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Caracteres no validos");
            }
        } while (option != 5);
    }
}
