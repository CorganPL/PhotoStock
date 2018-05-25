package domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MasterpieceAvailability extends BaseAggregateRoot {

    private Set<Reservation> reservations = new HashSet<>();

    public boolean isAvailablePer(Owner owner, Resolution res){
        return avalInTheCatalog() && notSoldPerOtherClient() && notReservedPerOtherClient()
                && notReservedPer(owner, res) && notSoldPer(owner, res);

    }

    private boolean notSoldPer(Owner owner, Resolution res) {
        return true;
    }

    private boolean notReservedPerOtherClient() {
        return true;
    }

    private boolean notSoldPerOtherClient() {
        return true;
    }

    private boolean avalInTheCatalog() {
        return  true;
    }

    public boolean isStillAvailablePer(Owner owner){
        return avalInTheCatalog() && notSoldPerOtherClient() && notReservedPerOtherClient();

    }

    public void reservedPer(Owner owner, Resolution res){
        reservations.add(new Reservation(owner, LocalDate.now(), res,"Reserved"));
    }

    public void soldPer(Owner owner, Resolution res){
        reservations.add(new Reservation(owner, LocalDate.now(),  res,"SOLD"));
    }

    private boolean notReservedPer(Owner owner, Resolution res){
        return !reservations.contains(null);
    }



}
