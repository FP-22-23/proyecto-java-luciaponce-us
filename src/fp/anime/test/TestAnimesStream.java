package fp.anime.test;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import fp.anime.Anime;
import fp.anime.AnimesStreamImpl;
import fp.anime.FactoriaAnimes;
import fp.common.Source;
import fp.common.Studio;

public class TestAnimesStream {
	public static void main(String[] args) {
		AnimesStreamImpl animes = FactoriaAnimes.leerAnimes("./data/animes.csv");
		
		System.out.println("\ntestGetNumeroAnimes");
		separador();
		testGetNumeroAnimes(animes);
		
		separador();
		System.out.println("TEST TRATAMIENTOS SECUENCIALES");
		separador();
		
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
		
		// testAnimeMasPopularDelGenero(String genero)
		System.out.println("\ntestAnimeMasPopularDelGenero");
		separador();
		testAnimeMasPopularDelGenero(animes,"Ecchi");
		testAnimeMasPopularDelGenero(animes,"A");
		
		// testTopNAnimesMasPopularesDelGenero(Integer n, String genero)
		System.out.println("\ntestTopNAnimesMasPopularesDelGenero");
		separador();
		testTopNAnimesMasPopularesDelGenero(animes,3,"Ecchi");
		
		
		System.out.println("\ntestGetNumeroAnimesPorEstudio");
		separador();
		testGetNumeroAnimesPorEstudio(animes);
		
		// testCalcularNumeroAnimesPorOrigen()
		System.out.println("\ntestCalcularNumeroAnimesPorOrigen");
		separador();
		testCalcularNumeroAnimesPorOrigen(animes);
		
		// testMayorValoracionObtenidaPorEstudio()
		System.out.println("\ntestMayorValoracionObtenidaPorEstudio");
		separador();
		testMayorValoracionObtenidaPorEstudio(animes);
		// testTopNAnimesMasPopularesPorEstudio(Integer n)
		System.out.println("\ntestTopNAnimesMasPopularesPorEstudio");
		separador();
		testTopNAnimesMasPopularesPorEstudio(animes,3);
		// testEstudioMayorPopularidadAcumulada()
		System.out.println("\ntestEstudioMayorPopularidadAcumulada");
		separador();
		testEstudioMayorPopularidadAcumulada(animes);
		
		
		/*System.out.println("\ntestGetAnimesPorOrigen");
		separador();
		testGetAnimesPorOrigen(animes);*/
	
	}
	
	
	private static void separador() {
		System.out.println("======================================");
	}
	
	private static void testGetNumeroAnimes(AnimesStreamImpl animes) {
		System.out.println("Número de animes: "+animes.getNumeroAnimes());
	}
	
	private static void testExisteAnimeValoracionMayorA(AnimesStreamImpl animes,Double valoracion) {
		System.out.println("¿Existe algún anime con valoración superior a " + valoracion + "? " + animes.existeAnimeValoraciónMayorA(valoracion)); 
	}
	
	private static void testMediaValoracionAnimes(AnimesStreamImpl animes) {
		System.out.println("Media de valoraciones de todos los animes: "+animes.mediaValoracionAnimes());
	}
	
	private static void testGetAnimesGenero(AnimesStreamImpl animes, String genero) {
		try {
			System.out.println("Primer anime del género "+genero+": "+animes.getAnimesGenero(genero).get(0));
		}catch(Exception e) {
			System.err.println("Capturada excepción inesperada: "+e.getMessage());
		}
	}
	
	private static void testAnimeMasPopularDelGenero(AnimesStreamImpl animes,String genero) {
		try {
			System.out.println("Anime más popular del género "+genero+": "+animes.animeMasPopularDelGenero(genero));
		}catch(Exception e) {
			System.err.println("Capturada excepción inesperada: "+e.getMessage());
		}
	}
	
	private static void testTopNAnimesMasPopularesDelGenero(AnimesStreamImpl animes,Integer n, String genero) {
		try {
			System.out.println("Top "+n+" animes más populares del género "+genero+": ");
			int i = 1;
			for (Anime a:animes.topNAnimesMasPopularesDelGenero(n, genero)) {
				System.out.println(i+". "+a.getFormatoCorto());
				i++;
			}
		}catch(Exception e) {
			System.err.println("Capturada excepción inesperada: "+e.getMessage());
		}
	}
	
	private static void testGetNumeroAnimesPorEstudio(AnimesStreamImpl animes) {
		try {
			System.out.println("Número de animes por estudio:");
			Map<Studio,Integer> d = animes.getNumeroAnimesPorEstudio();
			for (Studio e:d.keySet()) {
				System.out.println(e.nombre()+": "+d.get(e)+" animes");
			}
		}catch(Exception e) {
			System.err.println("Capturada excepción inesperada: "+e.getMessage());
		}
	}
	
	private static void testCalcularNumeroAnimesPorOrigen(AnimesStreamImpl animes) {
		try {
			System.out.println("Número de animes por origen:");
			Map<Source,Integer> d = animes.calcularNumeroAnimesPorOrigen();
			for (Source e:d.keySet()) {
				System.out.println(e+": "+d.get(e)+" animes");
			}
		}catch(Exception e) {
			System.err.println("Capturada excepción inesperada: "+e.getMessage());
		}
		
	}
	
	private static void testMayorValoracionObtenidaPorEstudio(AnimesStreamImpl animes) {
		try {
			System.out.println("Mayor valoración obtenida por estudio:");
			Map<String,Double> d = animes.mayorValoracionObtenidaPorEstudio();
			for (String e:d.keySet()) {
				System.out.println(e+": "+d.get(e));
			}
		}catch(Exception e) {
			System.err.println("Capturada excepción inesperada: "+e.getMessage());
		}
	}
	
	private static void testTopNAnimesMasPopularesPorEstudio(AnimesStreamImpl animes, Integer n) {
		try {
			System.out.println("Top "+n+" animes más populares por estudio:");
			SortedMap<String,List<Anime>> d = animes.topNAnimesMasPopularesPorEstudio(n);
			
			for (String e:d.keySet()) {
				int i = 1;
				System.out.println(e+": ");
				for (Anime a:d.get(e)) {
					System.out.println(i+". "+a.getFormatoCorto());
					i++;
				}
			}
			
		}catch(Exception e) {
			System.err.println("Capturada excepción inesperada: "+e.getMessage());
		}
	}
	
	private static void testEstudioMayorPopularidadAcumulada(AnimesStreamImpl animes) {
		try {
			System.out.println("El estudio con mayor popularidad acumulada es "+animes.estudioMayorPopularidadAcumulada().nombre());
		}catch(Exception e) {
			System.err.println("Capturada excepción inesperada: "+e.getMessage());
		}
	}
	
	/*private static void testGetAnimesPorOrigen(AnimesStreamImpl animes) {
	System.out.println("Animes clasificados según su origen:");
	System.out.println("(Solo se muestra el primer anime de cada origen para facilitar la lectura de la consola)");
	Map<Source,List<Anime>> d = animes.getAnimesPorOrigen();
	for (Source o:d.keySet()) {
		System.out.println(o+": "+d.get(o).get(0)+", etc.");
	}
}*/
	

}
