package WorkPOO2.Exercise2.Classes;

public class PermanentEmployee extends Employee {
    String type;

    public PermanentEmployee(String name, int age, String CC, int idEmployee, double salary, String type) {
        super(name, age, CC, idEmployee, salary);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PermanentEmployee{" +
                "type='" + type + '\'' +
                '}';
    }
}
