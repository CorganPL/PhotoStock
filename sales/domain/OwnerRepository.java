package domain;

import api.ID;

import java.util.HashSet;
import java.util.Set;

public class OwnerRepository {
    Set<Owner> owners = new HashSet();

    Owner load(ID userID) {
        for (Owner o: owners) {
            if (o.getUserID().equals(userID))
                return o;
        }
        return null;
    }
}
