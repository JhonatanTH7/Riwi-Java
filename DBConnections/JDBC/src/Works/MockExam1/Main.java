package Works.MockExam1;


import Works.MockExam1.controller.SpecialtyController;

public class Main {
    public static void main(String[] args) {
        SpecialtyController specialtyController = new SpecialtyController();
        specialtyController.update();
        specialtyController.getAll();
    }
}
