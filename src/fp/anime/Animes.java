package fp.anime;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import fp.common.Studio;

public interface Animes {
	/**
	 * Función que devuelve el número de animes que hay en el tipo contenedor.
	 * @return El número de animes que hay en el objeto Animes.
	 */
	public Integer getNumeroAnimes();
	/**
	 * Función que agrega un anime al tipo contenedor.
	 * @param a Anime que se desea agregar al tipo contenedor.
	 */
	public void agregarAnime(Anime a);
	/**
	 * Función que agrega una colección de animes al tipo contenedor.
	 * @param as Colección de animes que se desean agregar al tipo contenedor.
	 */
	public void agregarAnimes(Collection<Anime> as);
	/**
	 * Función que elimina un anime del tipo contenedor.
	 * @param a Anime que se desea eliminar del tipo contenedor.
	 */
	public void eliminarAnime(Anime a);
	/**
	 * Función que elimina el anime del tipo contenedor al que corresponde su índice.
	 * @param i Índice del anime que se desea eliminar del tipo contenedor.
	 */
	public void eliminarAnime(int i);
	/**
	 * Función que dada una valoración devuelve un booleano que indica si existen animes con valoración estrictamente mayor a esta.
	 * @param valoracion Valoración indicada para obtener si hay animes con valoración superior a esta.
	 * @return Booleano que indica si existen animes o no.
	 */
	public Boolean existeAnimeValoraciónMayorA(Double valoracion);
	/**
	 * Función que devuelve la media de las valoraciones de los animes que se encuentran en el tipo contenedor.
	 * @return Media de las valoraciones de todos los animes.
	 */
	public Double mediaValoracionAnimes();
	/**
	 * Función que obtiene la lista de animes que pertenecen al género indicado por parámetro.
	 * @param genero Género del que deseamos obtener la lista de animes.
	 * @return Lista de objetos tipo Anime cuyo género es el que se pasa por parámetro.
	 */
	public List<Anime> getAnimesGenero(String genero);
	/**
	 * Función que cuenta los animes que pertenecen a cada estudio.
	 * @return Diccionario que indica el número de animes que hay por estudio.
	 */
	public Map<Studio,Integer> getNumeroAnimesPorEstudio();
	

}
