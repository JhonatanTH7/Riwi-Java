package Works.MockExam1.entity;

import java.sql.Time;
import java.sql.Date;

public class Appointment {
    private int id;
    private int idPatient;
    private int idPhysician;
    private Date appointmentDate;
    private Time appointmentTime;

    public Appointment(int idPatient, int idPhysician, Date appointmentDate, Time appointmentTime) {
        this.idPatient = idPatient;
        this.idPhysician = idPhysician;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getIdPhysician() {
        return idPhysician;
    }

    public void setIdPhysician(int idPhysician) {
        this.idPhysician = idPhysician;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Time getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", idPatient=" + idPatient +
                ", idPhysician=" + idPhysician +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                '}';
    }
}
