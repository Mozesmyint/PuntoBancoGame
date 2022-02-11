package mru.game.view;

import java.util.ArrayList;
import java.util.Scanner;

import mru.game.controller.Card;
import mru.game.controller.CardDeck;
import mru.game.controller.PuntoBancoGame;
import mru.game.model.Player;

public class AppMenu {

	/**
	 * This class will be used to show the menus and sub menus to the user
	 * It also prompts the user for the inputs and validates them 
	 */
	
	Scanner input;
	
	CardDeck myDeck = new CardDeck();
	Card currentCard = myDeck.getDeck().remove(0);
	PuntoBancoGame PBG = new PuntoBancoGame();
	int i = 0;
	
	public AppMenu() {
		input = new Scanner(System.in);
	}
	
	public int showMainMenu() {
		System.out.println("Select one option:\n");
		System.out.println("\t1. Play Game");
		System.out.println("\t2. Search");
		System.out.println("\t3. Save and Exit\n");
		System.out.print("Enter a number here: ");
		
		String option = input.next();
		
		while(!option.equals("1") && !option.equals("2") && !option.equals("3")) {
			System.out.print("Invalid response, Please enter a number here: ");
			option = input.next();
			
		}
		return Integer.parseInt(option);
	}
	
	public char showSubMenu() {
		System.out.println("Select one option:\n");
		System.out.println("\t(T) Top Player (Most number of wins)");
		System.out.println("\t(S) Search by Name");
		System.out.println("\t(B) Back to Main Menu\n");
		System.out.print("Enter a Character here: ");
		char option = input.next().toLowerCase().charAt(0);
		
		while((option!='t') && (option!='s') && (option!='b')) {
			System.out.print("Invalid response, Please enter a valid character here: ");
			option = input.next().toLowerCase().charAt(0);
			
		}
		return option;
	}
	
	public String showGameMenu() {
		
		System.out.println("Who do you want to bet on?\n");
		System.out.println("\t(P) Player wins");
		System.out.println("\t(B) Banker wins");
		System.out.println("\t(T) Tie game\n");
		System.out.print("Enter your choice: ");
		String option = input.next().toLowerCase();
		
		while(!option.equals("p") && !option.equals("b") && !option.equals("t")) {
			System.out.print("Invalid response, Please enter a valid character here: ");
			option = input.next().toLowerCase();
			
		}
		return option;
	}
	
	public void welcomeMsg(String name, int bal) {
		System.out.println("***********************************************************************************\n"
				+          "***		Welcome " + name + "   ---   Your initial balance is: $" + bal + "		***\n"
				+          "***********************************************************************************\n");
	}
	
	public Card getCurrent() {
		Card current = currentCard;
		currentCard = myDeck.getDeck().remove(i++);
		
		return current;
	}
	
	public String PBGMenu(ArrayList<Card> hand1, ArrayList<Card> hand2) {
		
		int playerTotal = PBG.handTotal(hand2);
		int bankerTotal = PBG.handTotal(hand1);
		
		int maximum = Math.max(hand1.size(), hand2.size());
		
		System.out.println("                                  - PUNTO BANCO -                                  \n"
				 + 		   "+========================================+========================================+\n"
				 +         "||PLAYER                                 |BANKER                                 ||\n"
				 +         "+========================================+========================================+");
		
		for(int i = 0; i < maximum; i++) {
			String player = "";
			String banker = "";
			String line = "||";
			if(hand2.size() > i) {
				player += hand2.get(i).toString();
			}
			line += player;
			for(int j = 0; j < 39 - player.length(); j++) {
				line += " ";
			}
			line += "|";
			if(hand1.size() > i) {
				banker += hand1.get(i).toString();
			}
			line += banker;
			for(int j = 0; j < 39 - banker.length(); j++) {
				line += " ";
			}
			line += "||";
			
			
			System.out.println(line);
			System.out.println("+========================================+========================================+");
		}
			
		
		System.out.println(
				           "||PLAYER:"+playerTotal+"                               |BANKER:"+bankerTotal+"                               ||\n"
                 +         "+========================================+========================================+");
	
	
		return PBG.whoWon(bankerTotal, playerTotal); 
	
	}
	
	public void TopMenu() {
		
	}

	public void CongMsg(String choice) {
		String Name = null;
		
		if(choice.equals("b")) {
			Name = "Banker";
		} else if (choice.equals("p")) {
			Name = "Player";
		}
		System.out.println("Congrats, you bet " + Name + "! You won your bet!");
	}
	
	public void SorryMsg(String choice) {
		String Name = null;
		
		if(choice.equals("b")) {
			Name = "Banker";
		} else if (choice.equals("p")) {
			Name = "Player";
		}
		System.out.println("Sorry, you bet " + Name + "! You lost your bet!");
	}
	
	public void topPlayer(Player ply) {
		System.out.println(ply);
	}
	
	public String promptName() {
		System.out.print("Enter a name here: ");
		String name = input.next();
		return name;
	}
	
	public void showPlayer(Player ply) {
		System.out.println(ply);
	}
	
	public int getBet(int playerBalance) {
		int bet = 0;
		
		System.out.println("How much would you like to bet?");
		bet = input.nextInt();
		
		if (bet < 0) {
			System.out.println("You can't bet a negative amount therefore, the bet will be defaulted to $0.00");
			bet = 0;
		}
		if (bet > playerBalance) {
			System.out.println("You don't have enough money to bet this amount therefore, your entire balance will be bet instead");
			bet = playerBalance;
		}
		
		return bet;
	}
}

