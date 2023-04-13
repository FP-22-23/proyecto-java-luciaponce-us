package fp.anime.test;

import fp.anime.AnimesImpl;
import fp.anime.FactoriaAnimesImpl;
import fp.common.Source;
import fp.common.Studio;

public class TestFactoriaAnimes {
	
	public static void main(String[] args) {
		testLeerAnimes("data/animes.csv");
	}

	private static void testLeerAnimes(String fichero) {
		System.out.println("\nTestLeerAnimes =============");
		AnimesImpl animes = FactoriaAnimesImpl.leerAnimes(fichero);
		System.out.println("   Animes: "+ animes);
		//String genero = "Adventure";
		//System.out.println("Animes de género "+genero+":"+animes.getAnimesGenero(genero));
		//System.out.println("Media de valoración de todos los animes: "+animes.mediaValoracionAnimes());
		//System.out.println("Animes originales:"+animes.getAnimesPorOrigen().get(Source.ORIGINAL));
		//System.out.println("Número de animes por estudio: "+animes.getNumeroAnimesPorEstudio());
	
	}

}
