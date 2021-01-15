/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asellblackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author aakas
 */
public class Deck {
    
    public ArrayList<Card> unshuffledDeck;
    public ArrayList<Card> shoe;
    public int suit;
    public int value;
    public Card card;
    
    Random rand = new Random();
    
    public Deck(){
        
    }
    
    public void shuffle(int n){
       createDeck(n);
       
       shoe = new ArrayList<>();
       
       while(unshuffledDeck.isEmpty() != true){
       Card card = unshuffledDeck.get(rand.nextInt(unshuffledDeck.size()));
       
       shoe.add(card);
       unshuffledDeck.remove(card);
       }
    }
    
    
    
    public ArrayList<Card> getShoe(){
        return shoe;
        
    }
    
    
    private void createDeck(int n){
        unshuffledDeck = new ArrayList<>();
        Card card;
        for(int x = 0; x < n; x++){
            for(int s = 1; s <=4; s++){
                for(int v = 1; v <= 13; v++){
                    card = new Card(v,s, 0);
                    unshuffledDeck.add(card);
                }
            }
        }
        
    }
    
    
}
