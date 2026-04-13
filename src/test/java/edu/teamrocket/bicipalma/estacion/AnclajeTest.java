package edu.teamrocket.bicipalma.estacion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import edu.teamrocket.bicipalma.bicicleta.Bicicleta;

class AnclajeTest {

    @Test
    void anclarBiciTest() {
        Anclaje anclaje = new Anclaje();
        anclaje.anclarBici(new Bicicleta(911));
        assertTrue(anclaje.isOcupado());
    }

    @Test
    void getBiciTest() {
        Anclaje anclaje = new Anclaje();
        anclaje.anclarBici(new Bicicleta(911));
        assertTrue(anclaje.isOcupado());
        anclaje.getBici();
        assertTrue(anclaje.isOcupado());
    }

    @Test
    void liberarBiciTest() {
        Anclaje anclaje = new Anclaje();
        anclaje.anclarBici(new Bicicleta(911));
        assertTrue(anclaje.isOcupado());

        anclaje.liberarBici();
        assertFalse(anclaje.isOcupado());        
    }
}