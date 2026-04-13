package bicipalma.estacion;

import bicipalma.bicicleta.Movil;

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

    void insertarBici(int posicion, Movil bici) {
        estructura[posicion].ocupar(bici);
    }

    void extraerBici(int posicion) {
        estructura[posicion].liberar();
    }

    Movil verBici(int posicion) {
        return estructura[posicion].consultar();
    }
}