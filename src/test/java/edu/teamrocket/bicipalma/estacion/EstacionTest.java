package edu.teamrocket.bicipalma.estacion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import edu.teamrocket.bicipalma.bicicleta.Bicicleta;
import edu.teamrocket.bicipalma.tarjetaUsuario.TarjetaUsuario;

class EstacionTest {

    @Test
    void constructorEstacionTest() {
        Estacion estacion = new Estacion(1, "Manacor", 6);
        assertNotNull(estacion);
        assertEquals("id: 1 \ndireccion: Manacor \nanclajes: 6", estacion.toString());
    }

    @Test
    void anclajesLibresTest() {
        Estacion estacion = new Estacion(1, "Manacor", 6);
        assertEquals(6, estacion.anclajesLibres());

        estacion = new Estacion(1, "Manacor", 0);
        assertEquals(0, estacion.anclajesLibres());
    }
    
    @Test
    void anclarBicicletaTest() {
        Estacion estacion = new Estacion(1, "Manacor", 6);
        estacion.anclarBicicleta(new Bicicleta(911));
        assertEquals(5, estacion.anclajesLibres());

        estacion.anclarBicicleta(new Bicicleta(922));
        assertEquals(4, estacion.anclajesLibres());

        estacion = new Estacion(1, "Manacor", 0);
        estacion.anclarBicicleta(new Bicicleta(911));
        assertEquals(0, estacion.anclajesLibres());
    }

    @Test
    void anclajesLibres_bici_anclada_Test() {
        Estacion estacion = new Estacion(1, "Manacor", 1);
        estacion.anclarBicicleta(new Bicicleta(999));
        assertEquals(0, estacion.anclajesLibres());
    } 
    
    @Test
    void leerTarjetaUsuarioTest() {
        TarjetaUsuario tarjeta = new TarjetaUsuario("yop", true);
        Estacion estacion = new Estacion(1, "Manacor", 1);
        assertTrue(estacion.leerTarjetaUsuario(tarjeta));
    }

    @Test
    void retirarBicicletaTest() {

        Estacion estacion = new Estacion(1, "Manacor", 6);

        TarjetaUsuario tarjeta = new TarjetaUsuario("yop", false);
        estacion.retirarBicicleta(tarjeta);
        assertEquals(6, estacion.anclajesLibres());

        tarjeta = new TarjetaUsuario("yop", true);
        estacion.retirarBicicleta(tarjeta);
        assertEquals(6, estacion.anclajesLibres());

        estacion.anclarBicicleta(new Bicicleta(911));
        assertEquals(5, estacion.anclajesLibres());

        estacion.retirarBicicleta(tarjeta);
        assertEquals(6, estacion.anclajesLibres());
    }
}