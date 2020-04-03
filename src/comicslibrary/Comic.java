package comicslibrary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Comic {

	protected String name;
	protected double price;
	protected Library library;

	
	public Comic() {
	}
	
	public Comic(String name, double price, Library library) {
		this.name = name;
		this.price = price;
	}

	public static Comic fromStr2Comic(String formattedString, Library library) {
		// format of the string: 
		// for comic parts of a serie: "Spiderman 703 3.50"
		// for graphic novel: "Bone 35.00
		String[] fields = formattedString.split(" ");
		
		if(fields.length == 2) {
			 return new Comic(fields[0], Float.parseFloat(fields[1]), library);
		}
		else if(fields.length == 3) {
			String name = fields[0] + " #" + fields[1];
			String serie = fields[0];		
			int issue = Integer.parseInt(fields[1]);
			double price = Double.parseDouble(fields[2]);
			SerieComic comic = new SerieComic(name, issue, price, library);
			
			//TODO: library.addToSerie(serie, comic);
			
			return comic;
		}
		return null;
	}

	
	// String name,  int issue, double price,Library library
	public static Comic[] generateArraySerieComics(String serie, int[] numbers, double price, Library library){
		int i;
		Comic[] comics = new SerieComic[numbers.length];
		for(i=0; i < numbers.length; i++) { // construction of the array of comics
			comics[i] = new SerieComic(serie + " #" + String.valueOf(numbers[i]), numbers[i], price, library);
		}
		return comics;
	}
	
	public String toString() {
		return String.format("%-15s %4.2f €" , name, price);
	}
}
