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

}
