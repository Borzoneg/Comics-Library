package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import comicslibrary.Comic;
import comicslibrary.Library;
import comicslibrary.Serie;
import comicslibrary.SerieComic;

class MainTest {

    @Test
    void test() {
	
	// basic operation and test on library
	Library library = new Library("My library");
	assertNotNull(library); 
	assertEquals("My library", library.getName()); 
	String[] fields = Comic.getFieldsFromStr("Amazing Spiderman  703  3.50");
	Comic c1 = fields.length == 2 ? new Comic(fields[0], Double.valueOf(fields[1]), library) : new SerieComic(fields[0] + " " + fields[1], Integer.valueOf(fields[1]), 
															Double.valueOf(fields[2]), library, fields[0]);
	fields = Comic.getFieldsFromStr("I kill giants  19.40");
	Comic c2 = fields.length == 2 ? new Comic(fields[0], Double.valueOf(fields[1]), library) : new SerieComic(fields[0] + " " + fields[1], Integer.valueOf(fields[1]), 
															Double.valueOf(fields[2]), library, fields[0]);
	fields = Comic.getFieldsFromStr("Bone  35");
	Comic c3 = fields.length == 2 ? new Comic(fields[0], Double.valueOf(fields[1]), library) : new SerieComic(fields[0] + " " + fields[1], Integer.valueOf(fields[1]), 
															Double.valueOf(fields[2]), library, fields[0]);
	// check comics 1 creation and that c1 is actually a SerieComic
	assertNotNull(c1); 
	Serie s = library.getOrCreateSerie("Amazing Spiderman");
	assertTrue(c1 instanceof SerieComic);
	SerieComic c4 = (SerieComic)c1;
	// check contents of comics just added
	assertEquals("Amazing Spiderman 703", c1.getName());
	assertEquals(3.50, c1.getPrice());
	assertEquals(s, c4.getSerie());
	assertEquals(703, c4.getIssue());
	assertEquals("I kill giants", c2.getName());
	assertEquals(19.40, c2.getPrice());
	assertEquals("Bone", c3.getName());
	assertEquals(35, c3.getPrice());
	assertTrue(c4.toString().contains("Spiderman"));
	assertTrue(c2.toString().contains("19"));
	
	library.addComic(c2);
	library.addComic(c3);
	library.addComic(c4);
	
	// test for insert of the comics in the library
	assertTrue(library.getInfoString().contains("contiene 3 fumetti"));
	assertEquals(3, library.getNComics());
	assertEquals(57.90, (double)library.getTotalExpanse());
	assertTrue(library.comicsToString().contains("Spiderman 703") && library.comicsToString().contains("35"));
	assertTrue(library.seriesToString().contains("Spiderman") && library.seriesToString().contains("contiene"));
	
	// test for multiple insert of comics
	int[] nums = {123, 124, 125, 126, 127, 128, 129};
	SerieComic[] comics = new SerieComic[nums.length];
	String strSerie = "Amazing Spiderman";
	double price = 3.5;
	for(int i=0; i<nums.length; i++)
	    comics[i] = new SerieComic(strSerie + " " + nums[i], nums[i], price, library, strSerie);
	library.addComics(comics);
	
	// test for remove function
	assertTrue(library.comicsToString().contains("Bone"));
	library.removeComicByName("Bone");
	assertFalse(library.comicsToString().contains("Bone"));

	// remove of a SerieComic
	assertEquals(8, library.getOrCreateSerie("Amazing Spiderman").getNComics());
	library.removeComicByName("Amazing Spiderman 703");
	assertEquals(7, library.getOrCreateSerie("Amazing Spiderman").getNComics());
	
	// multiple removes test
	String[] toRemove = {"I kill giants", "Amazing Spiderman 123", "Amazing Spiderman 124", "Amazing Spiderman 125", "Amazing Spiderman 126"};
	library.removeComicsByName(toRemove);
	assertTrue(library.getInfoString().contains("3"));

	// file imported library test
	Library library2 = new Library("My second library", "Files/personal_library.txt");
	assertTrue(library2.comicsToString().contains("Batman 121"));
	
	// save function test
	 library.saveLibrary("Files/test.txt");
	 Library library3 = new Library("My second library", "Files/test.txt");
	 assertTrue(library3.comicsToString().contains("Amazing Spiderman 128  3,50 €"));
    }
}