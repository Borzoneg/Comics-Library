package main;

import java.util.Scanner;

public class Menu {

	Scanner keyboard = new Scanner (System.in);
	
	public Menu() {
	}
	
	
	public int welcomeGreet() {
		int i, choice;
		String[] choices = {"Creare una nuova librearia", "Caricare una libreria da un file"};
		System.out.println("Benvenuto su comics library!\n");
		for(i=0; i<choices.length; i++) {
			System.out.println(String.valueOf(i) + ". " + choices[i] + '\n');
		}
		choice = keyboard.nextInt();
		return choice;
	}
	
	
	public int mainMenu() {
		int i, choice;
		String[] choices = {"Creare una nuova librearia", "Caricare una libreria da un file", "Aggiungere un fumetto", "Rimuovere un fumetto",
							"Aggiungere più fumetti appartenenti a una serie", "Salva libreria", "Esci"};
		for(i=0; i<choices.length; i++) {
			System.out.println(String.valueOf(i) + ". " + choices[i] + '\n');
		}
		choice = keyboard.nextInt();
		return choice;
	}

}
