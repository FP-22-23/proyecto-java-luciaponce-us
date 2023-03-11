package fp.common;

import java.util.Objects;

import fp.utiles.Checkers;

public class Studio {
	// Propiedades básicas
	
	private Integer id;
	private String nombre;
	
	// Constructor
	
	public Studio(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
		
		// Restricciones
		Checkers.checkVacio(nombre);
		Checkers.checkId(id);
	}
	
	
	// Getters y setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	// Criterio de igualdad
	
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
