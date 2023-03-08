package fp.anime;

import java.time.LocalDate;
import java.util.Set;
import fp.common.Source;
import fp.common.Studio;
import fp.utiles.Checkers;

public class Anime {
	
	private Integer anime_id;
	private String nombre;
	private Integer episodios;
	private Source origen;
	private LocalDate estreno;
	private Double valoracion;
	private Integer seguidores;
	private String sinopsis;
	private Set<String> genero;
	private Studio estudio;

	public Anime(Integer anime_id, String nombre, Integer episodios, Source origen, LocalDate estreno,
			Double valoracion, Integer seguidores, String sinopsis, Set<String> genero, Studio estudio) {
		
		this.anime_id = anime_id;
		this.nombre = nombre;
		this.episodios = episodios;
		this.origen = origen;
		this.estreno = estreno;
		this.valoracion = valoracion;
		this.seguidores = seguidores;
		this.sinopsis = sinopsis;
		this.genero = genero;
		this.estudio = estudio;
		
		// Restricciones
		
		Checkers.checkVacio(nombre);
		Checkers.checkEpisodios(episodios);
	}

	public Anime(Integer anime_id, String nombre, Source origen, LocalDate estreno,
			String sinopsis, Set<String> genero, Studio estudio) {
		
		this(anime_id,nombre,1,origen,estreno,0.0,0,sinopsis,genero,estudio);
		
		Checkers.checkVacio(nombre);
	}

	public Integer getEpisodios() {
		return episodios;
	}

	public void setEpisodios(Integer episodios) {
		this.episodios = episodios;
	}

	public Double getValoracion() {
		return valoracion;
	}

	public void setValoracion(Double valoracion) {
		this.valoracion = valoracion;
	}

	public Integer getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(Integer seguidores) {
		this.seguidores = seguidores;
	}

	public Studio getEstudio() {
		return estudio;
	}

	public void setEstudio(Studio estudio) {
		this.estudio = estudio;
	}

	public Integer getAnime_id() {
		return anime_id;
	}

	public String getNombre() {
		return nombre;
	}

	public Source getOrigen() {
		return origen;
	}

	public LocalDate getEstreno() {
		return estreno;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public Set<String> getGenero() {
		return genero;
	}
	
	// Propiedades derivadas
	
	public String getFormatoCorto() {
		return getNombre() +" (" + getEstreno().getYear() + ") --> [" + getEpisodios() + " episodios]";
	}
	
	public Double getPopularidad() {
		return (getSeguidores()/1000)*getValoracion();
	}
	
	
	
	
	
	
	
	

}
