package comicslibrary;

import java.util.Date;

public class SerieComic extends Comic {

	private Serie serie;
	private int issue;
	//private Date date;
	
	public SerieComic(String name, int issue, double price, Library library) {
		this.name = name;
		this.issue = issue;
		this.price = price;
		//this.date = date;
		this.library = library;
	}
	
	public void setSerie(Serie serie) {
		this.serie = serie;
	}

}
