package main;

import comicslibrary.*;

public class Application {

	public static void main(String[] args) {
		
		Library library = new Library("My library");
		String input0 = "Spiderman 703 3.50";
		String input1 = "Bone 35";
		String input2 = "Spiderman 704 3.50";
		String input3 = "Batman 121 4.00";
		String input4 = "Batman 122 4.00";
		String input5 = "Batman 123 4.00";
		
	
		Comic c0 = Comic.fromStr2Comic(input0, library);
		Comic c1 = Comic.fromStr2Comic(input1, library);
		Comic c2 = Comic.fromStr2Comic(input2, library);
		Comic c3 = new Comic("I kill giants", 19.0, library);
		Comic c4 = Comic.fromStr2Comic(input3, library);
		Comic c5 = Comic.fromStr2Comic(input4, library);
		Comic c6 = Comic.fromStr2Comic(input5, library);
		
		
		System.out.println(c0.toString());
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		
		System.out.println();
		
		library.addComic(c0);
		library.addComic(c1);
		library.addComic(c2);
		library.addComic(c3);
		library.addComic(c4);
		library.addComic(c5);
		library.addComic(c6);		
		
		System.out.println(library.getInfoString() + '\n');
		System.out.println(library.comicsToString());
		
		int[] nums = {712, 713, 714, 716};
		
		System.out.println(library.seriesToString());
		
		Serie s = library.getOrCreateSerie("Spiderman");
		
		s.addComics(nums, (float) 3.5, library);
		
		System.out.println(library.seriesToString());
		
		System.out.println(library.getInfoString() + '\n');
		System.out.println(library.comicsToString());
		
		library.removeComicByName("I kill giants");
		
		System.out.println(library.getInfoString() + '\n');
		System.out.println(library.comicsToString());
		
		System.out.println(library.seriesToString());
		
		String [] toRemove = new String[3];
		toRemove[0] = "Batman #122";
		toRemove[1] = "Batman #123";
		toRemove[2] = "Batman #121";
		
		library.removeComicsByName(toRemove);

		System.out.println(library.getInfoString() + '\n');
		System.out.println(library.comicsToString());
		
		
		System.out.println(library.seriesToString());
		
		
	}
}
