package fp.utiles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Checkers {
	
	/**
	 * Comprueba que la String que se le pasa por parámetro no esté vacía ni sea nula
	 * @param s String a comprobar
	 */
	public static void checkVacio(String s) {
		
		if(s==null) {
			throw new IllegalArgumentException(
					"El nombre no puede ser nulo");
		}
		
		if(s.replaceAll(" ", "").equals("")) {
			throw new IllegalArgumentException(
					"El nombre no puede estar vacío");
		}
	}
	
	/**
	 * Comprueba que el número de episodios del anime sea estrictamente mayor que cero
	 * @param ep Número de episodios a comprobar
	 */
	public static void checkEpisodios(Integer ep) {
		if (ep<=0) {
			throw new IllegalArgumentException(
					"Debe tener al menos un episodio");
		}
	}
	
	/**
	 * Comprueba que la fecha de estreno no sea posterior a la fecha actual
	 * @param estreno Fecha de estreno a comprobar
	 */
	public static void checkEstreno(LocalDateTime estreno) {
		LocalDateTime hoy = LocalDateTime.now();
		if (estreno.isAfter(hoy)) {
			throw new IllegalArgumentException(
					"La fecha de estreno no puede ser posterior a hoy");
		}
	}
	
	/**
	 * Comprueba que el id especificado por parámetro no es negativo
	 * @param id Id a comprobar
	 */
	public static void checkId(Integer id) {
		if (id<0) {
			throw new IllegalArgumentException(
					"El id debe ser un número positivo o 0");
		}
	}
	
	/**
	 * Comprueba si el género especificado por parámetro pertenece a los géneros que contiene el dataset
	 * @param genero String género a comprobar
	 */
	public static void checkGenero(String genero) {
		List<String> gs = new ArrayList<String>(Arrays.asList("Action","Adventure","Cars","Comedy","Dementia","Demons","Drama","Ecchi","Fantasy","Game",
				"Harem","Historical","Horror","Josei","Kids","Magic","Martial_Arts","Mecha","Military","Music","Mystery","Parody","Police","Psychological",
				"Romance","Samurai","School","Sci-Fi","Seinen","Shoujo","Shoujo_Ai","Shounen","Shounen_Ai","Slice_of_Life","Space","Sports","Super_Power",
				"Supernatural","Thriller","Vampire"));
		if (!gs.contains(genero)) {
			throw new IllegalArgumentException("El género debe ser uno de los siguientes:"+gs);
		}
	}

}
