package it.Itsrizzoli;

public class ParkingManager {
   //ArrayList<Ticket> tickets;
    Parking parking;

    public ParkingManager() {
        this.loadParking();
    }

    /*void add(Ticket ticket){

        if (tickets == null){
            tickets = new ArrayList<>();
        }
        this.tickets.add(ticket);
    }
    Ticket findPlate(String plate){
        if (this.tickets == null){
            return null;
        }
        for (Ticket ticket : this.tickets) {
            if (ticket.plate.equals(plate)) {
                return ticket;
            }
        }
        return null;
    }*/

    void loadParking() {
        //Pad pad = Pad.buildPad("Pad.json");
        //Pad [] pads = Pad.buildPads("Pads.json");
        //Floor floor = Floor.builFloor("Floor.json");
        this.parking = Parking.buildParking("Parking.json");
    }

    public Pad findFreePad(String plate) {
        for (Floor floor :this.parking.floors) {
            return floor.findFreePad(plate);
        }
    }
}