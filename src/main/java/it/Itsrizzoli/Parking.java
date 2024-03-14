package it.Itsrizzoli;

import com.google.gson.Gson;

public class Parking {
    String name;
    Floor [] floors;
    public Parking() {
    }
    static public Parking buildParking(String filename) {
        String txt =  Utilities.readTextFrom(filename);
        Gson gson = new Gson();
        Parking parking = gson.fromJson( txt, Parking.class);
        return parking;
    }
}
