package fp.common;

import java.util.Objects;

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

	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studio other = (Studio) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}
	
	
	
}
