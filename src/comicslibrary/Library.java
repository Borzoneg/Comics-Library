package comicslibrary;

public class Library {

	private static final int MAX_COMICS = 10000;
	private static final int MAX_SERIES = 100;
	private String name;
	private int nComics;
	private Comic[] comics = new Comic[MAX_COMICS];
	private float totalExpanse;
	

	private Serie[] series = new Serie[MAX_SERIES];

	public Library(String name) {
		this.name = name;
	}

	
	public Library(String name, String filename) {
		System.out.println("Not implemented yet");
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
		comics[nComics] = comic;
		++nComics;
		totalExpanse += comic.price;
	}

	
	public void addComics(Comic[] comics) {
		for(Comic c : comics) {
			comics[nComics] = c;
			++nComics;
		}
	}
	
	


	public void addToSerie(String serie, SerieComic comic) {
		for(Serie s : series) {
			if(s.getName() == serie) {
				s.addComic(comic);
			}
			if(s == null){
				s = new Serie(serie);
				return;
				}
		}
	}

}
