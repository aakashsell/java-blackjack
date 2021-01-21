/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asellblackjack;

import java.util.ArrayList;
import java.util.Random;

/**
 * Aakash Sell
 * January 28, 2021
 * 
 * The deck class holds an arraylist of cards and shuffles the arraylist to create a random shoe.
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
    
    //Shuffles the deck by creating a deck by adding to the deck in a random order.
    public void shuffle(int n){
       this.createDeck(n);
       
       shoe = new ArrayList<>();
       
       while(unshuffledDeck.isEmpty() != true){
       Card tempCard = unshuffledDeck.get(rand.nextInt(unshuffledDeck.size()));
       
       shoe.add(tempCard);
       unshuffledDeck.remove(tempCard);
       }
    }
    
    
    //Returns the generated shuffled shoe
    public ArrayList<Card> getShoe(){
        return shoe;
        
    }
    
    //creates the unshuffled deck that will be used to create the shoe
    private void createDeck(int n){
        unshuffledDeck = new ArrayList<>();
        Card card;
        for(int x = 0; x < n; x++){
            for(int s = 1; s <=4; s++){
                for(int v = 1; v <= 13; v++){
                    card = new Card(v,s,0);
                    unshuffledDeck.add(card);
                }
            }
        }
        
    }
    
    
}
