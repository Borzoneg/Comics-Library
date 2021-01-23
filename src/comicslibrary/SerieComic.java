package comicslibrary;

import java.util.Locale;

public class SerieComic extends Comic {

	private Serie serie;
	private int issue;

	
	public SerieComic(String name, int issue, double price, Library library, String strSerie){
		super(name, price, library);
		this.issue = issue;
		Serie serie = library.getOrCreateSerie(strSerie);
		serie.addComic(this);
		this.serie = serie;
	}


	public SerieComic(String[] fields, Library library) {
	    super();
	    name = fields[0] + " " + fields[1];
	    issue = Integer.valueOf(fields[1]);
	    price = Double.valueOf(fields[2]);
	    Serie serie = library.getOrCreateSerie(fields[0]);
	    serie.addComic(this);
	    this.serie = serie;
	}

	
	public Integer getIssue() {
		return issue;
	}
	
	
	public Serie getSerie() {
		return serie;
	}
	
	
	public String toStringForFile() {
	    return String.format(Locale.US, "%s  %d  %.2f" , serie.getName(), issue, price);
	}
}
