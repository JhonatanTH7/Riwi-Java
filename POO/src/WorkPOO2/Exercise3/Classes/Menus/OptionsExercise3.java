package WorkPOO2.Exercise3.Classes.Menus;

import WorkPOO2.Exercise3.Classes.Course;
import WorkPOO2.Exercise3.Classes.CourseManagement;

import javax.swing.*;
import java.util.Objects;

public class OptionsExercise3 {
    public CourseManagement courseManagement = new CourseManagement();

    public void mainOptions(String option) {
        MenusExercise3 menu = new MenusExercise3();
        switch (option) {
            case "1":
                String option1;
                do {
                    option1 = menu.showCoursesMenu();
                    optionsCourses(option1);
                } while (!option1.equals("4"));
                break;
            case "2":
                String option2;
                do {
                    option2 = menu.showStudentsMenu();
                    optionsStudents(option2);
                } while (!option2.equals("4"));
                break;
            case "3":
                JOptionPane.showMessageDialog(null, "See you next time!!!");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Not a valid option");
                break;
        }
    }

    public void optionsCourses(String option) {
        switch (option) {
            case "1":
                courseManagement.addCourse();
                break;
            case "2":
                Course courseSearched = courseManagement.searchByCode(JOptionPane.showInputDialog(null, "Enter the code of the course that you are searching for"));
                JOptionPane.showMessageDialog(null, Objects.requireNonNullElse(courseSearched, "The code entered does not correspond to any course."));
                break;
            case "3":
                courseManagement.showCourses();
                break;
            case "4":
                JOptionPane.showMessageDialog(null, "Going back");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Not a valid option");
                break;
        }
    }

    public void optionsStudents(String option) {
        switch (option) {
            case "1":
                courseManagement.showCourses();
                Course courseAddStudent = courseManagement.searchByCode(JOptionPane.showInputDialog(null, "Enter the code of the course you want to enroll the student in, if there are no courses press enter"));
                if (courseAddStudent == null) {
                    JOptionPane.showMessageDialog(null, "The code entered doesn't correspond to any course.");
                } else {
                    courseAddStudent.addStudent();
                }
                break;
            case "2":
                courseManagement.showCourses();
                Course courseDeleteStudent = courseManagement.searchByCode(JOptionPane.showInputDialog(null, "\n" +
                        "Enter the code of the course to which the student you want to delete belongs, if there are no courses press enter"));
                if (courseDeleteStudent == null) {
                    JOptionPane.showMessageDialog(null, "The code entered doesn't correspond to any course.");
                } else {
                    courseDeleteStudent.showStudents();
                    courseDeleteStudent.deleteStudent();
                }
                break;
            case "3":
                courseManagement.showCourses();
                Course courseStudents = courseManagement.searchByCode(JOptionPane.showInputDialog(null, "\n" +
                        "Enter the code of the course for which you want to view students, if there are no courses press enter"));
                if (courseStudents == null) {
                    JOptionPane.showMessageDialog(null, "The code entered doesn't correspond to any course.");
                } else {
                    courseStudents.showStudents();
                }
                break;
            case "4":
                JOptionPane.showMessageDialog(null, "Going back");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Not a valid option");
                break;
        }
    }
}
