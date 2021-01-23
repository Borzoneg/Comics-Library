package main;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	Scanner keyboard = new Scanner(System.in, "UTF-8");
	String tmp;
	int i, choice;
	String nameOrSerie, price, issue;
	String sTmp[] = new String[2];
	
	public Menu() {
	}


	public int libraryMenu(){
		String[] choices = {"Create a new library", "Load a library from a file"};
		for(i=0; i<choices.length; i++) {
			System.out.println(String.valueOf(i) + ". " + choices[i] + '\n');
		}
		choice = Integer.valueOf(keyboard.nextLine());
		return choice;
	}


	public int mainMenu() {
		String[] choices = {"Create a new library", "Load a library from a file", "Add a comic", "Remove a comic",
				"Add multiple comics of a serie", "Save library", "Print comics", "Print library info", "Print library's series", "Exit"};
		for(i=0; i<choices.length; i++) {
			System.out.println(String.valueOf(i) + ". " + choices[i] + '\n');
		}
		choice = Integer.valueOf(keyboard.nextLine());
		return choice;
	}


	public String[] newComicGetFields() {
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


	public String loadLibraryFromFile() {
		System.out.println("Every library you are working on will be lost, are u sure u want to continue?");
		if(keyboard.nextLine().equals("n"))
			return null;
		System.out.println("Insert the name of the file");
		tmp = keyboard.nextLine();
		return tmp;	
	}


	public String newLibrary() {
		System.out.println("Insert name of the library");
		String sTmp = keyboard.nextLine();
		return sTmp;
	}


	public List<String> removeComics() {
		ArrayList <String> listOfComics = new ArrayList<String>();
		System.out.println("Insert the name of the comic you want to delete (press enter if have finished)");
		while((tmp = keyboard.nextLine()).length() > 0) {
			listOfComics.add(tmp);
			System.out.println("Insert the name of the comic you want to delete (press enter if have finished)");
		}
		return listOfComics;
	}


	public List<String> addSerieComics() {
		int start, end, i;
		ArrayList <String> issues = new ArrayList <>();
		System.out.println("Insert the name of the serie");
		issues.add(keyboard.nextLine());
		System.out.println("Insert the price of the single issue");
		issues.add(keyboard.nextLine());
		System.out.println("Insert the starting point");
		start = Integer.valueOf(keyboard.nextLine());
		System.out.println("Insert the ending point");
		end = Integer.valueOf(keyboard.nextLine());
		for(i=start; i <= end; i++)
			issues.add(String.valueOf(i));
		return issues;
	}


	public boolean overwriteAlert() {
		System.out.println("Every library you are working on will be lost, are u sure u want to continue?");
		if(keyboard.nextLine().equals("n"))
			return false;
		return true;
	}


	public String filenameSave() {
		System.out.println("What's the name of your library?");
		return keyboard.nextLine();
	}


	public boolean addComicLoop() {
		System.out.println("Do you want to insert a new comic?");
		if(keyboard.nextLine().equals("n"))
			return false;
		return true;
	}

}
