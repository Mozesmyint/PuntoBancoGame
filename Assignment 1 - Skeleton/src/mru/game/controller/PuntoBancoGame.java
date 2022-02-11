package mru.game.controller;

import java.util.ArrayList;

public class PuntoBancoGame {
	
	/**
	 * In this class you implement the game
	 * You should use CardDeck class here
	 * See the instructions for the game rules
	 */
	
	public PuntoBancoGame(){
		
	}
	
	public String whoWon(int bankerAmount, int playerAmount){

        if(playerAmount > bankerAmount){
            // player win
            return "p";
        } else if(playerAmount < bankerAmount){
            // banker win
            return "b";
        } else{
            // draw
            return "t";
        }
      }

    // Take a hand and return how many points that hand is worth
    public int handTotal(ArrayList<Card> hand){
        int total = 0;

        for(Card c : hand){
            switch(c.rank){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    total+=c.rank;
                    break;
                default:
                    // else 10,11,12,13 are 0 pts.
            }
        }

        if(total > 9){
            total = total - 10;
        }

        return total;
    }
    
    public boolean evaluateBankerDraw(ArrayList<Card> hand, Card playerCard){
        int totalCards = handTotal(hand);

        if(totalCards <= 2){ // draw another card
            return true;
        } else if((totalCards == 3) || (totalCards == 4) || (totalCards == 5) || (totalCards == 6)){ // depends if player drew 3rd card
            if(playerCard == null){
                if(totalCards <= 5)
                    return true;
                else return false;
            }

            switch(playerCard.rank){
                case 0:
                case 1:
                    if(totalCards <= 3) return true;
                    else return false;
                case 2:
                case 3:
                    if(totalCards <= 4) return true;
                    else return false;
                case 4:
                case 5:
                    if(totalCards <= 5) return true;
                    else return false;
                case 6:
                case 7:
                    if(totalCards <= 6) return true;
                    else return false;
                case 8:
                case 9:
                    if(totalCards <= 3) return true;
                    else return false;
            }
        } else {
            return false;
        }
        return false;
    }

    // will return true if player should be dealt a third card, otherwise return false
    public boolean evaluatePlayerDraw(ArrayList<Card> hand){
        int totalCards = handTotal(hand);

        if(totalCards <= 5){ // draw another card
            return true;
        } else
            return false;
    }
}

