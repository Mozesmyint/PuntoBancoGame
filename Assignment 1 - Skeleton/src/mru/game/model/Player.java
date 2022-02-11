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
	
	public Player(String name, int balance, int numofWins) {
		this.name = name;
		this.balance = balance;
		this.numOfWins = numofWins;
	}
	
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
	
	public String toString() {
		return " Name: " + name + " Balance: $" + balance + " Number of Wins: " + numOfWins;
	}
	
	public String format() {
		return name + "," + balance + "," + numOfWins;
	}
	
	public void addFunds(int funds) {
		if (funds < 0) {
			return;
		}
		
		if (funds + balance < 0) {
			balance = STARTERFUNDS;
		} else {
			balance += funds;
		}
	}
	
	public void subtractFunds(int funds) {
		if (funds < 0 || funds > balance) {		// Changes nothing if the funds are negative or exceed the balance
			return;
		}else {
			balance -= funds;
		}
	}	
}















