package mru.game.model;

public class Player {
	
	/**
	 * This class represent each player record in the Database
	 * It is basically a model class for each record in the txt file
	 */
	
	String name;
	String id;
	int numOfWins;
	
	public Player(String name, String id, int numofWins) {
		this.name = name;
		this.id = id;
		this.numOfWins = numofWins;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setNumOfWins(int numOfWins) {
		this.numOfWins = numOfWins;
	}
	
	public int getNumOfWins() {
		return numOfWins;
	}
	
	public String toString() {
		return "Name: " + name + "ID: " + id + "Number of Wins: " + numOfWins;
	}
	
	public String format() {
		return name + ";" + id + ";" + numOfWins;
	}
}
