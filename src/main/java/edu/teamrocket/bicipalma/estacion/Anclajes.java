package edu.teamrocket.bicipalma.estacion;

import edu.teamrocket.bicipalma.bicicleta.Bicicleta;

public class Anclajes {

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

    public Anclaje[] obtenerAnclajes() {
        return estructura;
    }

    public int capacidadTotal() {
        return estructura.length;
    }

    public void insertarBici(int posicion, Bicicleta bici) {
        estructura[posicion].anclarBici(bici);
    }

    public void extraerBici(int posicion) {
        estructura[posicion].liberarBici();
    }

    public Bicicleta verBici(int posicion) {
        return estructura[posicion].getBici();
    }

    @Override
    public String toString() {
        return "Numero de anclajes: " + estructura.length;
    }
}