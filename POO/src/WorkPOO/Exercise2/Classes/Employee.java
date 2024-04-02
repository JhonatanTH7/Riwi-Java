package WorkPOO.Exercise2.Classes;

public class Employee {
    private String name;
    private String position;
    private Double salary;
    private int id;

    public Employee(String name, String position, Double salary, int id) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void raiseSalary(int percentage) {
        this.salary += (this.salary * percentage) / 100;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}
