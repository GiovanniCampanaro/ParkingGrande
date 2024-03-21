package it.Itsrizzoli;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {

    @Test
    void builFloor() {
        Floor floor = Floor.builFloor("Floor.json");
        assertNotNull(floor,"cannot load floor");
        assertEquals("underground",floor.name,"should be underground");
        assertEquals(floor.pads.length,10,"should be 10 pads");
    }

    @Test
    void findFreePad() {
        Floor floor = new Floor();
        floor.pads = new Pad[10];
        floor.pads[0] = new Pad("primoposto","");
        Pad pad = floor.findFreePad("EV023BT");
        assertEquals(pad.plate, "EV023BT", "cannot find plate");
        assertNotNull(pad,"cannot load pad");
    }

    @Test
    void findFreePadVuoto() {
        Floor floor = new Floor();
        floor.pads = null;
        Pad pad = floor.findFreePad("EV023BT");
        assertNull(pad,"must be null");
    }

    @Test
    void findFreePadPieno() {
        Floor floor = Floor.builFloor("Floor.json");
        assertNotNull(floor,"cannot load floor");
        assertEquals("underground",floor.name,"should be underground");
        assertEquals(floor.pads.length,10,"should be 10 pads");
        for (int i = 0; i < 10; i++) {
            Pad pad = floor.findFreePad("CA" + i);
            assertEquals(pad.plate,"CA" + i);
            assertEquals(pad.name, ""+(i+1) );
        }
        Pad pad = floor.findFreePad("EV023BT");
        assertNull(pad,"pad must be null");

    }
}