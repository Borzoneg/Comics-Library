		package comicslibrary;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Library {

	private String name;
	private int nComics;
	private List<Comic> comics = new ArrayList<Comic>();
	private float totalExpanse;
	private List<Serie> series = new ArrayList<Serie>();

	
	public Library(String name) {
		this.name = name;
	}

	
	public Library(String name, String filename) {
		this.name = name;
		try(BufferedReader br = Files.newBufferedReader(Paths.get(filename))){
			String line;
			while((line = br.readLine()) != null)
				this.addComic(Comic.fromStr2Comic(line, this));
		}
		catch (IOException e) {
            System.err.format("IOException: %s\n", e);
            System.out.println(filename);
        }
	}

	
	public String comicsToString() {
		StringBuffer buf  = new StringBuffer();
		for(Comic c : comics) { // for each comic in our array
			if(c == null)
				break;
			buf.append(c.toString());
			buf.append('\n');
		}
		return buf.toString();
	}

	
	public String getInfoString() {
		return String.format("%s contiene %d fumetti! Per una spesa totale di %.2f €", name, nComics, totalExpanse);
	}
	
	
	public String getName() {
		return name;
	}

	
	public int getNComics() {
		return nComics;
	}

	
	public float getTotalExpanse() {
		return totalExpanse;
	}
	
	
	public void addComic(Comic comic) {
		comics.add(comic);
		++nComics;
		totalExpanse += comic.price;
	}
	

	public void addSerie(Serie serie) {
		series.add(serie);
	}
	

	public String seriesToString() {
		StringBuffer buf = new StringBuffer();
		for(Serie s : series) {
			buf.append(s.toString() + '\n');
		}
		return buf.toString();
	}

	
	public Serie getOrCreateSerie(String serie) {
		for(Serie s : series) {
			if(s.getName().equals(serie))
				return s;
		}
		Serie s = new Serie(serie);
		this.addSerie(s);
		return s;
	}
	
	
	public void removeComicByName(String comicName) {
		int i;
		for(i=0; i<comics.size(); i++) {
			if(comics.get(i).getName().equals(comicName)) {
				nComics--;
				totalExpanse -= comics.get(i).getPrice();
				if(comics.get(i) instanceof  SerieComic) { // if it's a seriecomic we should drop it also from the serie
					Serie s = ((SerieComic)comics.get(i)).getSerie();
					s.removeComic(comicName);
					if(s.getNComics() == 0) // drop of the serie if there are no long comics
						series.remove(s);
					
				}
				comics.remove(i);
			}
		}
	}

	
	public void removeComicsByName(String [] comicsName) {
		int i;
		for(i=0; i<comicsName.length; i++) {
			removeComicByName(comicsName[i]);
		}
	}
	
	
	public void saveLibrary(String filename) {
	Writer dest;
	try {
		dest = new FileWriter(filename);
		dest.write(this.comicsToString());
		dest.close();
	} catch (IOException e) {
		System.err.println("Error occured with file");
	}
	
	}
}
