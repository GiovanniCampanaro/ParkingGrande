package it.Itsrizzoli;

import com.google.gson.Gson;

public class Pad {
    String name;
    String plate;

    public Pad() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Pad(String name) {
        this.name = name;
    }

    static public Pad buildPad(String filename) {
        String txt =  Utilities.readTextFrom(filename);
        Gson gson = new Gson();
        Pad pad = gson.fromJson( txt, Pad.class);
        return pad;
    }

    static public Pad []  buildPads(String filename) {
        String txt =  Utilities.readTextFrom(filename);
        Gson gson = new Gson();
        Pad [] pads = gson.fromJson( txt, Pad[].class);
        return pads;
    }



    public Pad(String name, String plate) {
        this.name = name;
        this.plate = plate;
    }


}
