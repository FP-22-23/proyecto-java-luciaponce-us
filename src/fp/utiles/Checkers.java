package fp.utiles;

public class Checkers {
	
	public static void checkVacio(String s) {
		String no_spaces = s.replaceAll(" ", "");
		if(no_spaces.equals("") || no_spaces.equals(null)) {
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
	
	public static void checkId(Integer id) {
		if (id<0) {
			throw new IllegalArgumentException(
					"El id debe ser un número positivo o 0");
		}
	}

}