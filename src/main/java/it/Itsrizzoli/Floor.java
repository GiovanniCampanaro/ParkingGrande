package it.Itsrizzoli;

import com.google.gson.Gson;

public class Floor {
    String name;
    Pad [] pads;
    public Floor() {
    }
    static public Floor builFloor(String filename) {
        String txt =  Utilities.readTextFrom(filename);
        Gson gson = new Gson();
        Floor floor = gson.fromJson( txt, Floor.class);
        return floor;
    }

    public Pad findFreePad(String plate) {
        for (Pad pad : this.pads) {
            if (pad.plate == null) {
                pad.plate = plate;
                return pad;
            }
        }
        return null;
    }
}
