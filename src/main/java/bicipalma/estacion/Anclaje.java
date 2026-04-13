package bicipalma.estacion;

import bicipalma.bicicleta.Bicicleta;

class Anclaje {

    private Bicicleta contenido;

    boolean libre() {
        return contenido == null;
    }

    void ocupar(Bicicleta bici) {
        this.contenido = bici;
    }

    Bicicleta liberar() {
        Bicicleta temp = contenido;
        contenido = null;
        return temp;
    }

    Bicicleta consultar() {
        return contenido;
    }
}