package main;
import comicslibrary.*;

public class Application {

	public static void main(String[] args) {
		
		Library library = new Library("My library");
		String input0 = "Spiderman 703 3.50";
		String input1 = "Bone 35";
		String input2 = "Spiderman 704 3.50";
	
		Comic c0 = Comic.fromStr2Comic(input0, library);
		Comic c1 = Comic.fromStr2Comic(input1, library);
		Comic c2 = Comic.fromStr2Comic(input2, library);
		Comic c3 = new Comic("I kill giants", 19.0, library);
		
		
		System.out.println(c0.toString());
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		
		System.out.println();
		
		library.addComic(c0);
		library.addComic(c1);
		library.addComic(c2);
		library.addComic(c3);
		
		System.out.println(library.getInfoString() + '\n');
		System.out.println(library.comicsToString());
		
		int[] nums = {712, 713, 714, 716};
		Comic[] cs = Comic.generateArraySerieComics("Spiderman", nums, 3.5, library);
		for (Comic c : cs) {
			System.out.println(c.toString());
		}
		//System.out.println(library.);
	}

}
