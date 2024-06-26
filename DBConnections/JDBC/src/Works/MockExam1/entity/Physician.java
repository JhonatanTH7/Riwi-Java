package Works.MockExam1.entity;

public class Physician extends Person {

    private int id;

    private int idSpecialty;

    public Physician() {
    }

    public Physician(String name, String lastName, int idSpecialty) {
        super(name, lastName);
        this.idSpecialty = idSpecialty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSpecialty() {
        return idSpecialty;
    }

    public void setIdSpecialty(int idSpecialty) {
        this.idSpecialty = idSpecialty;
    }

    @Override
    public String toString() {
        return
                "  - ID: " + id +
                        "  Name: " + super.getName() +
                        "  LastName: " + super.getLastName() +
                        "  IdSpecialty: " + idSpecialty;
    }
}
