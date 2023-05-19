package fp.anime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import fp.common.Source;
import fp.common.Studio;
import fp.utiles.Checkers;

public class AnimesBuclesImpl implements Animes{
	
	// Atributos
	private List<Anime> animes;
	
	// Constructores
	public AnimesBuclesImpl() {
		animes = new ArrayList<Anime>();
	}
	
	public AnimesBuclesImpl(Collection<Anime> animes) {
		this.animes = new ArrayList<Anime>(animes);
	}
	
	// Criterio de igualdad

	@Override
	public int hashCode() {
		return Objects.hash(animes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnimesStreamImpl other = (AnimesStreamImpl) obj;
		return Objects.equals(animes, other.animes);
	}
	
	// Representación como cadena

	@Override
	public String toString() {
		return "Animes [animes=" + animes + "]";
	}
	
	// Otros métodos
	
	public Integer getNumeroAnimes() {
		return animes.size();
	}
	
	public void agregarAnime(Anime a) {
		animes.add(a);
	}
	
	public void agregarAnimes(Collection<Anime> as) {
		for (Anime a: as) {
			animes.add(a);
		}
	}
	
	public void eliminarAnime(Anime a) {
		animes.remove(animes.indexOf(a));
	}
	
	public void eliminarAnime(int i) {
		animes.remove(i);
	}
	
	public Boolean existeAnimeValoraciónMayorA(Double valoracion) {
		Boolean res = false;
		for (Anime a:animes) {
			if (a.getValoracion()>valoracion) {
				res = true;
			}
		}
		return res;
	}
	
	public Double mediaValoracionAnimes() {
		Double suma = 0.0;
		for (Anime a : animes) {
			suma+=a.getValoracion();
		}
		Double media = suma/getNumeroAnimes();
		return media;
	}
	
	public List<Anime> getAnimesGenero(String genero){
		Checkers.checkGenero(genero);

		List<Anime> res = new ArrayList<Anime>();
		for (Anime a : animes) {
			if (a.getGenero().contains(genero)) {
				res.add(a);
			}
		}
		return res;
	}
	/**
	 * Función que clasifica los animes por su origen y los almacena en un diccionario.
	 * @return Diccionario que agrupa los animes según su origen.
	 */
	public Map<Source,List<Anime>> getAnimesPorOrigen(){
		Map<Source,List<Anime>> res = new HashMap<Source,List<Anime>>();
		for (Anime a : animes) {
			if (res.containsKey(a.getOrigen())) {
				res.get(a.getOrigen()).add(a);
			}else {
				List<Anime> animes = new ArrayList<Anime>();
				res.put(a.getOrigen(),animes);
				animes.add(a);
			}
		}
		return res;
	}
	
	public Map<Studio,Integer> getNumeroAnimesPorEstudio(){
		Map<Studio,Integer> res = new HashMap<Studio,Integer>();
		for (Anime a : animes) {
			if (res.containsKey(a.getEstudio())) {
				res.put(a.getEstudio(),res.get(a.getEstudio())+1);
			}else{
				res.put(a.getEstudio(), 1);
			}
		}
		return res;
	}
}
