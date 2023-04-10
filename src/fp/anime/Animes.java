package fp.anime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import fp.common.Source;
import fp.common.Studio;

public class Animes {
	
	// Atributos
	private List<Anime> animes;
	
	// Constructores
	public Animes() {
		animes = new ArrayList<Anime>();
	}
	
	public Animes(Collection<Anime> animes) {
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
		Animes other = (Animes) obj;
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
	
	// Métodos con tratamientos secuenciales
	
	public Double mediaValoracionAnimes() {
		Double suma = 0.0;
		for (Anime a : animes) {
			suma+=a.getValoracion();
		}
		Double media = suma/getNumeroAnimes();
		return media;
	}
	
	public List<Anime> getAnimesGenero(String genero){
		List<String> gs = new ArrayList<String>(Arrays.asList("Action","Adventure","Cars","Comedy","Dementia","Demons","Drama","Ecchi","Fantasy","Game",
				"Harem","Historical","Horror","Josei","Kids","Magic","Martial_Arts","Mecha","Military","Music","Mystery","Parody","Police","Psychological",
				"Romance","Samurai","School","Sci-Fi","Seinen","Shoujo","Shoujo_Ai","Shounen","Shounen_Ai","Slice_of_Life","Space","Sports","Super_Power",
				"Supernatural","Thriller","Vampire"));
		if (gs.contains(genero)) {
			List<Anime> res = new ArrayList<Anime>();
			for (Anime a : animes) {
				if (a.getGenero().contains(genero)) {
					res.add(a);
				}
			}
			return res;
		}else {
			throw new IllegalArgumentException("El género debe ser uno de los siguientes:"+gs);
		}
		
	}
	
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
