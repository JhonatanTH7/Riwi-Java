package Works.MockExam1.entity;

import java.sql.Time;
import java.sql.Date;

public class Appointment {
    private int id;
    private Date appointmentDate;
    private Time appointmentTime;
    private String reason;
    private int idPatient;
    private int idPhysician;

    public Appointment() {
    }

    public Appointment(Date appointmentDate, Time appointmentTime, String reason, int idPatient, int idPhysician) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.reason = reason;
        this.idPatient = idPatient;
        this.idPhysician = idPhysician;
    }

    public Appointment(int id, Date appointmentDate, Time appointmentTime, String reason, int idPatient, int idPhysician) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.reason = reason;
        this.idPatient = idPatient;
        this.idPhysician = idPhysician;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    @Override
    public String toString() {
        return "  - ID: " + this.id +
                "  AppointmentDate: " + appointmentDate +
                "  AppointmentTime: " + appointmentTime +
                "  Reason: " + reason +
                "  IdPatient: " + idPatient +
                "  IdPhysician: " + idPhysician;
    }
}
