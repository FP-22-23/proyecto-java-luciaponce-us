package fp.anime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import fp.common.Source;
import fp.common.Studio;
import fp.utiles.Checkers;

public class AnimesImpl implements Animes{
	
	// Atributos
	private List<Anime> animes;
	
	// Constructores
	public AnimesImpl() {
		animes = new ArrayList<Anime>();
	}
	
	public AnimesImpl(Collection<Anime> animes) {
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
		AnimesImpl other = (AnimesImpl) obj;
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
	
	public Boolean existeAnimeValoraciónMayorA(Double valoracion) {
		return animes.stream()
				.anyMatch(x -> x.getValoracion()>valoracion);
	}
	
	public Double mediaValoracionAnimes() {
		return animes.stream()
				.mapToDouble(x->x.getValoracion())
				.average()
				.getAsDouble();
	}
	
	public List<Anime> getAnimesGenero(String genero){
		Checkers.checkGenero(genero);
		return animes.stream()
				.filter(x -> x.getGenero().contains(genero))
				.collect(Collectors.toList());
	
	}
	
	public Map<Source,List<Anime>> getAnimesPorOrigen(){
		return animes.stream()
				.collect(Collectors.groupingBy(Anime::getOrigen,Collectors.toList()));
	}
	
	public Map<Studio,Integer> getNumeroAnimesPorEstudio(){
		return animes.stream()
				.collect(
						Collectors.groupingBy(x -> x.getEstudio(), Collectors.summingInt(e->1))
						);
	}

}
