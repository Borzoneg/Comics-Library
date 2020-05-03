package main;

import java.util.Scanner;

import exceptions.MenuException;

public class Menu {

	Scanner keyboard = new Scanner (System.in);
	
	public Menu() {
	}
	
	
	public int welcomeGreet(){
		int i, choice;
		String[] choices = {"Create a new library", "Load a library from a file"};
		System.out.println("Welcome to comics library!\n");
		for(i=0; i<choices.length; i++) {
			System.out.println(String.valueOf(i) + ". " + choices[i] + '\n');
		}
		choice = keyboard.nextInt();
		return choice;
	}
	
	
	public int mainMenu() {
		int i, choice;
		String[] choices = {"Create a new library", "Load a library from a file", "Add a comic", "Remove a comic",
							"Add multiple comics of a serie", "Save library", "Exit"};
		for(i=0; i<choices.length; i++) {
			System.out.println(String.valueOf(i) + ". " + choices[i] + '\n');
		}
		choice = keyboard.nextInt();
		return choice;
	}


	public String getInfoOfComic() {
	    //Amazing Spiderman 703 3.50"
	    // for graphic novel: "Bone 35
	    int issue = -1;
	    System.out.println("Insert name of the comic (name of the serie if it's part of a series)");
	    String name = keyboard.nextLine();
	    System.out.println("Insert issue of the comic if is part of a serie (press enter otherwise)");
	    String sTmp1 = keyboard.nextLine();
	    if(sTmp1.length() > 0)  
		   issue = Integer.valueOf(sTmp1); 
	    System.out.println("Insert the price of the volume");
	    double price = keyboard.nextDouble();
	    // TODO: finish this one
	    
	    return null;
	}

}
