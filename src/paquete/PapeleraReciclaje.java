package paquete;

import java.util.ArrayList;

public class PapeleraReciclaje implements IListeners {

	private ArrayList<Recurso> recursos = new ArrayList<Recurso>();
	
	@Override
	public void recuperacionTemporal(Recurso recurso) {
		recursos.add(recurso);
	}
	
	/*public void listarArchivosEnPapelera() {
		System.out.println("");
		System.out.println("Lista de Archivos en Papelera: ");
		for (Recurso recurso : recursos) {
			System.out.println(String.format("Codigo: %d | Nombre: %s | Tamaño: %.2f",
			recurso.getCodigo(),
			recurso.getNombre(),
			recurso.getTamaño()));
		}
	}*/
}
