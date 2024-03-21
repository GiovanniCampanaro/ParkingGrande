package it.Itsrizzoli;

public class ParkingManager {
    Parking parking;

    public ParkingManager() {
        this.loadParking();
    }

    void loadParking() {
        this.parking = Parking.buildParking("Parking.json");
    }

    public Pad findFreePad(String plate) {
        for (Floor floor :this.parking.floors) {
            Pad pad = floor.findFreePad(plate);
            if (pad != null) {
                return pad;
            }
        }
        return null;
    }

    public Pad findPlate(String plate) {
        for (Floor floor :this.parking.floors) {
            Pad pad = floor.findPad(plate);
            if (pad != null) {
                return pad;
            }
        }
        return null;
    }
}