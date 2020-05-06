package main;

	
import comicslibrary.*;

public class Application {

	public static void main(String[] args) {
	    
		int choice;
		Integer[] issues;
		Menu menu = new Menu();
		Library library = null;
		String sTmp1, sTmp2, multipleSTmp[];
		Comic tmpComic;
		
		
		System.out.println("Welcome in comics library!");
		choice = menu.libraryMenu();
		while(choice != 0 && choice != 1) 
		    choice = menu.libraryMenu();
		
		if(choice == 0) { // new library case		 
		    sTmp1 = menu.newLibrary();
		    library = new Library(sTmp1);
		}
		
		if(choice == 1) { // new library case from file
		    multipleSTmp = menu.loadLibraryFromFile();
		    if(multipleSTmp[1].length() > 0)
			library = new Library(multipleSTmp[0], multipleSTmp[1]);
		}
		
		while((choice = menu.mainMenu()) != 6) { // main menu loop
		    if(choice < 0 || choice > 6)
			continue;
		    switch(choice) {
		    case 0: // new library case
			if(menu.overwriteAlert()) {
			    sTmp1 = menu.newLibrary();
			    library = new Library(sTmp1);
			}
			break;
		    
		    case 1: // new library from file case
			if(menu.overwriteAlert()) {			
			    multipleSTmp = menu.loadLibraryFromFile();
			    if(multipleSTmp[1].length() > 0)
				library = new Library(multipleSTmp[0], multipleSTmp[1]);
			}
			break;
			
		    case 2: // add a comic
			multipleSTmp = menu.newComicGetFields();
			tmpComic = multipleSTmp.length==2 ? new Comic(multipleSTmp, library) : new SerieComic(multipleSTmp, library);
			library.addComic(tmpComic);
			break;
			
		    case 3: // remove a comic or comics
			multipleSTmp = menu.removeComics();
			library.removeComicsByName(multipleSTmp);		
			break;
			
		    case 4: // Add multiple comics of a serie
			issues = menu.addSerieComics();
			// TODO: how to get name of serie and price from menu class?
			//library.addSerieComics(issues, price, serie);
			break;
			
		    case 5: // Save library
			break;
			
		    default:
			System.out.println("Inserted code not valid, try again");
		
		    }
		}
	}
}
