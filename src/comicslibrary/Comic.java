package comicslibrary;

import java.util.Locale;

import exceptions.ComicException;

public class Comic {

	protected String name;
	protected double price;
	protected Library library;	
	
	public Comic(String name, double price, Library library) {
	    if(library == null)
		return;
	    this.library = library;
	    this.name = name;
	    this.price = price;
	    
	}

	
	public Comic(String[] fields, Library library) {
	    if(library == null)
		return;
	    this.library = library;
	    name = fields[0];
	    price = Double.valueOf(fields[1]);  
	    
	}

	
	public Comic() {

	}


	public static String[] getFieldsFromStr(String formattedString) {
	    return formattedString.split("  ");
	}
	
	
	public String toString() {
		return String.format("%-20s  %4.2f €" , name, price);
	}


	public String getName() {
		return name;
	}


	public double getPrice() {
		return price;
	}


	public String toStringForFile() {
	    return String.format(Locale.US, "%s  %.2f" , name, price);
	}
}	
