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
	private double totalExpanse;
	private List<Serie> series = new ArrayList<Serie>();

	
	public Library(String name) {
		this.name = name;
	}

	
	public Library(String name, String filename) {
		this.name = name;
		filename = "Files/" + filename + ".txt";
		try(BufferedReader br = Files.newBufferedReader(Paths.get(filename))){
			String line;
			while((line = br.readLine()) != null) {
			    String [] fields = Comic.getFieldsFromStr(line);
			    Comic c = fields.length==2 ? new Comic(fields, this) : new SerieComic(fields, this);
			    this.addComic(c);
			}
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
		return String.format("%s contiene %d fumetti! Per una spesa totale di %.2f �", name, nComics, totalExpanse);
	}
	
	
	public String getName() {
		return name;
	}

	
	public int getNComics() {
		return nComics;
	}

	
	public double getTotalExpanse() {
		return totalExpanse;
	}
	
	
	public void addComic(Comic comic) {
		comics.add(comic);
		++nComics;
		totalExpanse += comic.price;
		comics.sort((c1, c2) -> c1 instanceof SerieComic && c2 instanceof SerieComic && ((SerieComic)c1).getSerie().equals(((SerieComic)c2).getSerie()) ? 
				((SerieComic)c1).getIssue().compareTo(((SerieComic)c2).getIssue()) : c1.getName().compareTo(c2.getName()));
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

	
	public void removeComicsByName(List<String> comicsName) {
		for(String s : comicsName) 
			removeComicByName(s);
	}
	
	
	public void saveLibrary(String filename) {
	Writer dest;
	filename = "Files/" + filename + ".txt"; 
	try {
		dest = new FileWriter(filename);
		dest.write(this.comicsToStringForFile());
		dest.close();
	} catch (IOException e) {
		System.err.println("Error occured with file");
	}
	
	}


	private String comicsToStringForFile() {
	    StringBuffer buf  = new StringBuffer();
		for(Comic c : comics) { 
			if(c == null)
				break;
			if(c instanceof SerieComic)
			    buf.append(((SerieComic)c).toStringForFile());
			else
			    buf.append(c.toStringForFile());
			buf.append('\n');
		}
		return buf.toString();
	}


	public void addComics(SerieComic[] comics) {
	    for(SerieComic c : comics)
		this.addComic(c);
	}
	
	
	public void addSerieComics(List<Integer> nums, float price, String serie) {
		for(Integer n : nums) {
			String name = serie + " " + String.valueOf(n);
			SerieComic comic = new SerieComic(name, n, price, this, serie);
			this.addComic(comic);
		}
	}
}
