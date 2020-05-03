package main;

import java.util.Scanner;

import comicslibrary.*;
import exceptions.MenuException;

public class Application {

	public static void main(String[] args) {
		int choice;
		Menu menu = new Menu();
		Comic comic;
		Library library;
		String sTmp1, sTmp2;
		Scanner keyboard = new Scanner (System.in);
		
		choice = menu.welcomeGreet();
		while(choice != 0 && choice != 1) 
		    choice = menu.welcomeGreet();
		
		if(choice == 0) { // new library case
		    System.out.println("Insert name of the library");
		    sTmp1 = keyboard.nextLine();
		    library = new Library(sTmp1);
		}
		
		if(choice == 1) { // new library case from file
		    System.out.println("Insert name of the library");
		    sTmp1 = keyboard.nextLine();
		    System.out.println("Insert the name of the file");
		    sTmp2 = keyboard.nextLine();
		    library = new Library(sTmp1, sTmp2);
		}
		
		while((choice = menu.mainMenu()) != 7) {
		    if(choice < 0 || choice > 7)
			continue;
		    switch(choice) {
		    case 0:
			System.out.println("Every library you are working on will be lost, are u sure u want to continue?");
			sTmp1 = keyboard.nextLine();
			if(sTmp1.equals("n"))
			    continue;
			System.out.println("Insert name of the library");
			sTmp1 = keyboard.nextLine();
			library = new Library(sTmp1);
			break;
		    
		    case 1:
			System.out.println("Every library you are working on will be lost, are u sure u want to continue?");
			sTmp1 = keyboard.nextLine();
			if(sTmp1.equals("n"))
			    continue;
			System.out.println("Insert name of the library");
			sTmp1 = keyboard.nextLine();
			System.out.println("Insert the name of the file");
			sTmp2 = keyboard.nextLine();
			library = new Library(sTmp1, sTmp2);
			break;
			
		    case 2:
			sTmp1 = menu.getInfoOfComic();
			break;
			
		    case 3:
			break;
			
		    case 4:
			break;
			
		    case 5:
			break;
			
		    case 6:
			break;
		
		    }
		}
		
	}
}
