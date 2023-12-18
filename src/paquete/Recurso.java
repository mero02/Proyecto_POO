package paquete;

public class Recurso {
	private static int generaCodigo = 100;
	
	private int codigo;
	private String nombre;
	private Cliente cliente;
	private double tamaño;
	
	public Recurso () {
		this.codigo = generaCodigo++;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getCodigo() {
		return codigo;
	}

	public double getTamaño() {
		return tamaño;
	}

	public void setTamaño(double tamaño) {
		this.tamaño = tamaño;
	}
}
