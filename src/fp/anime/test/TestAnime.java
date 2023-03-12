package fp.anime.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.anime.Anime;
import fp.common.Source;
import fp.common.Studio;

public class TestAnime {
	
	public static void testConstructor1(Integer anime_id, String nombre, Integer episodios, Source origen, LocalDate estreno,
			Double valoracion, Integer seguidores, String sinopsis, Set<String> genero, Studio estudio) {
		try {
			Anime a = new Anime(anime_id,nombre,episodios,origen,estreno,valoracion,seguidores,sinopsis,genero,estudio);
		} catch(IllegalArgumentException e){
			System.out.println("Excepción capturada:\n   " + e);
		} catch(Exception e) {
			System.out.println("Excepción inesperada:\n   " + e);
		}
	}
	
	public static void testConstructor2(Integer anime_id, String nombre, Source origen, LocalDate estreno, 
			String sinopsis, Set<String> genero, Studio estudio) {
		try {
			Anime a = new Anime(anime_id,nombre,origen,estreno,sinopsis,genero,estudio);
		} catch(IllegalArgumentException e){
			System.out.println("Excepción capturada:\n   " + e);
		} catch(Exception e) {
			System.out.println("Excepción inesperada:\n   " + e);
		}
	}
	
	public static void constructorStudio(Integer id, String nombre) {
		try {
			Studio s = new Studio(id,nombre);
		} catch(IllegalArgumentException e){
			System.out.println("Excepción capturada:\n   " + e);
		} catch(Exception e) {
			System.out.println("Excepción inesperada:\n   " + e);
		}
	}
	
	
	public static void main(String[] args) {
		Set<String> gbungou = new HashSet<String>();
		gbungou.add("Action");
		gbungou.add("Comedy");
		Studio bones = new Studio(1,"Bones");
		
		Integer i = 1;
		System.out.println("-------------------");
		System.out.println("Constructor 1 - Caso prueba " + i);
		testConstructor1(0,"Bungou Stray Dogs",12,Source.MANGA,LocalDate.of(2022, 11, 12),9.5,12300,"Resumen",gbungou,bones);
		
		// Caso de prueba episodios<=0
		
		i++;
		System.out.println("-------------------");
		System.out.println("Constructor 1 - Caso prueba " + i);
		testConstructor1(0,"Bungou Stray Dogs",0,Source.MANGA,LocalDate.of(2022, 11, 12),9.5,12300,"Resumen",gbungou,bones);
		
		// Caso de prueba nombre="    "
		
		i++;
		System.out.println("-------------------");
		System.out.println("Constructor 1 - Caso prueba " + i);
		testConstructor1(0,"    ",0,Source.MANGA,LocalDate.of(2022, 11, 12),9.5,12300,"Resumen",gbungou,bones);
		
		// Caso de prueba nombre=null
		
		i++;
		System.out.println("-------------------");
		System.out.println("Constructor 1 - Caso prueba " + i);
		testConstructor1(0,null,0,Source.MANGA,LocalDate.of(2022, 11, 12),9.5,12300,"Resumen",gbungou,bones);
		
		// Caso de prueba estreno posterior a fecha actual
		
		i++;
		System.out.println("-------------------");
		System.out.println("Constructor 1 - Caso prueba " + i);
		testConstructor1(0,"Bungou",0,Source.MANGA,LocalDate.of(2023, 11, 12),9.5,12300,"Resumen",gbungou,bones);

		i = 1;
		System.out.println("-------------------");
		System.out.println("Constructor 2 - Caso prueba " + i);
		testConstructor2(0,"Bungou Stray Dogs",Source.MANGA,LocalDate.of(2022, 11, 12),"Resumen",gbungou,bones);
		
		// Caso de prueba nombre = "     "
		i++;
		System.out.println("-------------------");
		System.out.println("Constructor 2 - Caso prueba " + i);
		testConstructor2(0,"     ",Source.MANGA,LocalDate.of(2022, 11, 12),"Resumen",gbungou,bones);
		
		// Caso de prueba nombre = null
		i++;
		System.out.println("-------------------");
		System.out.println("Constructor 2 - Caso prueba " + i);
		testConstructor2(0,null,Source.MANGA,LocalDate.of(2022, 11, 12),"Resumen",gbungou,bones);
		
		// Caso de prueba estreno posterior a la fecha actual
		i++;
		System.out.println("-------------------");
		System.out.println("Constructor 2 - Caso prueba " + i);
		testConstructor2(0,"Bungou Stray Dogs",Source.MANGA,LocalDate.of(2023, 11, 12),"Resumen",gbungou,bones);
		System.out.println("-------------------------------");
		
		// Pruebas con tipo Studio
		
		System.out.println("----Pruebas del tipo Studio----");
		i = 1;
		
		System.out.println("Constructor - Caso prueba " + i);
		constructorStudio(1,"Bones");
		
		// Caso de prueba id<0
		System.out.println("-------------------------------");
		i++;
		System.out.println("Constructor - Caso prueba " + i);
		constructorStudio(-1,"Bones");
		
		// Caso de prueba nombre="   "
		System.out.println("-------------------------------");
		i++;
		System.out.println("Constructor - Caso prueba " + i);
		constructorStudio(1,"   ");
		
		// Caso de prueba nombre=null
		System.out.println("-------------------------------");
		i++;
		System.out.println("Constructor - Caso prueba " + i);
		constructorStudio(1,null);
		
		// Prueba de métodos de Anime
		
		Anime a = new Anime(0,"Bungou Stray Dogs",12,Source.MANGA,LocalDate.of(2022, 11, 12),9.5,12300,"Resumen",gbungou,bones);
		Anime b = new Anime(0,"Bungou Stray Dogs",2,Source.MANGA,LocalDate.of(2022, 11, 12),8.5,2300,"Sinopsis",gbungou,bones);
		Anime c = new Anime(1,"Bungou Stray Dogs Película",1,Source.MANGA,LocalDate.of(2022, 11, 12),8.5,2300,"Sinopsis",gbungou,bones);
		
		System.out.println("\n----Pruebas de métodos del tipo Anime----\n");
		System.out.println("Representación como cadena:\n" + a.toString() +"\n");
		System.out.println("Criterio de igualdad:\n" + "¿a es igual que b? --> "+ a.equals(b) +"\n"+ "¿a es igual que c? --> "+ a.equals(c) +"\n");
		System.out.println("Orden natural: " + a.compareTo(c));
		Integer comparacion = a.compareTo(c);
		if (comparacion<0) {
			System.out.println(a.getNombre() + " va antes que " + c.getNombre());
		}else if (comparacion>0) {
			System.out.println(a.getNombre() + " va después que " + c.getNombre());
		}else {
			System.out.println(a.getNombre() + " va en la misma posición que " + c.getNombre());
		}
		
		
		
	}

}
