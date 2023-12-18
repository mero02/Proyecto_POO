package paquete;

import java.util.ArrayList;

public class Repositorio {
	private static int COSTOFIJO = 20;
	private static int CARGOADICIONAL = 10;

	private static Repositorio instancia = new Repositorio();
	
	private ArrayList<Recurso> recursos = new ArrayList<Recurso>();
	private ArrayList<Transaccion> transacciones = new ArrayList<Transaccion>();
	
	private ArrayList<IListeners> observadores = new ArrayList<IListeners>();
	
	public void agregarListener(IListeners observador) {
		observadores.add(observador);
	}
	
	private Repositorio() {}
	
	public static Repositorio getInstancia() {
		return instancia;
	}
	
	public void agregarRecurso(Recurso recurso) {
		Transaccion transaccion = new Transaccion();
		transaccion.setRecurso(recurso);
		transaccion.setFecha("Hoy");
		if (recurso instanceof RecursoBinario) {
			transaccion.setCosto((COSTOFIJO*recurso.getTamaño())+CARGOADICIONAL);
		}else {
			transaccion.setCosto(COSTOFIJO*recurso.getTamaño());
		}
		recursos.add(recurso);
		transacciones.add(transaccion);
	}
	
	public void eliminarRecurso(int posicion) throws PosicionInexistenteException {
		boolean flag = false;
		int aux = 0;
		for (Recurso recurso : this.recursos) {
			if(recurso.getCodigo() == posicion) {
				Transaccion transaccion = new Transaccion();
				transaccion.setRecurso(recurso);
				transaccion.setFecha("Hoy");
				transaccion.setCosto(COSTOFIJO*recurso.getTamaño());
				recursos.add(recurso);
				transacciones.add(transaccion);
				this.notificarEliminacion(recurso);
				recursos.remove(aux);
				flag = true;
				break;
			}
			aux++;
		}
		if (!flag) {
			throw new PosicionInexistenteException(posicion);
		}
	}
	
	private void notificarEliminacion(Recurso recurso) {
		for (IListeners observador : this.observadores) {
			observador.recuperacionTemporal(recurso);
		}
	}
	
	public Recurso consultarRecurso(int posicion) throws PosicionInexistenteException {
		for (Recurso recurso : this.recursos) {
			if(recurso.getCodigo() == posicion) {
				Transaccion transaccion = new Transaccion();
				transaccion.setRecurso(recurso);
				transaccion.setFecha("Hoy");
				transaccion.setCosto(0);
				recursos.add(recurso);
				transacciones.add(transaccion);
				return recurso;
			}
		}
		throw new PosicionInexistenteException(posicion);
	}
	
	public void listarTransacciones() {
		System.out.println("");
		System.out.println("Lista de transacciones: ");
		for (Transaccion transaccion : transacciones) {
			System.out.println(String.format("Codigo: %d| Nombre: %s| Fecha: %s | Costo: %.2f",
			transaccion.getRecurso().getCodigo(),
			transaccion.getRecurso().getNombre(),
			transaccion.getFecha(),
			transaccion.getCosto()));
		}
	}
}
