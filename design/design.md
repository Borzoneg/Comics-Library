# Comics library

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
- ####Library
	- ######Methods:
		- **Library**()  
			basic constructor, the library get initialized empty

		- **Library**(filename: String): Library  
			basic constructor, the library get initialized with the contents of the file
				
		- **toString**(): String  
			return the whole library as a string to print it.

		- **getNComics**(): int  
			return the number of comics in the library

		- **getName**(): String  
			return the name of the library

		- **addComic**(comic: Comic): void  
			add the comic (Comic object) in the library

		- **addComics**(comics: Comics[n]): void  
			add the n comics (array of comic object) to the library

		- **saveLibrary**(name: String): void  
			save the library as a txt file with the given name

	- ######Attributes:
		- **name**: String  
			the name of the library

		- **nComics**: int   
			the number of comics in the library

		- **comics**: Comic[]  
			the array of comics in the library
	
		- **totalExpanse**: float  
			total cost of the library

- ####Comic
	- ######Methods:
		- **Comic**(name : String,  price : float, library : Library)  
			basic constructor, the comic require all the parameters
				
		- **Comic**(formattedString: String)  
			constructor based on a string
		
		- **toString**(): String  
			return the comic as a string to print it

		- **fromStr2Comic**(formattedString : String, library : Library): Comic  
			return the comic extracted from the string, uses the constructo of Comi and SerieComic, *it is a statitc method*

	- ######Attributes:
		- **name**: String  
			the name of the library
	
		- **price**: float    
			the price of the comic

		- **library**: Library  
			the library the comic is part of

- ####SerieComic    
	children class of comic, used to manage the comics that are part of series.  
	- ######Methods:
		- **SerieComic**(name : String,serie : Serie, issue : int, price : float, date : Date, library : Library)  
			basic constructor for the class

	- ######Attributes other the inherithed ones:
		- **serie**: Serie  
			the serie is part of
		
		- **issue**: int  
			the number of the series the comic is 
		
		- **date**: Date  
			the release date of the comic


- ####Serie
	- ######Methods:
		- **Serie**(name : String)  
			basic constructor, the Serie get initialized with the name and 0 comics
				
		- **toString**(): String  
			return all the comics added to the serie from the user as a string to print it.

		- **getNComics**(): int  
			return the number of the comics inserted by the user in the serie 

	- ######Attributes:
		- **name**: String  
			the name of the library

		- **nComics**: Serie     
			number of comics in the series (and in the library)