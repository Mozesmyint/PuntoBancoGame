package mru.Assignment1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import mru.game.controller.Card;
import mru.game.controller.CardDeck;
import mru.game.controller.PuntoBancoGame;
import mru.game.view.AppMenu;

class PuntoBancoTest {

	Card tester = new Card(5, "Diamonds");
	CardDeck myDeck = new CardDeck();
	Card currentCard = myDeck.getDeck().remove(0);
	ArrayList<Card> playerHand;
	ArrayList<Card> bankerHand;
	AppMenu appMen;
	PuntoBancoGame PBG;
	
	
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
		
		
		
	}
	
	@Test
	void testThirdCard() {
		playerHand.add(appMen.getCurrent());
		playerHand.add(appMen.getCurrent());
		if(PBG.evaluatePlayerDraw(bankerHand)) {
			playerHand.add(tester);
		}
		
		
	}
	
	@Test
	void testDeck() {
		
		
	}
	
	@Test
	void testDeckShuffle() {
		
		
	}
	
	@Test
	void testDeal() {
		
		
	}
	
	@Test
	void testDealNewHand() {
		
		
	}
	
	@Test
	void testBet() {
		
		
	}
}
