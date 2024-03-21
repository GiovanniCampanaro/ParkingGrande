package it.Itsrizzoli;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientHandlerTest {

    @Test
    void parse() {

    }

    @Test
    void park() {
        ParkingManager pm = new ParkingManager();
        Pad pad = pm.findFreePad("EV023BT");
        assertEquals(pad.plate, "EV023BT");
        assertEquals(pad.name, "u1");

        Pad pad2 = pm.findFreePad("EV024TF");
        assertEquals(pad2.plate, "EV024TF");
        assertEquals(pad2.name, "u2");

    }
}