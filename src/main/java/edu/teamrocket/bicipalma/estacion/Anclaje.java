package edu.teamrocket.bicipalma.estacion;

import edu.teamrocket.bicipalma.bicicleta.Bicicleta;

public class Anclaje {

    private Bicicleta contenido;

    public void anclarBici(Bicicleta bici) {
        this.contenido = bici;
    }

    public Bicicleta getBici() {
        return contenido;
    }

    public void liberarBici() {
        contenido = null;
    }

    public boolean isOcupado() {
        return contenido != null;
    }
}