package fp.anime.test;

import java.util.List;
import java.util.Map;

import fp.anime.Anime;
import fp.anime.AnimesBuclesImpl;
import fp.anime.FactoriaAnimes;
import fp.common.Source;
import fp.common.Studio;

public class TestAnimesBucles {
	public static void main(String[] args) {
		AnimesBuclesImpl animes = FactoriaAnimes.leerAnimesB("./data/animes.csv");
		
		System.out.println("\ntestGetNumeroAnimes");
		separador();
		testGetNumeroAnimes(animes);
		
		System.out.println("\ntestExisteAnimeValoracionMayorA");
		separador();
		testExisteAnimeValoracionMayorA(animes,5.0);
		testExisteAnimeValoracionMayorA(animes,10.0);
		
		System.out.println("\ntestMediaValoracionAnimes");
		separador();
		testMediaValoracionAnimes(animes);
		
		System.out.println("\ntestGetAnimesGenero");
		separador();
		testGetAnimesGenero(animes,"Adventure");
		testGetAnimesGenero(animes,"Adventures");
		
		System.out.println("\ntestGetAnimesPorOrigen");
		separador();
		testGetAnimesPorOrigen(animes);
		
		System.out.println("\ntestGetNumeroAnimesPorEstudio");
		separador();
		testGetNumeroAnimesPorEstudio(animes);
		
	}
	
	
	private static void separador() {
		System.out.println("======================================");
	}
	
	private static void testGetNumeroAnimes(AnimesBuclesImpl animes) {
		System.out.println("Número de animes: "+animes.getNumeroAnimes());
	}
	
	private static void testExisteAnimeValoracionMayorA(AnimesBuclesImpl animes,Double valoracion) {
		System.out.println("¿Existe algún anime con valoración superior a " + valoracion + "? " + animes.existeAnimeValoraciónMayorA(valoracion)); 
	}
	
	private static void testMediaValoracionAnimes(AnimesBuclesImpl animes) {
		System.out.println("Media de valoraciones de todos los animes: "+animes.mediaValoracionAnimes());
	}
	
	private static void testGetAnimesGenero(AnimesBuclesImpl animes, String genero) {
		try {
			System.out.println("Primer anime del género "+genero+": "+animes.getAnimesGenero(genero).get(0));
		}catch(Exception e) {
			System.err.println("Capturada excepción inesperada: "+e.getMessage());
		}
	}
	
	private static void testGetAnimesPorOrigen(AnimesBuclesImpl animes) {
		System.out.println("Animes clasificados según su origen:");
		System.out.println("(Solo se muestra el primer anime de cada origen para facilitar la lectura de la consola)");
		Map<Source,List<Anime>> d = animes.getAnimesPorOrigen();
		for (Source o:d.keySet()) {
			System.out.println(o+": "+d.get(o).get(0)+", etc.");
		}
	}
	
	private static void testGetNumeroAnimesPorEstudio(AnimesBuclesImpl animes) {
		System.out.println("Número de animes por estudio:");
		Map<Studio,Integer> d = animes.getNumeroAnimesPorEstudio();
		for (Studio e:d.keySet()) {
			System.out.println(e.nombre()+": "+d.get(e)+" animes");
		}
	}

}
