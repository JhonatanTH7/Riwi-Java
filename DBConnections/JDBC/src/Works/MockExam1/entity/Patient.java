package Works.MockExam1.entity;

import java.sql.Date;

public class Patient extends Person {

    private int id;
    private Date dateOfBirth;
    private String identityDocument;

    public Patient() {
    }

    public Patient(String name, String lastName, Date dateOfBirth, String identityDocument) {
        super(name, lastName);
        this.dateOfBirth = dateOfBirth;
        this.identityDocument = identityDocument;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
                "- ID: " + id +
                        "  Name: " + super.getName() +
                        "  LastName: " + super.getLastName() +
                        "  DateOfBirth: " + dateOfBirth +
                        "  IdentityDocument: " + identityDocument;
    }
}
