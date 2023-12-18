package paquete;

public class Cliente {
	private String nombre;
	private int numeroDocumento;
	private String direccion;
	private String personaDeContacto;
	private int telefono;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getPersonaDeContacto() {
		return personaDeContacto;
	}
	public void setPersonaDeContacto(String personaDeContacto) {
		this.personaDeContacto = personaDeContacto;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}
