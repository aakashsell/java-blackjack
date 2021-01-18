/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asellblackjack;

import java.util.ArrayList;

/**
 * Aakash Sell
 * January 19, 2021
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
    
}
