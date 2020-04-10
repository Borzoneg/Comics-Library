package comicslibrary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comic {

	protected String name;
	protected double price;
	protected Library library;
	private final static Pattern pattern = Pattern.compile("(.*) ([0-9]*)( [0-9]*[.][0-9]*)?");
	
	public Comic() {
	}
	
	
	public Comic(String name, double price, Library library) {
		this.name = name;
		this.price = price;
	}

	
	public static Comic fromStr2Comic(String formattedString, Library library) {
		// format of the string: 
		// for comic parts of a serie: "Amazing Spiderman 703 3.50"
		// for graphic novel: "Bone 35	

		// TODO: if instead of bone 35 is inserted 35.00 doesn't match and raise an error 
		Matcher m = pattern.matcher(formattedString);
		m.matches();
		
		if(m.group(3) == null) {
			 return new Comic(m.group(1), Float.parseFloat(m.group(2)), library);
		}
		else{
			String name = m.group(1) + " #" + m.group(2);
			//Serie serie = new Serie(m.group(1));		
			int issue = Integer.parseInt(m.group(2));
			double price = Double.parseDouble(m.group(3));
			Serie s = library.getOrCreateSerie(m.group(1));
			SerieComic comic = new SerieComic(name, issue, price, library, s);
			s.addComic(comic);
			return comic;
		}
	}

	
	public String toString() {
		return String.format("%-15s %4.2f €" , name, price);
	}


	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}
}
