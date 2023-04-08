package fp.anime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Animes {
	private List<Anime> animes;
	
	public Animes() {
		animes = new ArrayList<Anime>();
	}
	
	public Animes(Collection<Anime> animes) {
		this.animes = new ArrayList<Anime>(animes);
	}
	

}
