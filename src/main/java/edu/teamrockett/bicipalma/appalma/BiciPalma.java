package bicipalma.appalma;

import bicipalma.bicicleta.Bicicleta;
import bicipalma.estacion.Estacion;
import bicipalma.tarjetaUsuario.TarjetaUsuario;

public class BiciPalma {

	public static void main(String[] args) {
		
		Estacion estacion = new Estacion(1, "Manacor", 6);
		
		System.out.println("\n **** caso TEST visualizar estado de la estacion **** \n");
		estacion.consultarEstacion();
				
		System.out.println("\n **** caso TEST visualizar anclajes libres **** \n");
		System.out.println("anclajesLibres: " + estacion.anclajesLibres());

		System.out.println("\n **** caso TEST anclar bicicleta(s) **** \n");
		
		int[] bicicletas = {291, 292, 293, 294};
		
		for (int id : bicicletas) {
			Bicicleta bicicleta = new Bicicleta(id);
			estacion.anclarBicicleta(bicicleta);
		}

		System.out.println("anclajesLibres tras generar " + bicicletas.length + " bicis: " + estacion.anclajesLibres());
		
		System.out.println("\n **** caso TEST consultar bicicletas ancladas **** \n");
		estacion.consultarAnclajes();
		
		System.out.println("\n **** caso TEST retirar bicicleta **** \n");
		
		TarjetaUsuario tarjetaUsuario = new TarjetaUsuario("000456789", true);
		
		System.out.println("¿tarjeta de usuario activada? (true/false): " + estacion.leerTarjetaUsuario(tarjetaUsuario));
		
		estacion.retirarBicicleta(tarjetaUsuario);
		
		estacion.consultarAnclajes();
		
		System.out.println("anclajesLibres: " + estacion.anclajesLibres());
	}
}