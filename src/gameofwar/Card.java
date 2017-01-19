/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameofwar;

/**
 *
 * @author matheus leite
 */
public class Card {
    private String faceName, suit;
    private int faceValue;
    
    /***
     * 
     * @param faceName name of the card's face
     * @param suit name of the card's suit
     * @param faceValue value hold by the card
     */
    public Card(String faceName, String suit, int faceValue) {
        this.faceName = faceName;
        setSuit(suit);
        setFaceValue(faceValue);
    }
    
    /***
     * This method will validate that the argument is hearts, 
     * spades, clubs or spades. If it is, then it will se the instance variable
     * for the class. If it is not a valid input, it will throw and exception
     * @param suit 
     */
    private void setSuit(String suit) {
        if(suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds") 
           || suit.equalsIgnoreCase("clubs") || suit.equalsIgnoreCase("spades"))
            this.suit = suit;
        else
            throw new IllegalArgumentException("Suit must be hearts, diamonds, spades or clubs");
    }
    
    /***
     * This will validate if the argument is in the range 2-14 and set the face
     * value accordingly
     * @param faceValue the value given for the card
     */
    private void setFaceValue(int faceValue) {
        if(faceValue >=2 && faceValue <=14) {
            this.faceValue = faceValue;
        } else {
            throw new IllegalArgumentException("Card must have values in the range of 2-14");
        }
        
    }
    
    /***
     * This method will return a string to represent the card
     * @return the card in a readable manner
     */
    @Override
    public String toString() {
        return this.getFaceName()+" of "+this.getSuit();
    }

    /** returns the face name attributed to the card
     * @return the faceName 
     */
    public String getFaceName() {
        return faceName;
    }

    /** returns the suit attributed to the card
     * @return the suit
     */
    public String getSuit() {
        return suit;
    }

    /** returns the face value attributed to the card
     * @return the faceValue
     */
    public int getFaceValue() {
        return faceValue;
    }
}
