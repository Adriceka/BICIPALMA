package edu.teamrocket.bicipalma.estacion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnclajesTest {

    @Test
    void toStringTest() {
        Anclajes anclajes = new Anclajes(6);
        assertEquals("Numero de anclajes: 6", anclajes.toString());
    } 
}