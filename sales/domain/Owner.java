package domain;

import api.ID;

public class Owner {
    private ID userID;
    private String status;

    public ID getUserID() {
        return userID;
    }

    public String getStatus() {
        return status;
    }

    public Owner(ID userID, String status) {
        this.userID = userID;
        this.status = status;
    }

}