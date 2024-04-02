package WorkPOO2.Exercise2.Classes;

public class Person {
    private String name;
    private int age;
    private String CC;

    public Person(String name, int age, String CC) {
        this.name = name;
        this.age = age;
        this.CC = CC;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCC() {
        return CC;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", CC='" + CC + '\'' +
                '}';
    }
}
