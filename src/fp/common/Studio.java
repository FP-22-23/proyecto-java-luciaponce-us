package fp.common;

import fp.utiles.Checkers;

public record Studio (Integer id, String nombre){
	// Constructor
	
	public Studio(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		
		// Restricciones
		Checkers.checkVacio(nombre);
		Checkers.checkId(id);
	}
	
}
