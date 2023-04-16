package fp.anime.test;

import fp.anime.AnimesImpl;
import fp.anime.FactoriaAnimes;

public class TestFactoriaAnimes {
	
	public static void main(String[] args) {
		testLeerAnimes("data/animes.csv");
	}

	private static void testLeerAnimes(String fichero) {
		System.out.println("\nTestLeerAnimes =============");
		AnimesImpl animes = FactoriaAnimes.leerAnimes(fichero);
		System.out.println("   Animes: "+ animes);
	}

}
