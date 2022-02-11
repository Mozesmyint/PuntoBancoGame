package mru.Assignment1;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import mru.game.controller.Card;
import mru.game.controller.CardDeck;

class PuntoBancoTest {

	Card tester = new Card(5, "Diamonds");
	CardDeck myDeck = new CardDeck();
	Card currentCard = myDeck.getDeck().remove(0);
	
	@Test
	void testCard() {
		
		assertEquals("Card setters not working properly", "Diamonds", tester.getSuit());
		assertEquals("Card setters not working properly", 5, tester.getRank());
	}

	@Test
	void testCardValue() {
		
	}
	
}
