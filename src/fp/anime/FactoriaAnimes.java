package fp.anime;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import fp.common.Source;
import fp.common.Studio;

public class FactoriaAnimes {
	
	public static AnimesImpl leerAnimes(String fichero) {
		AnimesImpl res = null;
		try {
			List<Anime>  animes=Files.lines(Paths.get(fichero))
					.skip(1)
					.map(FactoriaAnimes::parsearAnime)
					.collect(Collectors.toList());
			
			res=new AnimesImpl(animes);
			} catch(IOException e) {
			System.out.println("Fichero no encontrado: "+fichero);
			e.printStackTrace();
		}
	return res;
	}
	
	public static Anime parsearAnime(String linea) {
		String[] t = linea.split(";");
		Integer csv_id = Integer.parseInt(t[0].trim());
		Integer anime_id = Integer.parseInt(t[1].trim());
		String nombre = t[2].trim();
		Studio estudio = parseaEstudio(t[3].trim(),t[51].trim());
		Double ep = Double.parseDouble(t[4].trim());
		Integer episodios = ep.intValue();
		Source origen = parseaOrigen(t[5].trim());
		LocalDate estreno = parseaEstreno(t[6].trim());
		Double valoracion = Double.parseDouble(t[7].trim());
		Integer seguidores = Integer.parseInt(t[8].trim());
		String sinopsis = t[9].trim();
	
		ArrayList<String> lista = new ArrayList<String>(Arrays.asList(t));
		List<String> sublista = lista.subList(10, 50);
		Set<String> genero = parseaGenero(sublista);
		//System.out.println((csv_id*100)/999+"% parseado");
		return new Anime(anime_id,nombre,episodios,origen,estreno,valoracion,seguidores,sinopsis,genero,estudio);
	}
	
	private static Studio parseaEstudio(String id, String nombre) {
		Integer int_id = Integer.parseInt(id);
		Studio res = new Studio(int_id,nombre);
		return res;
	}
	
	private static Source parseaOrigen(String o) {
		Source res = Source.OTHER;
		switch(o) {
			case "Book":
			case "Picture Book":
				res = Source.BOOK;
				break;
			case "Card game":
				res = Source.CARD_GAME;
				break;
			case "4-koma manga":
			case "Digital manga":
			case "Web manga":
			case "Manga":
				res = Source.MANGA;
				break;
			case "Game":
				res = Source.GAME;
				break;
			case "Light novel":
			case "Visual novel":
			case "Novel":
				res = Source.NOVEL;
				break;
			case "Music":
				res = Source.MUSIC;
				break;
			case "Original":
				res = Source.ORIGINAL;
				break;
			case "Radio":
				res = Source.RADIO;
				break;
		}
		return res;
	}
	
	private static LocalDate parseaEstreno(String fecha) {
		String[] f = fecha.split(",");
		String[] mesydia = f[0].split(" ");
		String m = mesydia[0].trim();
		String d = mesydia[1].trim();
		if (Integer.valueOf(d)<10) {
			d = "0"+d;
		}
		
		String y = f[1].trim();
		
		String mes = null;
		switch (m) {
			case "Jan":
				mes = "01";
		        break;
		    case "Feb":
		        mes = "02";
		        break;
		    case "Mar":
		        mes = "03";
		        break;
		    case "Apr":
		        mes = "04";
		        break;
		    case "May":
		    	mes = "05";
		        break;
		    case "Jun":
		    	mes = "06";
		        break;
		    case "Jul":
		    	mes = "07";
		        break;
		    case "Aug":
		    	mes = "08";
		        break;
		    case "Sep":
		    	mes = "09";
		        break;
		    case "Oct":
		    	mes = "10";
		        break;
		    case "Nov":
		        mes = "11";
		        break;
		    case "Dec":
		        mes = "12";
		        break;
		    default:
		        mes = "Invalid month format";
		        break;
		    }
			String parsed_fecha = d+"/"+mes+"/"+y;
			LocalDate res = LocalDate.parse(parsed_fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			return res;
	
	}
		
	
	private static Set<String> parseaGenero(List<String> generos){
		int i = 0;
		List<String> gs = new ArrayList<String>(Arrays.asList("Action","Adventure","Cars","Comedy","Dementia","Demons","Drama","Ecchi","Fantasy","Game",
				"Harem","Historical","Horror","Josei","Kids","Magic","Martial_Arts","Mecha","Military","Music","Mystery","Parody","Police","Psychological",
				"Romance","Samurai","School","Sci-Fi","Seinen","Shoujo","Shoujo_Ai","Shounen","Shounen_Ai","Slice_of_Life","Space","Sports","Super_Power",
				"Supernatural","Thriller","Vampire"));

		Set<String> res = new TreeSet<String>();
		for (String genero : generos) {
			
			genero = genero.trim();
			if (Double.valueOf(genero)==1.0) {
				res.add(gs.get(i));
			}
		i++;
		}
		return res;
	}

}
