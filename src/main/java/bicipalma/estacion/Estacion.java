package bicipalma.estacion;

import java.util.Arrays;
import java.util.Optional;

import bicipalma.bicicleta.Movil;
import bicipalma.tarjetaUsuario.Autenticacion;

public class Estacion {

    private final int identificador;
    private final String ubicacion;
    private final Anclajes anclajes;

    public Estacion(int id, String ubicacion, int capacidad) {
        this.identificador = id;
        this.ubicacion = ubicacion;
        this.anclajes = new Anclajes(capacidad);
    }

    public void mostrarInfo() {
        System.out.println("Estacion " + identificador + " - " + ubicacion);
    }

    public long contarLibres() {
        return Arrays.stream(anclajes.obtenerAnclajes())
                     .filter(Anclaje::libre)
                     .count();
    }

    public void estacionarBici(Movil bici) {

        Optional<Anclaje> hueco = Arrays.stream(anclajes.obtenerAnclajes())
                                        .filter(Anclaje::libre)
                                        .findFirst();

        if (hueco.isPresent()) {
            hueco.get().ocupar(bici);
        } else {
            System.out.println("Estacion llena");
        }
    }

    public void sacarBici(Autenticacion usuario) {

        if (!usuario.isActivada()) {
            System.out.println("Acceso denegado");
            return;
        }

        Optional<Anclaje> ocupado = Arrays.stream(anclajes.obtenerAnclajes())
                                          .filter(a -> !a.libre())
                                          .findFirst();

        if (ocupado.isPresent()) {
            Movil bici = ocupado.get().liberar();
            System.out.println("Bici retirada: " + bici.getId());
        } else {
            System.out.println("No hay bicis disponibles");
        }
    }

    public void verAnclajes() {

        int indice = 0;

        for (Anclaje a : anclajes.obtenerAnclajes()) {

            if (a.libre()) {
                System.out.println("Posicion " + indice + ": libre");
            } else {
                System.out.println("Posicion " + indice + ": bici " + a.consultar().getId());
            }

            indice++;
        }
    }
}