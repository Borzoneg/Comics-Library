package comicslibrary;

public class SerieComic extends Comic {

	private Serie serie;
	private int issue;
	//private Date date;
	
	public SerieComic(String name, int issue, double price, Library library, Serie serie){
		this.name = name;
		this.issue = issue;
		this.price = price;
		//this.date = date;
		this.library = library;
		this.serie = serie;
	}
	
	public int getIssue() {
		return issue;
	}
	
	public Serie getSerie() {
		return serie;
	}
}
