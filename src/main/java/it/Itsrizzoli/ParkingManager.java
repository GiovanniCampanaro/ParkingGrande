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
            return floor.findFreePad(plate);
        }
        return null;
    }
}