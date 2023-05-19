package fp.anime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.Source;
import fp.common.Studio;
import fp.utiles.Checkers;

public class AnimesStreamImpl implements Animes{
	
	// Atributos
	List<Anime> animes;
	
	// Constructores
	public AnimesStreamImpl() {
		animes = new ArrayList<Anime>();
	}
	
	public AnimesStreamImpl(Collection<Anime> animes) {
		this.animes = new ArrayList<Anime>(animes);
	}
	
	public AnimesStreamImpl(Stream<Anime> animes) {
		this.animes = animes.collect(Collectors.toList());
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
	
	// Métodos con tratamientos secuenciales
	
	// Existe
	public Boolean existeAnimeValoraciónMayorA(Double valoracion) {
		return animes.stream()
				.anyMatch(x -> x.getValoracion()>valoracion);
	}
	
	// Media
	public Double mediaValoracionAnimes() {
		return animes.stream()
				.mapToDouble(x->x.getValoracion())
				.average()
				.getAsDouble();
	}
	
	// Seleccion con filtrado
	public List<Anime> getAnimesGenero(String genero){
		Checkers.checkGenero(genero);
		return animes.stream()
				.filter(x -> x.getGenero().contains(genero))
				.collect(Collectors.toList());
	
	}
	
	// Maximo o minimo con filtrado
	
	public Anime animeMasPopularDelGenero(String genero) {
		Checkers.checkGenero(genero);
		return animes.stream()
				.filter(x -> x.getGenero().contains(genero))
				.max(Comparator.comparing(Anime::getPopularidad))
				.get();
	}
	
	// Una selección, con filtrado y ordenación.
	
	public List<Anime> topNAnimesMasPopularesDelGenero(Integer n, String genero){
		Comparator<Anime> cp = Comparator.comparing(Anime::getPopularidad).reversed();
		Checkers.checkGenero(genero);
		return animes.stream()
				.filter(x -> x.getGenero().contains(genero))
				.sorted(cp)
				.limit(n)
				.collect(Collectors.toList());
	}
	
	// Uno de los métodos (4) implementados en la entrega 2, pero con streams.
	/*public Map<Source,List<Anime>> getAnimesPorOrigen(){
		return animes.stream()
				.collect(Collectors.groupingBy(Anime::getOrigen,Collectors.toList()));
	}*/
	
	// Uno de los métodos (5) implementados en la entrega 2, pero con streams.
	
	public Map<Studio,Integer> getNumeroAnimesPorEstudio(){
		return animes.stream()
				.collect(
						Collectors.groupingBy(x -> x.getEstudio(), Collectors.summingInt(e->1))
						);
	}
	
	// Un método en cuya implementación se use, o bien el Collector collectingAndThen, o bien el Collector mapping.
	
	public Map<Source,Integer> calcularNumeroAnimesPorOrigen(){
		return animes.stream()
			.collect(Collectors.groupingBy(Anime::getOrigen,Collectors.collectingAndThen(Collectors.counting(),Long::intValue)));
	}
	
	// Un método que devuelva un Map en el que las claves sean un atributo o una función sobre un atributo, y los valores son máximos/mínimos de los elementos que tienen ese valor.

	public Map<String,Double> mayorValoracionObtenidaPorEstudio(){
		Comparator<Anime> cp = Comparator.comparing(Anime::getValoracion);
				
		return animes.stream()
				.collect(
						Collectors.groupingBy(
								a->a.getEstudio().nombre(),
								Collectors.collectingAndThen(
										Collectors.maxBy(cp), 
										opt->opt.get().getValoracion()
										)
								)
						);
	}
	
	// Un método que devuelva un SortedMap en el que las claves sean un atributo o una función sobre un atributo, y los valores sean listas con los n mejores 
	// o peores elementos que comparten el valor de ese atributo (o función sobre el atributo).
	
	public SortedMap<String,List<Anime>> topNAnimesMasPopularesPorEstudio(Integer n){
		
		return animes.stream()
				.collect(
						Collectors.groupingBy(
								a->a.getEstudio().nombre(),
								TreeMap::new,
								Collectors.collectingAndThen(
										Collectors.toList(),
										l -> topNAnimesMasPopulares(l,n))
								)
						);
		
	}
	// funcion auxiliar
	private List<Anime> topNAnimesMasPopulares(List<Anime> l, Integer n){
		Comparator<Anime> cp = Comparator.comparing(Anime::getPopularidad).reversed();
		return l.stream()
				.sorted(cp)
				.limit(n)
				.collect(Collectors.toList());
	}
	
	// Un método que calcule un Map y devuelva la clave con el valor asociado (mayor o menor) de todo el Map.
	
	public Studio estudioMayorPopularidadAcumulada() {
		Map<Studio,Double> aux = popularidadAcumuladaPorEstudio();
		return aux.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.get()
				.getKey();
	}
	
	// funcion auxiliar
	private Map<Studio,Double> popularidadAcumuladaPorEstudio(){
		return animes.stream()
				.collect(Collectors.groupingBy(
						a->a.getEstudio(),
						Collectors.summingDouble(Anime::getPopularidad)
						));
	}
	
	
	
	
	
	
}
