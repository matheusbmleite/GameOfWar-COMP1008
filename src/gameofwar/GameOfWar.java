
package gameofwar;

import java.util.ArrayList;

/**
 *
 * @author matheus leite
 */
public class GameOfWar {

    private ArrayList<Card> player1Hand;
    private ArrayList<Card> player2Hand;
    
    /***
     * overriding the default constructor
     */
    public GameOfWar() {
        player1Hand = new ArrayList<Card>();
        player2Hand = new ArrayList<Card>();
        DeckOfCards deck = new DeckOfCards();
        
        deck.shuffle();
        dealCards(deck);        
    }
    
    /**
     * This method will deal all the card in the deck equally divided to each 
     * player
     * @param deck to be dealt
     */
    private void dealCards(DeckOfCards deck) {
       for (int cardNum=0; cardNum < deck.size(); cardNum++) {
           if(cardNum % 2 == 0) {
               this.player1Hand.add(deck.dealTopCard());
           } else {
               this.player2Hand.add(deck.dealTopCard());
           }
       } 
    }
    
    /**
     * This method will simulate playing the game 
     */
    public void playTheGame() {
        while(!this.player1Hand.isEmpty() && !this.player1Hand.isEmpty()) {
            playHand();
        }
        
        if(this.player1Hand.isEmpty()) {
            System.out.println("Player 2 wins!");
        } else if(this.player1Hand.isEmpty()) {
            System.out.println("Player 1 wins!");
        }
    }
    
    /**
     * This will simulate playing a "hand" in the game of war
     */
    private void playHand() {
        if(this.player1Hand.isEmpty() || this.player2Hand.isEmpty()) {
            return;
        }
        
        Card player1Card = this.player1Hand.remove(0);
        Card player2Card = this.player2Hand.remove(0);
        
        //inserting some output to see the game happening
        System.out.printf("Player 1: %s, cards in hand: %d ", player1Card, 
                this.player1Hand.size());
        System.out.printf("\tPlayer 2: %s, cards in hand: %d%n", player2Card, 
                this.player2Hand.size());
        
        if(player1Card.getFaceValue() > player2Card.getFaceValue()) {
            this.player1Hand.add(player1Card);
            this.player1Hand.add(player2Card);
        } else if (player2Card.getFaceValue() > player1Card.getFaceValue()) {
            this.player2Hand.add(player1Card);
            this.player2Hand.add(player2Card);
        } else {
            ArrayList<Card> warPile = new ArrayList<Card>();
            warPile.add(player1Card);
            warPile.add(player2Card);
            playWarHand(warPile);
        }
        
    }
    
    /**
     * This method simulates playing a "war" hand
     */
    private void playWarHand(ArrayList<Card> warPile) {
        //Check if player 1 has enough cards to play the war
        if(this.player1Hand.size() < 3) {
            this.player2Hand.addAll(this.player1Hand);
            this.player1Hand.clear();
            this.player2Hand.addAll(warPile);
            return;
        } 
        //Check if player 2 has enough cards to play the war
        if(this.player2Hand.size() < 3) {
            this.player1Hand.addAll(this.player2Hand);
            this.player2Hand.clear();
            this.player1Hand.addAll(warPile);
            return;
        }
        
        //Take 3 cards out of player 1's hand
        warPile.add(this.player1Hand.remove(0));
        warPile.add(this.player1Hand.remove(0));
        Card player1Card = this.player1Hand.remove(0);
        
        //Take 3 cards out of player 2's hand
        warPile.add(this.player2Hand.remove(0));
        warPile.add(this.player2Hand.remove(0));
        Card player2Card = this.player2Hand.remove(0);
        
        //inserting some output to see the game happening
        System.out.printf("%n%n================= WAR !!!! %n");
        System.out.printf("Player 1: %s, cards in hand: %d ", player1Card, 
                this.player1Hand.size());
        System.out.printf("\tPlayer 2: %s, cards in hand: %d%n", player2Card, 
                this.player2Hand.size());
        System.out.printf("========================== %n");
        
        //check for player1 to win
        if(player1Card.getFaceValue() > player2Card.getFaceValue()) {
            this.player1Hand.addAll(warPile);
            this.player1Hand.add(player1Card);
            this.player1Hand.add(player2Card);
        } //check for player2 to win
        else if(player2Card.getFaceValue() > player1Card.getFaceValue()) {
            this.player2Hand.addAll(warPile);
            this.player2Hand.add(player1Card);
            this.player2Hand.add(player2Card);
        }//otherwise we must have another war
        else {
            warPile.add(player1Card);
            warPile.add(player2Card);
            this.playWarHand(warPile);
        }
        
       
    }
    
}
