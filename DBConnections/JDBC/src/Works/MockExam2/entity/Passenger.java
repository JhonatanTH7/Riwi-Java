package Works.MockExam2.entity;

public class Passenger {
    private int id;
    private String name;
    private String lastName;
    private String identityDocument;

    public Passenger() {
    }

    public Passenger(String name, String lastName, String identityDocument) {
        this.name = name;
        this.lastName = lastName;
        this.identityDocument = identityDocument;
    }

    public Passenger(int id, String name, String lastName, String identityDocument) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.identityDocument = identityDocument;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(String identityDocument) {
        this.identityDocument = identityDocument;
    }

    @Override
    public String toString() {
        return
                "  -ID: " + id +
                        "  Name: " + name +
                        "  LastName: " + lastName +
                        "  IdentityDocument: " + identityDocument;
    }
}
