package fp.anime;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import fp.common.Source;
import fp.common.Studio;

public interface FactoriaAnimes {
	
	/**
	 * Lee el fichero cuya ruta se le pasa por parámetro y lo convierte en un objeto tipo Animes.
	 * @param fichero Ruta del fichero a leer
	 * @return Objeto tipo Animes
	 */
	public static AnimesImpl leerAnimes(String fichero) {
		return null;
	}
	/**
	 * Parsea cada línea del fichero para convertirla en un objeto tipo Anime
	 * @param linea
	 * @return Objeto tipo Anime
	 */
	public static Anime parsearAnime(String linea) {
		return null;
	}
	/**
	 * Crea un objeto tipo Studio a partir de un id y un nombre, ambos de tipo String.
	 * @param id Id que se le asignará al nuevo estudio.
	 * @param nombre Nombre que se le asignará al nuevo estudio.
	 * @return Objeto tipo Studio
	 */
	private static Studio parseaEstudio(String id, String nombre) {
		return null;
	}
	/**
	 * Convierte un String con el origen en un objeto enumerado Source.
	 * @param o Origen en formato String (admite minúsculas)
	 * @return Objeto tipo Source
	 */
	private static Source parseaOrigen(String o) {
		return null;
	}
	/**
	 * Convierte una String formato "Jan 1,2019" en un objeto LocalDate
	 * @param fecha String formato "Jan 1,2019"
	 * @return Objeto tipo LocalDate
	 */
	private static LocalDate parseaEstreno(String fecha) {
		return null;
	}
	/**
	 * Convierte una lista de valores 0.0 o 1.0, donde la columna del dataset indica el género, en un set de géneros.
	 * @param generos Lista de valores 0.0 y 1.0 correspondientes a las columnas de géneros
	 * @return Set de String que contiene los géneros
	 */
	private static Set<String> parseaGenero(List<String> generos) {
		return null;
	}
	

}
