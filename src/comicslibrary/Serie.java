package comicslibrary;

import java.util.ArrayList;
import java.util.List;

public class Serie {

	private String name;
	private int nComics;
	private List<SerieComic> comics = new ArrayList<SerieComic>();

	
	public Serie(String name) {
		this.name = name;
	}

	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(String.format("%s contiene %d fumetti: ", name, nComics));
		for(SerieComic c : comics)
			buf.append(c.getIssue() + " ");
		return buf.toString();
	}

	
	public int getNComics() {
		return nComics;
	}

	
	public String getName() {
		return name;
	}

	
	public void addComic(SerieComic comic) {
		comics.add(comic);
		nComics++;
	}
	
	
	public void addComics(int [] nums, float price, Library library) {
		for(int n : nums) {
			String name = this.name + String.valueOf(n) + "# ";
			SerieComic comic = new SerieComic(name, n, price, library, this);
			library.addComic(comic);
			 this.addComic(comic);
		}
	}

	
	public void removeComic(String comicName) {
		int i;
		for(i=0; i<comics.size(); i++)
			if(comicName.equals(comics.get(i).getName())) {				
				nComics--;
				comics.remove(i);
			}
	}
	
	
	public void removeComics(int[] comicIssues) {
		int i;
		for(i=0; i<comics.size(); i++) {
			for(int n : comicIssues) {
				if(comics.get(i).getIssue() == n)
					comics.remove(i);
			}
		}
	}
}
