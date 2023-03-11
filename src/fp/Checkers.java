package fp.utiles;

import java.time.LocalDate;

public class Checkers {
	
	public static void checkVacio(String s) {
		String no_spaces = s.replaceAll(" ", "");
		if(no_spaces.equals("") || no_spaces==null) {
			throw new IllegalArgumentException(
					"El nombre no puede estar vacío");
		}
	}
	
	public static void checkEpisodios(Integer ep) {
		if (ep<=0) {
			throw new IllegalArgumentException(
					"Debe tener al menos un episodio");
		}
	}
	
	public static void checkEstreno(LocalDate fecha) {
		LocalDate hoy = LocalDate.now();
		if (fecha.isAfter(hoy)) {
			throw new IllegalArgumentException(
					"La fecha de estreno no puede ser posterior a hoy");
		}
	}
	
	public static void checkId(Integer id) {
		if (id<0) {
			throw new IllegalArgumentException(
					"El id debe ser un número positivo o 0");
		}
	}

}
