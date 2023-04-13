package fp.anime.test;

import fp.anime.AnimesImpl;
import fp.anime.FactoriaAnimes;
import fp.common.Source;

public class TestFactoriaAnimes {
	
	public static void main(String[] args) {
		testLeerAnimes("data/animes.csv");
	}

	private static void testLeerAnimes(String fichero) {
		System.out.println("\nTestLeerAnimes =============");
		AnimesImpl animes = FactoriaAnimes.leerAnimes(fichero);
		System.out.println("   Animes: "+ animes);
		//System.out.println("Animes de género Adventure:"+animes.getAnimesGenero("Vampire"));
		//System.out.println("Media de valoración de todos los animes: "+animes.mediaValoracionAnimes());
		//System.out.println("Animes originales:"+animes.getAnimesPorOrigen().get(Source.ORIGINAL));
		//System.out.println("Número de animes por estudio: "+animes.getNumeroAnimesPorEstudio());
	}

}
