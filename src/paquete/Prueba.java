package paquete;

public class Prueba {

	public static void main(String[] args) {
		Repositorio repositorio = Repositorio.getInstancia();
		
		PapeleraReciclaje papalera = new PapeleraReciclaje();
		
		repositorio.agregarListener(papalera);
		
		Recurso recurso = new Recurso();
		recurso.setTamaño(50);
		recurso.setNombre("Archivo");
		RecursoBinario recursoBinario = new RecursoBinario();
		recursoBinario.setTamaño(50);
		recursoBinario.setTipoDato(TipoDato.pdf);
		recursoBinario.setNombre("PDF");
		//agregar
		repositorio.agregarRecurso(recurso);
		repositorio.agregarRecurso(recursoBinario);
		
		//eliminar
		try {
			repositorio.eliminarRecurso(99);
		} catch (PosicionInexistenteException e) {
			System.out.println(e.getMessage());
		}
		
		//Cosultar
		try {
			Recurso recu = repositorio.consultarRecurso(101);
			System.out.println("Nombre del recurso consultado: " + recu.getNombre());
		} catch (PosicionInexistenteException e) {
			System.out.println(e.getMessage());
		}
		
		//Listar transacciones
		repositorio.listarTransacciones();

	}

}
