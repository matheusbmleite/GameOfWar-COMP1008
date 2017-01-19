package gameofwar;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author matheus leite
 */
public class DeckOfCards {
    private ArrayList<Card> deck;
    
    public DeckOfCards() {
        this.deck = new ArrayList<Card>();
        
        String[] suits = {"spades", "clubs", "hearts", "diamonds"};
        String[] faceNames = {"two", "three", "four", "five", "six", "seven", 
                              "eight", "nine", "ten", "jack", "queen", "king"};
        for(String suit : suits) {
            for(int i = 0; i < faceNames.length; i++) {
                this.deck.add(new Card(faceNames[i], suit, i+2));
            }
        }
    }

    @Override
    public String toString()
    {
        String deckString="";
        for (Card card : deck)
        {
            deckString += card.toString() + "\n";
        }
        return deckString;
    }
    
    /**
     * This method will shuffle the deck of cards, changing the current position
     * of the cards
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }
    
    /**
     * Returns the size of the deck
     * @return an integer holding the size
     */
    public int size() {
        return this.deck.size();
    }
    
    /**
     * This method will "deal" the top card off the deck
     * @return a Card object
     */
    public Card dealTopCard() {
        return deck.remove(0);
    }
    
    

}


