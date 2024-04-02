package WorkPOO2.Exercise3.Classes.Menus;

import javax.swing.*;

public class MenusExercise3 {
    public String showMainMenu() {
        return JOptionPane.showInputDialog(null, """
                === Main menu ===
                                
                1.Manage courses
                2.Manage students
                3.Finish
                                
                Enter an option:
                """);
    }

    public String showCoursesMenu() {
        return JOptionPane.showInputDialog(null, """
                === Courses menu ===
                                
                1.Create course
                2.Search course by code
                3.Show course list
                4.Go back to main menu
                                
                Enter an option:
                """);
    }

    public String showStudentsMenu() {
        return JOptionPane.showInputDialog(null, """
                === Students menu ===
                                
                1.Add a student
                2.Remove student
                3.Show students list in a course
                4.Go back to main menu
                                
                Enter an option:
                """);
    }
}
