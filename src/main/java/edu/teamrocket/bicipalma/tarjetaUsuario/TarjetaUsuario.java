package edu.teamrocket.bicipalma.tarjetaUsuario;

public class TarjetaUsuario implements Autenticacion {

    private final String idUsuario;
    private boolean activa;

    public TarjetaUsuario(String idUsuario, boolean activa) {
        this.idUsuario = idUsuario;
        this.activa = activa;
    }

    @Override
    public boolean isActivada() {
        return activa;
    }

    public void cambiarEstado(boolean estado) {
        this.activa = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" + idUsuario + "}";
    }
}