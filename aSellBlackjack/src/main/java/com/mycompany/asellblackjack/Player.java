/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asellblackjack;

import java.util.ArrayList;

/**
 *
 * Aakash Sell
 * January 28, 2021
 * 
 * This class holds all the information for the players such as hands and the hands' value.
 */
public class Player {
    
    public int hands = 0; 
    public ArrayList<Card> hand;
    public ArrayList<Card> hand2;
    public boolean doesSplit;
    public int aces = 0;
    public int aces2 = 0;
    public boolean stand = false;
    public boolean stand2 = false;
    public String name;
    
    public Player(){
        hand = new ArrayList<>();
        hand2 = new ArrayList<>();
        doesSplit = false;
    }
    
    public Player(String n){
        hand = new ArrayList<>();
        hand2 = new ArrayList<>();
        doesSplit = false;
        name = n;
    }
    
    
    //Makes it so the player hits
    public void hit(Card c){
       
    }
    
    //Makes it so the player stands.
    public void stand(int i){
        switch(i){
            case 1: stand = true;
                    break;
            case 2: stand2 = true;
                    break;
        }
    }
    
    //Jecks if the player stands.
    public boolean didStand(){
        return stand;
    }
    
    //Checks to see if the player is eligible to split their hand
    public boolean checkSplit(Card c){
        for(int i = 0; i < hand.size() -1; i++){
            if(hand.get(i).getValue() == c.getValue() || hand2.size() > 0){
                return true;
            }
        }
        
        return false;
    }
    
    //Adds a card to the player's hand
    public int addCard(Card card, int i){
        //if(!card.isFaceUp()){
            card.setFaceUp();
        //}
        if(i == 2){
            hand2.add(card);
            if(card.isAce){
            aces2 +=1;
            return 1;
        }
        }else{
            hand.add(card);
            if(card.isAce){
            aces +=1;
            return 1;
        }
        }
        
        return 0;
        
    }
    
   //Checks the value of the player's hand
    public int handValue(){
        
        int handValue = 0;
        for(int i = 0; i < hand.size();i++){
            handValue += hand.get(i).getValue();
        }
        
        return handValue;
    }
    
    //Checks the value of the player's second hand
    public int secondHandValue(){
        
        int handValue = 0;
        for(int i = 0; i < hand2.size();i++){
            handValue += hand2.get(i).getValue();
        }
        
        return handValue;
    }
    
    //Sees what values to use when the hand is split
    public int value(){
        if(!doesSplit){
            return handValue();
        }else{
            int returnValue = 0;
            if(secondHandValue() <= 21 && secondHandValue() >= handValue()){
                return secondHandValue();
            }else if(handValue() <= 21 && secondHandValue() <= handValue()){
                return handValue();
            }else{
                return handValue();
            }
        }   
    }
    
    //Returns the players hand
    public ArrayList<Card> getHand(){
        return hand;
    }
    
    //Returns the player's second hand in the case of a split
    public ArrayList<Card> getSecondHand(){
        return hand2;
    }
    
    //Returns that this class is the physical player
    public boolean isPlayer(){
        return true;
    }
    
   
    //A basic split method
    public void split(){
        hand2.add(hand.remove(hand.size() - 1));
        doesSplit = true;
    }
    

    
    
    //Sets the value to an ace to eleven.
    public void setAceToEleven(){
        for(int i = 0; i < hand.size();i++){
            if(hand.get(i).getValue() == 1){
                hand.get(i).setValue(11);
            }
        }
    }
    
    //Checks to see if the player loses by going over 21 poitnts
    public boolean checkLose(){
        if(handValue()>21){
            return true;
        }else{
            return false;
        }
    }
    
    
    //Returns the number of aces in the deck
    public int numAces(int h){
        int x = 0;
        if(h == 1){
            for(int i = 0; i < hand.size();i++){
                if(hand.get(i).getValue() == 1){
                    x++;
                }
            }
        }else if(h == 2){
            for(int i = 0; i < hand.size();i++){
            if(hand.get(i).getValue() == 1){
                x++;
            }
        }
        }
        
        return x;
    }
    
    
    //Returns the name of the person playing
    public String getName(){
        if(name != null){
            return name;
        }else{
            return "Player";
        }
    }
    
    //Gets the doesSplit variable
    public boolean getDoesSplit(){
        return doesSplit;
    }
}
