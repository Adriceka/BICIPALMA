package edu.teamrocket.bicipalma.bicicleta;

public class Bicicleta implements Movil {

    private int id;

    public Bicicleta(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}