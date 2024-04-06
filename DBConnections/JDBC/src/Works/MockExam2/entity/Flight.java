package Works.MockExam2.entity;

import java.sql.Date;
import java.sql.Time;

public class Flight {
    private int id;
    private String destination;
    private Date departureDate;
    private Time departureTime;
    private int idPlane;

    public Flight() {
    }

    public Flight(String destination, Date departureDate, Time departureTime, int idPlane) {
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.idPlane = idPlane;
    }

    public Flight(int id, String destination, Date departureDate, Time departureTime, int idPlane) {
        this.id = id;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.idPlane = idPlane;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public int getIdPlane() {
        return idPlane;
    }

    public void setIdPlane(int idPlane) {
        this.idPlane = idPlane;
    }

    @Override
    public String toString() {
        return
                "  -ID: " + id +
                        "  Destination: " + destination +
                        "  DepartureDate: " + departureDate +
                        "  DepartureTime: " + departureTime +
                        "  PlaneID: " + idPlane;
    }
}
