package main;


import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import comicslibrary.*;

public class Application {

	public static void main(String[] args) {

		int choice;
		List <String> tmpStrList = new ArrayList<>();
		Menu menu = new Menu();
		Library library = null;
		String sTmp1, sTmp2, multipleSTmp[];
		Comic tmpComic;
		boolean loop, exit = false;

		System.out.println("Welcome in comics library!");
		choice = menu.libraryMenu();
		while(choice != 0 && choice != 1) 
			choice = menu.libraryMenu();

		if(choice == 0) { // new library case		 
			sTmp1 = menu.newLibrary();
			library = new Library(sTmp1);
		}

		if(choice == 1) { // new library case from file
			sTmp1 = menu.loadLibraryFromFile();
			if(sTmp1.length() > 0)
				library = new Library(sTmp1, sTmp1);
		}

		while(! exit) { // main menu loop
			switch(choice = menu.mainMenu()) {
			case 0: // new library case
				if(menu.overwriteAlert()) {
					sTmp1 = menu.newLibrary();
					library = new Library(sTmp1);
				}
				break;

			case 1: // new library from file case
				if(menu.overwriteAlert()) {			
					sTmp1 = menu.loadLibraryFromFile();
					if(sTmp1.length() > 0)
						library = new Library(sTmp1, sTmp1);
				}
				break;

			case 2: // add a comic
				loop = true;
				while(loop) {
					multipleSTmp = menu.newComicGetFields();
					tmpComic = multipleSTmp.length==2 ? new Comic(multipleSTmp, library) : new SerieComic(multipleSTmp, library);
					library.addComic(tmpComic);
					loop = menu.addComicLoop();
				}
				break;

			case 3: // remove a comic or comics
				tmpStrList = menu.removeComics();
				library.removeComicsByName(tmpStrList);		
				break;

			case 4: // Add multiple comics of a serie
				tmpStrList = menu.addSerieComics();
				List<Integer> iss = new ArrayList<>();
				tmpStrList.stream().skip(2).forEach(s -> iss.add(Integer.valueOf(s)));
				iss.sort((i1, i2) -> i1.compareTo(i2));
				library.addSerieComics(iss, Float.valueOf(tmpStrList.get(1)), tmpStrList.get(0));
				break;

			case 5: // Save library
				library.saveLibrary(library.getName());
				System.out.println("Saved!");
				break;
				
			case 6: // print library
				System.out.println(library.comicsToString());
				break;
				
			case 7: // print info library
				System.out.println(library.getInfoString());
				break;
			
			case 8: // print series
				System.out.println(library.seriesToString());
				break;
				
			case 9:
				exit = true;
				break;

			default:
				System.out.println("Inserted code not valid, try again");

			}
		}
	}
}
