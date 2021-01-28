/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asellblackjack;

import java.util.ArrayList;

/**
 * Aakash Sell
 * January 28, 2021
 * 
 * The child of the player class. It differentiates itself by having some automated behaviors.
 */
public class Dealer extends Player {
    
    public Dealer(){
        
    }
    
    //Checks to see if the dealer should hit based on the value of the hand.
    public boolean doesHit(ArrayList<Card> h){
        if(handValue() < 16){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Returns to show that this is not the player
    @Override
    public boolean isPlayer(){
        return false;
    }
    
    //Checks if the delaer splits and automatically splits if the dealer can
    @Override
    public boolean checkSplit(Card c){
        for(int i = 0; i < hand.size() -1; i++){
            if(hand.get(i).getValue() == c.getValue()){
                super.split();
                return true;
            }
        }
        
        return false;
    }
    
    //Gets the name of the dealer
    @Override
    public String getName(){
        if(name != null){
            return name;
        }else{
            return "Dealer";
        }
    }
    
    public void aceValue(int h){
        int value = 0;
        if(h == 1){
            value = handValue();
        }else{
            value = secondHandValue();
        }
        if((value + 9) <= 21){
            setAceToEleven();
        }
    }
    
}
