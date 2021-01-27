/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asellblackjack;

/**
 * Aakash Sell
 * January 28, 2021
 * 
 * The card class that holds all the attributes of a card such as the suit, value, and type.
 */
public class Card {
    int value = 0;
    int suit = 0;
    int type = 0;
    int faceUp = -1;
    boolean isAce = false;
    
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
    
    public Card(String d){
        processSave(d);
    }
    
    //Processes the save data
    public void processSave(String d){
        String tempString = d;
        type = Integer.parseInt(tempString.substring(1));
        suit = Character.getNumericValue(tempString.charAt(0));
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
    public boolean isFaceUp(){
        
        if(faceUp == 0){
            return false;
        }else{
            return true;
        }
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
    
    //Sets the car to face up
    public void setFaceUp(){
        faceUp = 1;
    }   
    
    //Change the value of a card. Meant exclusively for aces.
    public void setValue(int x){
        value = x;
    }
    
    //Checks if the card is an ace
    public boolean isAce(){
        if(getValue() == 1){
            return true;
        }else{
            return false;
        }
    }
    
    //Sets the value of the ace
    public void setAce(int i){
        setValue(i);
    }
    
    //Returns a string that can be used to rebuld the deck
    public String saveData(){
        String i = "" + suit + type;
        return i;
        
    }
}
