package bicipalma.estacion;

import bicipalma.bicicleta.Movil;

class Anclaje {

    private Movil contenido;

    boolean libre() {
        return contenido == null;
    }

    void ocupar(Movil bici) {
        this.contenido = bici;
    }

    Movil liberar() {
        Movil temp = contenido;
        contenido = null;
        return temp;
    }

    Movil consultar() {
        return contenido;
    }
}