/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asellblackjack;

import java.util.Random;

/**
 *
 * @author aakas
 */
public class Deck {
    
    public static int shoe = 104;
    
    public Card[] deck = new Card[104];
    public int suit;
    public int value;
    public Card card;
    
    Random rand = new Random();
    
    public Deck(){
        
    }
    
    public void shuffle(){
       boolean run = true;
        int i;
        int doesExist;
        while(run){
            i = 0;
            doesExist = 0;
            suit = rand.nextInt(4);
            value = rand.nextInt(13)+1;
            card = new Card(suit, value);
            
            for(int x =0; x < deck.length; x++){
                if(deck[x] == card){
                    doesExist+=1;
                }
            }
            if(doesExist <2){
                deck[i]=(card);
                i++;
            }
            if(i >= shoe){
                run = false;
            }
        } 
        
    }
    
    public Card[] getDeck(){
        return deck;
    }
    
}
