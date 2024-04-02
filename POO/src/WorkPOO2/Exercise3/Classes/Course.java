package WorkPOO2.Exercise3.Classes;

import javax.swing.*;
import java.util.ArrayList;

public class Course {
    private String code;
    private String name;
    private ArrayList<Student> studentsList;
    private static int idStudent = 1;

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
        this.studentsList = new ArrayList<>();
    }

    public void addStudent() {
        JOptionPane.showMessageDialog(null, "Adding new student");
        String name = JOptionPane.showInputDialog(null, "Enter the student's name");
        String email = JOptionPane.showInputDialog(null, "Enter the student's email");
        Student student = new Student(idStudent, name, email);
        idStudent++;
        if (this.studentsList.add(student)) {
            JOptionPane.showMessageDialog(null, "Student successfully added");
        } else {
            JOptionPane.showMessageDialog(null, "Student couldn't be added");
        }
    }

    public void showStudents() {
        if (this.studentsList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "There's no students in this course");
        } else {
            String concatList = "===== Students list in course " + this.getName() + " =====\n\n";
            for (Student student : this.studentsList) {
                concatList += "- " + student.toString() + "\n";
            }
            JOptionPane.showMessageDialog(null, concatList);
        }
    }

    public void deleteStudent() {
        JOptionPane.showMessageDialog(null, "Deleting student");
        showStudents();
        int index = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the id of the student you want to delete"));
        if (this.studentsList.removeIf(student -> student.getId() == index)) {
            JOptionPane.showMessageDialog(null, "Student successfully eliminated");
        } else {
            JOptionPane.showMessageDialog(null, "Student couldn't be eliminated");
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudentList() {
        return studentsList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentsList = studentList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", studentList=" + studentsList +
                '}';
    }
}
