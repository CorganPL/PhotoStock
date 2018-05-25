package domain;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {
    Owner owner;
    LocalDate reservationDate;
    Resolution resolution;
    String reservationType;

    public Reservation(Owner owner, LocalDate reservationDate, Resolution resolution, String reservationType) {
        this.owner = owner;
        this.reservationDate = reservationDate;
        this.resolution = resolution;
        this.reservationType = reservationType;
    }
}
