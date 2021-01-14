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
    
    
    public void hit(){
       
    }
    
    public void stand(){
        
    }
    
    public void split(){
        hand2 = new ArrayList<>();
    }
    
    public void addCard(Card card){
        hand.add(card);
    }
    
    public int handValue(){
        int handValue = 0;
        for(int i = 0; i < hand.size();i++){
            handValue += hand.get(i).getValue();
        }
        
        return handValue;
    }
    
}
