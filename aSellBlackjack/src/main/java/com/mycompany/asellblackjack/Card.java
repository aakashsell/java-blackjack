/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asellblackjack;

/**
 *
 * @author aakas
 */
public class Card {
    int value = 0;
    int suit = 0;
    int type = 0;
    int faceUp = -1;
    
    public final static int ACE = 1;
    public static final int SPADES = 1;
    public static final int HEARTS = 2;
    public static final int CLUBS = 3;
    public static final int DIAMONDS = 4;
    
    public Card(int t, int s, int f){
        type = t;
        suit = s;
        faceUp = f;
    }
    
    //Returns the value of the Card in terms of the points it represents
    public int getValue(){
        if(type >=10){
            value = 10;
        }else{
            value = type;
        }
        return value;
    }
    
    //Returns the suit of the card
    public int getSuit(){
        return suit;
    }
    
    //Returns what the type the card is
    public int getType(){
        return type;
    }
    
    //Returns info about the card so the info can be printed in the game class
    public String printCard(){
        if(faceUp != 0){
            String cardInfo = "";
            if(type == ACE){
                cardInfo+= "\nThe Ace";
            }else if(type == 11){
                cardInfo+="\nThe Jack";
            }else if(type == 12){
                cardInfo+="\nThe Queen";
            }else if(type == 13){
                cardInfo+="\nThe King";
            }else{
                for(int i = 2; i <=10 ; i++){
                    if(type == i){
                        cardInfo+="\n The " + i;
                    }
                }
            }

            cardInfo+=" of ";
            if(suit == SPADES){
                cardInfo+="Spades";
            }else if(suit == HEARTS){
                cardInfo+="Hearts";
            }else if(suit == CLUBS){
                cardInfo+="Clubs";
            }else if(suit == DIAMONDS){
               cardInfo+="Diamonds";
            }
            return cardInfo;
        }else{
            return "This card is face down";
        }
        
    }
    
    //Checks to see if the card is face up. 0 is face down, 1 is face up
    public int isFaceUp(){
        return faceUp;
    }
    
    //toggles the card between face up and face down
    public void toggleFaceUp(){
        if(faceUp == 0){
            faceUp = 1;
        }else if(faceUp == 1){
            faceUp = 0;
        }else{
            
        }
    }
        
}
