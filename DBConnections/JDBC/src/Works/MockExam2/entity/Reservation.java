package Works.MockExam2.entity;

import java.sql.Date;

public class Reservation {
    private int id;
    private Date reservationDate;
    private String seat;
    private int idPassenger;
    private int idFlight;

    public Reservation() {
    }

    public Reservation(Date reservationDate, String seat, int idPassenger, int idFlight) {
        this.reservationDate = reservationDate;
        this.seat = seat;
        this.idPassenger = idPassenger;
        this.idFlight = idFlight;
    }

    public Reservation(int id, Date reservationDate, String seat, int idPassenger, int idFlight) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.seat = seat;
        this.idPassenger = idPassenger;
        this.idFlight = idFlight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getIdPassenger() {
        return idPassenger;
    }

    public void setIdPassenger(int idPassenger) {
        this.idPassenger = idPassenger;
    }

    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    @Override
    public String toString() {
        return
                "  - ID: " + id +
                        "  ReservationDate: " + reservationDate +
                        "  Seat: " + seat +
                        "  PassengerID: " + idPassenger +
                        "  FlightID: " + idFlight;
    }
}
