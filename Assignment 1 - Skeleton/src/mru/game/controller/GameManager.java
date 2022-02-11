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
	ArrayList<Card> playerHand;
	ArrayList<Card> bankerHand;
	
	
	//Creating a path to other class
	AppMenu appMen;
	CardDeck Dealer;
	Card Hand;
	PuntoBancoGame PBG;
	
	//Creating variables to hold bets to save for text document
	double currentBet;
	double totalWinnings;
	String bettingOn;
	
	public GameManager() throws Exception {
		//Creating a variable to link to array/ to link to other class
		players = new ArrayList<>();
		appMen = new AppMenu();
		playerHand = new ArrayList<Card>();
		bankerHand = new ArrayList<Card>();
		Dealer = new CardDeck();
		PBG = new PuntoBancoGame();
		
		//Calling methods
		loadData();
		launchApplication();
	}

	private void launchApplication() throws Exception {
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
		
		//if the player name doesn't exist it gets newly generated with $100 to start
		if (p == null) {
			players.add(new Player(name , 100 , 0));
			
			p = SearchByName(name);
		}
		
		//calling methods in order of what's needed
		appMen.welcomeMsg(name, p.getBalance());		//welcome message that also displays the balance that is assigned to the name
		
		String choice = appMen.showGameMenu();		//taking user input which is then used for betting later
		
		playerHand.add(appMen.getCurrent());		//adding the initial cards to player and banker hands
		playerHand.add(appMen.getCurrent());
		
		bankerHand.add(appMen.getCurrent());
		bankerHand.add(appMen.getCurrent());
		
		Card c = appMen.getCurrent();		//deciding whether to draw a third card or not
		
		if(PBG.evaluateBankerDraw(playerHand, c)) {
			bankerHand.add(c);
		}
		
		if(PBG.evaluatePlayerDraw(bankerHand)) {
			playerHand.add(c);
		}
		
		currentBet = appMen.getBet(p.getBalance());		//taking user input for amount of money bet
		
		
		String winner = appMen.PBGMenu(bankerHand, playerHand);		//calling method to see who wins which is then put through 
																	//.equals methods to figure out if the user guessed correctly
		if(choice.equals(winner)) {
			for (Player pl : players) {
				if(pl.getName().equals(name)) {
					int num = pl.getNumOfWins();
					pl.setnumOfWins(num + 1);
					appMen.CongMsg(choice);
					System.out.println("You have earned two times your bet!");
					p.addFunds(2*currentBet);
				}
			}
		} else if (choice != winner) {
			appMen.SorryMsg(choice);
			System.out.println("You have lost this bet, no money was earned");
			p.subtractFunds(currentBet);
		}
		
		playerHand = new ArrayList<>();			//resetting the player and banks hands so that if the user 
		bankerHand = new ArrayList<>();			//wants a game right after the cards from the last game are shuffled
	}

	//method to open a second menu related to searching for specifics
	private void Search() throws Exception {
		char option = appMen.showSubMenu();
		
		switch (option) {
		case 't':
			Player pla = FindTopPlayer();
			appMen.showPlayer(pla);
			break;
		case 's':
			String name = appMen.promptName();		//method to ask the user for a name which is then used to search the text file to display a name, balance, number of wins
			Player ply = SearchByName(name);
			appMen.showPlayer(ply);
			break;
		case 'b':
			launchApplication();		//reseting the program to main menu
			break;
		}
	}

	private Player SearchByName(String name) {
		Player ply = null;
		
		for(Player p: players) {
			if(p.getName().equals(name)) {		//searching through the array from the given name from user input
				ply = p;
				break;
			}
		}
		return ply;
	}

	public Player FindTopPlayer() throws Exception {
		Player pla = null;
		int topP = 0;
		
		for(Player p: players) {
			if(p.getNumOfWins() > topP) { //searching through the array from the given name from user input
				topP = p.getNumOfWins();
			}
		}
		for(Player d: players) {
			if(d.getNumOfWins() == (topP))
				pla = d;
			break;
		}
		return pla;
	}

	private void Save() throws IOException {
		File info = new File(FILE_PATH);
		
		System.out.println("Thank you for playing!");
		
		if (info.exists()) {							//creating a fallback if the file doesn't exist it will be newly created
		PrintWriter pw = new PrintWriter(info);
		
		for(Player p: players) {
			pw.println(p.format());
		}
		pw.close();
		} else {
			System.out.println("Save file does not exist");
		}
		
		System.exit(0);		//ending the program
	}

	private void loadData() throws Exception {
		File info = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;
		
		if (info.exists()) {
			Scanner fileReader = new Scanner(info);			//method for reading the text file upon launch of program
			
			while(fileReader.hasNextLine()) {
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(",");
				Player p = new Player(splittedLine[0], Integer.parseInt(splittedLine[1]), Integer.parseInt(splittedLine[2]));
				players.add(p);
			}
			fileReader.close();
		}
	}
	
	
}

