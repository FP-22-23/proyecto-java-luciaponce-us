package fp.common;

import fp.utiles.Checkers;

public class Studio {
	private Integer id;
	private String nombre;
	
	public Studio(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		
		Checkers.checkVacio(nombre);
		Checkers.checkId(id);
	}
	
	
}
