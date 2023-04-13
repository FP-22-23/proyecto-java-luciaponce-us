package fp.anime;

import java.util.Collection;

public interface Animes {
	public Integer getNumeroAnimes();
	public void agregarAnime(Anime a);
	public void agregarAnimes(Collection<Anime> as);
	public void eliminarAnime(Anime a);
	public void eliminarAnime(int i);
	public Double mediaValoracionAnimes();

}
