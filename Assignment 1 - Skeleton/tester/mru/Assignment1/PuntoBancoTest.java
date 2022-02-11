package mru.Assignment1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import mru.game.controller.Card;
import mru.game.controller.CardDeck;
import mru.game.controller.PuntoBancoGame;
import mru.game.model.Player;
import mru.game.view.AppMenu;

class PuntoBancoTest {

	Card tester = new Card(5, "Diamonds");
	CardDeck myDeck = new CardDeck();
	Card currentCard = myDeck.getDeck().remove(0);
	ArrayList<Card> playerHand = new ArrayList<>();;
	ArrayList<Card> bankerHand = new ArrayList<>();;
	AppMenu appMen = new AppMenu();
	PuntoBancoGame PBG;
	Player player = new Player("Jason", 100, 0);
	
	@Test
	void testCard() {
		assertEquals("Card setters not working properly", "Diamonds", tester.getSuit());
		assertEquals("Card setters not working properly", 5, tester.getRank());
	}

	@Test
	void testCardSuit() {
		Card suit = new Card(0, "Spades");
		assertEquals("String assignment not working properly", "Spades", suit.getSuit());
		
	}
	
	@Test
	void testCardValue() {
		Card value = new Card(9, null);
		assertEquals("Card setters not working properly", 9, value.getRank());
		
	}
	
	@Test
	void testInitialHand() {
		playerHand.add(appMen.getCurrent());
		playerHand.add(appMen.getCurrent());
		
		
		assertEquals("Drawing method not working properly", 2, playerHand.size());
		
	}
	
	
	@Test
	void testDeckShuffle() {
		CardDeck CreateTest = new CardDeck();
		
		assertNotEquals(CreateTest.getDeck(), myDeck.getDeck());
		
	}
	
	@Test
	void testDrawSameCard() {
		
		Card current1 = myDeck.getDeck().get(0);
		Card current2 = myDeck.getDeck().get(5);
		
		
		
		assertFalse(current1.equals(current2));
		
	}
	
	@Test
	void testAddMoney() {
		
		player.addFunds(50);
		assertEquals(player.getBalance(),150);
		
	}
	
	@Test
	void testSubtractMoney() {
		
		player.subtractFunds(50);
		assertEquals(player.getBalance(),50);
		
	}
}
