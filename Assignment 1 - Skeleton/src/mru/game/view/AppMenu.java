package mru.game.view;

import java.util.Scanner;

import mru.game.model.Player;

public class AppMenu {

	/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 */
	
	Scanner input;
	
	public AppMenu() {
		input = new Scanner(System.in);
	}
	
	public int showMainMenu() {
		System.out.println("Select one option:\n");
		System.out.println("\t1. Play Game");
		System.out.println("\t2. Search");
		System.out.println("\t3. Save and Exit\n");
		System.out.print("Enter a number here: ");
		int option = input.nextInt();
		
		input.nextLine();
		
		return option;
		}
	
	public char showSubMenu() {
		System.out.println("Select one option:\n");
		System.out.println("\t(T) Top Player");
		System.out.println("\t(S) Search by Name");
		System.out.println("\t(B) Back to Main Menu\n");
		System.out.print("Enter a Character here: ");
		char option = input.nextLine().toLowerCase().charAt(0);
		return option;
	}
	
	public String promptName() {
		System.out.print("Enter a name here: ");
		String name = input.nextLine();
		return name;
	}
	
	public void showPlayer(Player ply) {
		System.out.println(ply);
	}

	public String promptId() {
		System.out.print("Enter your id here: ");
		String id = input.nextLine();
		return id;
	}
	
	
}

