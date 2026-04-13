package edu.teamrocket.bicipalma.bicicleta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BicicletaTest {

    Bicicleta bici;

    @BeforeEach
    void setup() {
        this.bici = new Bicicleta(999);
    }

    @Test
    void constructorBiciTest() {
        assertEquals(999, bici.getId());
    }

    @Test
    void toStringTest() {
        assertEquals("999", bici.toString());
    }

    @Test
    void implementationMovilTest() {
        Movil movil = bici;
        assertEquals(999, movil.getId());
    }
}