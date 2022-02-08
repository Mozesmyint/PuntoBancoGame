package mru.game.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.game.model.Player;
import mru.game.view.AppMenu;

public class GameManager {
	
	/* In this class toy'll need these methods:
	 * A constructor
	 * A method to load the txt file into an arraylist (if it exists, so you check if the txt file exists first)
	 * A save method to store the arraylist into the the txt file 
	 * A method to search for a player based their name
	 * A method to find the top players
	 * Depending on your designing technique you may need and you can add more methods here 
	 */
	
	
	//Initializing a path to the file for the list of players 
	private final String FILE_PATH = "res/CasinoInfo.txt";
	
	//Creating the array to store the said players so that the program can grab the values from the array rather than reading the text file again
	ArrayList<Player> players;
	
	//Creating a path to other class
	AppMenu appMen;
	
	public GameManager() throws Exception {
		//Creating a variable to link to array/ to link to other class
		players = new ArrayList<>();
		appMen = new AppMenu();
		
		//Calling methods
		loadData();
		lunchApplication();
	}

	private void lunchApplication() throws IOException {
		//Creating a loop whereby the program will keep running as long as the user wants, menu of this is in appMenu(showMainMenu)
		boolean flag = true;
		int option;
		
		while(flag) {
			option = appMen.showMainMenu();
			
			switch(option) {
			case 1:
				playGame();
				break;
			case 2:
				Search();
				break;
			case 3:
				Save();
				flag = false;
			}
		}
		
	}

	private void playGame() {
		String name = appMen.promptName();
		Player p = SearchByName(name);
		
		if (p == null) {
			String id = appMen.promptId();
			players.add(new Player(name , id , 0));
		}
	}

	private void Search() {
		char option = appMen.showSubMenu();
		
		switch (option) {
		case 't':
			FindTopPlayer();
			break;
		case 's':
			String name = appMen.promptName();
			Player ply = SearchByName(name);
			appMen.showPlayer(ply);
			break;
		case 'b':
			
			break;
		}
		
	}

	private Player SearchByName(String name) {
		Player ply = null;
		
		for(Player p: players) {
			if(p.getName().equals(name)) {
				ply = p;
				break;
			}
		}
		return ply;
	}

	private void FindTopPlayer() {
		// TODO Auto-generated method stub
		
	}

	private void Save() throws IOException {
		File info = new File(FILE_PATH);
		PrintWriter pw = new PrintWriter(info);
		
		for(Player p: players) {
			pw.println(p.format());
		}
		pw.close();
	}

	private void loadData() throws Exception {
		File info = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;
		
		if (info.exists()) {
			Scanner fileReader = new Scanner(info);
			
			while(fileReader.hasNextLine()) {
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(";");
				Player p = new Player(splittedLine[0], splittedLine[1], Integer.parseInt(splittedLine[2]));
				players.add(p);
			}
			fileReader.close();
		}
	}

}
