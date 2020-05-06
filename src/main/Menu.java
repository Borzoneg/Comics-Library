package main;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.MenuException;

public class Menu {

	Scanner keyboard = new Scanner(System.in, "UTF-8");
	
	public Menu() {
	}
	
	
	public int libraryMenu(){
		int i, choice;
		String[] choices = {"Create a new library", "Load a library from a file"};
		for(i=0; i<choices.length; i++) {
			System.out.println(String.valueOf(i) + ". " + choices[i] + '\n');
		}
		choice = Integer.valueOf(keyboard.nextLine());
		return choice;
	}
	
	
	public int mainMenu() {
		int i, choice;
		String[] choices = {"Create a new library", "Load a library from a file", "Add a comic", "Remove a comic",
							"Add multiple comics of a serie", "Save library", "Exit"};
		for(i=0; i<choices.length; i++) {
			System.out.println(String.valueOf(i) + ". " + choices[i] + '\n');
		}
		choice = Integer.valueOf(keyboard.nextLine());
		return choice;
	}


	public String[] newComicGetFields() {
	    String nameOrSerie, price, issue;
	    System.out.println("Insert the name(name of the serie if is part of a serie):");
	    nameOrSerie = keyboard.nextLine();
	    System.out.println("Insert the issue(if part of a serie)");
	    issue = keyboard.nextLine();
	    System.out.println("Insert the price");
	    price = keyboard.nextLine();	
	    if(issue.length() == 0) 
		return new String[]{nameOrSerie, price};
	    return new String[]{nameOrSerie, issue, price};
	}
	
	
	public String[] loadLibraryFromFile() {
	    String sTmp[] = new String[2];
	    System.out.println("Every library you are working on will be lost, are u sure u want to continue?");
		sTmp[0] = keyboard.nextLine();
		if(sTmp[0].equals("n"))
		    return null;
		System.out.println("Insert name of the library");
		sTmp[0] = keyboard.nextLine();
		System.out.println("Insert the name of the file");
		sTmp[1] = keyboard.nextLine();
		return sTmp;	
	}


	public String newLibrary() {
		System.out.println("Insert name of the library");
		String sTmp = keyboard.nextLine();
		return sTmp;
	}


	public String[] removeComics() {
	    String sTmp;
	    ArrayList <String> listOfComics = new ArrayList<String>();
	    System.out.println("Insert the name of the comic you want to delete (press enter if have finished)");
	    while((sTmp = keyboard.nextLine()).length() > 0) {
		listOfComics.add(sTmp);
		System.out.println("Insert the name of the comic you want to delete (press enter if have finished)");
	    }
	    return (String[])listOfComics.toArray();
	}
	
	
	public Integer[] addSerieComics() {
	    String tmp;
	    ArrayList <Integer> issues = new ArrayList <Integer>();
	    System.out.println("Insert the issue of the comic");
	    tmp = keyboard.nextLine();
	    while(tmp.length()>0) {
		issues.add(Integer.valueOf(tmp));
		System.out.println("Insert the issue of the comic");
		tmp = keyboard.nextLine();
	    }
	    return ((Integer[])issues.toArray());
	}


	public boolean overwriteAlert() {
	    System.out.println("Every library you are working on will be lost, are u sure u want to continue?");
	    String sTmp = keyboard.nextLine();
	    if(sTmp.equals("n"))
		return false;
	    return true;
	    
	}

}
