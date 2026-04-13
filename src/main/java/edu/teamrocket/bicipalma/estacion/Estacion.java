package edu.teamrocket.bicipalma.estacion;

import java.util.Arrays;
import java.util.Optional;

import edu.teamrocket.bicipalma.bicicleta.Bicicleta;
import edu.teamrocket.bicipalma.tarjetaUsuario.TarjetaUsuario;

public class Estacion {

    private final int identificador;
    private final String ubicacion;
    private final Anclajes anclajes;

    public Estacion(int id, String ubicacion, int capacidad) {
        this.identificador = id;
        this.ubicacion = ubicacion;
        this.anclajes = new Anclajes(capacidad);
    }

    public void consultarEstacion() {
        System.out.println("Estacion " + identificador + " - " + ubicacion);
    }

    public int anclajesLibres() {
        return (int) Arrays.stream(anclajes.obtenerAnclajes())
                           .filter(a -> !a.isOcupado())
                           .count();
    }

    public void anclarBicicleta(Bicicleta bici) {

        Optional<Anclaje> hueco = Arrays.stream(anclajes.obtenerAnclajes())
                                        .filter(a -> !a.isOcupado())
                                        .findFirst();

        if (hueco.isPresent()) {
            hueco.get().anclarBici(bici);
        } else {
            System.out.println("Estacion llena");
        }
    }

    public boolean leerTarjetaUsuario(TarjetaUsuario tarjeta) {
        return tarjeta != null && tarjeta.isActivada();
    }

    public void retirarBicicleta(TarjetaUsuario usuario) {

        if (!leerTarjetaUsuario(usuario)) {
            System.out.println("Acceso denegado");
            return;
        }

        Optional<Anclaje> ocupado = Arrays.stream(anclajes.obtenerAnclajes())
                                          .filter(Anclaje::isOcupado)
                                          .findFirst();

        if (ocupado.isPresent()) {
            Bicicleta bici = ocupado.get().getBici();
            ocupado.get().liberarBici();
            System.out.println("Bici retirada: " + bici.getId());
        } else {
            System.out.println("No hay bicis disponibles");
        }
    }

    public void consultarAnclajes() {

        int indice = 0;

        for (Anclaje a : anclajes.obtenerAnclajes()) {

            if (!a.isOcupado()) {
                System.out.println("Posicion " + indice + ": libre");
            } else {
                System.out.println("Posicion " + indice + ": bici " + a.getBici().getId());
            }

            indice++;
        }
    }

    @Override
    public String toString() {
        return "id: " + identificador + 
               " \ndireccion: " + ubicacion + 
               " \nanclajes: " + anclajes.capacidadTotal();
    }
}