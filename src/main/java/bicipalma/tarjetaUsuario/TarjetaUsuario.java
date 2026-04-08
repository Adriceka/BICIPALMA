package bicipalma.tarjetaUsuario;

public class TarjetaUsuario {

	private String idUsuario;
	private boolean activada;

	public TarjetaUsuario(String idUsuario, boolean activada) {
		this.idUsuario = idUsuario;
		this.activada = activada;
	}

	public boolean isActivada() {
		return activada;
	}
}