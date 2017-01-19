/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameofwar;

import java.util.ArrayList;

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
}
