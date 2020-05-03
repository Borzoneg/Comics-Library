package main;

import java.util.Scanner;

import comicslibrary.*;
import exceptions.MenuException;

public class Application {

	public static void main(String[] args) {
		int choice;
		Menu menu = new Menu();
		String sTmp1, sTmp2;
		Scanner keyboard = new Scanner (System.in);
		
		choice = menu.welcomeGreet();
		while(choice != 0 && choice != 1) 
		    choice = menu.welcomeGreet();
		
		if(choice == 0) { // new library case
		    System.out.println("Inserisci il nome della libreria");
		    sTmp1 = keyboard.nextLine();
		    Library library = new Library(sTmp1);
		}
		
		if(choice == 1) { // new library case from file
		    System.out.println("Inserisci il nome della libreria");
		    sTmp1 = keyboard.nextLine();
		    System.out.println("Inserisci il nome del file");
		    sTmp2 = keyboard.nextLine();
		    Library library = new Library(sTmp1, sTmp2);
		}
		
		/**
		 * TODO: Ciclo continuo di menu.mainMenu();
		 */
		
	}
}
