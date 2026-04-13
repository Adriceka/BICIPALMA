package edu.teamrocket.bicipalma.estacion;

import edu.teamrocket.bicipalma.bicicleta.Bicicleta;

class Anclajes {

    private final Anclaje[] estructura;

    public Anclajes(int capacidad) {
        estructura = new Anclaje[capacidad];
        inicializar();
    }

    private void inicializar() {
        for (int i = 0; i < estructura.length; i++) {
            estructura[i] = new Anclaje();
        }
    }

    Anclaje[] obtenerAnclajes() {
        return estructura;
    }

    int capacidadTotal() {
        return estructura.length;
    }

    void insertarBici(int posicion, Bicicleta bici) {
        estructura[posicion].ocupar(bici);
    }

    void extraerBici(int posicion) {
        estructura[posicion].liberar();
    }

    Bicicleta verBici(int posicion) {
        return estructura[posicion].consultar();
    }
}