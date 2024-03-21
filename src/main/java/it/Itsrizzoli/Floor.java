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
        if (this.pads == null) {
            return null;
        }
        for (Pad pad : this.pads) {
            if (pad != null && (pad.plate == null || pad.plate.length()== 0)) {
                pad.plate = plate;
                return pad;
            }
        }
        return null;
    }


    public Pad findPad(String plate) {
        if (this.pads == null) {
            return null;
        }
        for (Pad pad : this.pads) {
            if (pad != null && pad.plate != null && pad.plate.equals(plate )) {
                return pad;
            }
        }
        return null;
    }
}
