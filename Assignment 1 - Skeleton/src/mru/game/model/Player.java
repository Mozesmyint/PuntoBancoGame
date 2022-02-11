package mru.game.model;

public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	
	String name;
	int balance;
	int numOfWins;
	
	int STARTERFUNDS = 100;
	
	//creating constructor
	public Player(String name, int balance, int numofWins) {
		this.name = name;
		this.balance = balance;
		this.numOfWins = numofWins;
	}
	
	//getters and setters for later usage
	public String getName() {
		return name;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public int getNumOfWins() {
		return numOfWins;
	}
	
	public void setName(String Name) {
		this.name = Name;
	}
	
	public void setBalance(int Balance) {
		this.balance = Balance;
	}
	
	public void setnumOfWins(int numOfWins) {
		this.numOfWins = numOfWins;
	}
	
	//formatting for when user information is called
	public String toString() {
		return " Name: " + name + " Balance: $" + balance + " Number of Wins: " + numOfWins;
	}
	
	//formatting for how information gets saved
	public String format() {
		return name + "," + balance + "," + numOfWins;
	}
	
	public void addFunds(double funds) {		//used to add money to balance for when the user wins a bet
		if (funds < 0) {
			return;
		}
		
		if (funds + balance < 0) {
			balance = STARTERFUNDS;
		} else {
			balance += funds;
		}
	}
	
	public void subtractFunds(double currentBet) {			//used to subtract money to balance for when the user loses a bet
		if (currentBet < 0 || currentBet > balance) {
			return;
		}else {
			balance -= currentBet;
		}
	}	
}















