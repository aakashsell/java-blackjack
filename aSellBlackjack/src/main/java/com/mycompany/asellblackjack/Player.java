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
    public boolean doesSplit = false;
    public int aces = 0;
    public int aces2 = 0;
    public boolean stand = false;
    public boolean stand2 = false;
    
    public Player(){
        hand = new ArrayList<>();
        hand2 = new ArrayList<>();
    }
    
    public Player(ArrayList<Card> h){
        hand = h;
    }
    
    public Player(ArrayList<Card> h1, ArrayList<Card> h2){
        hand = h1;
        hand2 = h2;
    }
    
    //Makes it so the player hits
    public void hit(Card c){
       
    }
    
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
            if(hand.get(i).getValue() == c.getValue()){
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
    
    public boolean checkLose(){
        if(handValue()>21){
            return true;
        }else{
            return false;
        }
    }
    
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
}
