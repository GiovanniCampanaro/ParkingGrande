package it.Itsrizzoli;

import static org.junit.jupiter.api.Assertions.*;

class PadTest {

    @org.junit.jupiter.api.Test
    void buildPad() {
        Pad pad =  Pad.buildPad("Pad.json");
        assertNotNull(pad,"cannot load pad");
        assertEquals("1",pad.name,"should be 1");
    }

    @org.junit.jupiter.api.Test
    void buildPadCampanaro() {
        Pad pad =  Pad.buildPad("Padaaa.json");
        assertNotNull(pad,"cannot load pad");
        assertEquals("riservato campanaro",pad.name,"should be riservato campanaro");
    }

    @org.junit.jupiter.api.Test
    void buildPads() {
        Pad [] pads = Pad.buildPads("Pads.json");
        assertNotNull(pads,"cannot load pads");
        assertEquals("3",pads[2].name,"should be 3");
    }
}