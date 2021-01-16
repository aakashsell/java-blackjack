/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asellblackjack;

import java.util.ArrayList;

/**
 *
 * @author aakas
 */
public class Player {
    
    public int hands = 0; 
    public ArrayList<Card> hand;
    public ArrayList<Card> hand2;
    
    public Player(){
        hand = new ArrayList<>();
    }
    
    public Player(ArrayList<Card> h){
        hand = h;
    }
    
    public Player(ArrayList<Card> h1, ArrayList<Card> h2){
        hand = h1;
        hand2 = h2;
    }
    
    
    public void hit(){
       
    }
    
    public void stand(){
        
    }
    
    public void split(){
        hand2 = new ArrayList<>();
    }
    
    public void addCard(Card card){
        if(!card.isFaceUp()){
            card.toggleFaceUp();
        }
        hand.add(card);
    }
    
    public int handValue(){
        int handValue = 0;
        for(int i = 0; i < hand.size();i++){
            handValue += hand.get(i).getValue();
        }
        
        return handValue;
    }
    
    public ArrayList<Card> getHand(){
        return hand;
    }
    
    
    public boolean isPlayer(){
        return true;
    }
}
