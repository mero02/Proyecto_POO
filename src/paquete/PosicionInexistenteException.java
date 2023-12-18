package paquete;

public class PosicionInexistenteException extends Exception {
	private int posicion;

	public PosicionInexistenteException(int posicion) {
		this.posicion = posicion;
	}
	public int getPosicion() {
		return posicion;
	}
	
	@Override
	public String getMessage() {
		return "El codigo: " + posicion + " no se encuentra en la lista de recursos";
	}
	
}
