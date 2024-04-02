package WorkPOO2.Exercise2.Classes;

public class TemporalEmployee extends Employee {
    private String type;

    public TemporalEmployee(String name, int age, String CC, int idEmployee, double salary, String type) {
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

        return "TemporalEmployee{" +
                "type='" + type + '\'' +
                '}';
    }
}
