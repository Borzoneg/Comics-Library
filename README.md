# Comics-Library

## How does it works and what's its usage:
- the user connects from his pc and start a new library;
- the user adds a comic, committing his info (name, number, series, price, ...);
- the user keeps adding comics one to one;
- the user adds a bunch of comics part of the same series (e.g: Aldo adds Spider-Man from 12 to 123);
- the user can deletes a comic he's sold or given away deleting it from the library;
- the user saves a file of his library naming it;
- the user closes the application and make himself a sandwich;
- the user comes back and open the app again;
- the user inserts the library name and the app load all the data;
- the user create a arrears list with his arrears, the program will just create a library and mark it with a 
  specific indicator to indicate that is a arrers list;
- the user export his arrears list to send it to his comic book store.

##Classes:
- **Library**  
	Main class, contains both comics and series
- **Comic**  
	Class of a single comic, used to store the info about'em
- **SerieComic**      
	Children class of comic, used to manage the comics that are part of series.  
- **Serie**  
	Contains the info about a single serie: the list of comic in that serie, sorted

##Tested function:

- Library library = new Library("My library");	
- Comic.fromStr2Comic(input0, library); *(input0 is a serie comic)*
- Comic.fromStr2Comic(input1, library); *(input1 is a graphic novel)*
- new Comic("I kill giants", 19.0, library);		
- comics.toString()
- library.addComic(c0);
- library.getTotalExpanse()
- library.getInfoString())  
  *(it return a String like NAME_OF_LIBRARY contains NUMBER_OF_COMICS for a total expanse of TOTAL_EXPANSE)*	
- library.toString())
- Comic.generateArraySerieComics("Spiderman", nums, 3.5, library);  
 *(nums is the array of issues that the user want to adds)*
	