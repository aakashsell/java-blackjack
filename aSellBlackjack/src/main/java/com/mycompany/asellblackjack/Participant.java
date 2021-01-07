/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asellblackjack;

/**d
 *
 * @author aakas
 */
public class Participant {
    
    public Card[] hand;
    
    public void hit(){
    
    }
    
    public void stand(){
        
    }
    
    public void printHand(){
        for(int i = 0; i < hand.length; i++){
            hand[i].printCard();
        }
    }
}
