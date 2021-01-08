/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asellblackjack;

/**
 *
 * @author aakas
 */
public class Game {
    
    Deck deck;
    Player player;
    Dealer dealer;
    
    public Game(){
        deck = new Deck();
         player = new Player();
         dealer = new Dealer();
    }
  
    public static void main(String[] args){
       Game game = new Game();
       game.shuffle();
        
    }
    
    public void deal(){
        for(int i = 0; i < 2; i++){
          Card playerCard = deck.getShoe().get(0);
          deck.getShoe().remove(playerCard);
          Card dealerCard = deck.getShoe().get(1);
          deck.getShoe().remove(dealerCard);
          player.addCard(playerCard);
          dealer.addCard(dealerCard);
          
        }

    }
    
    public void shuffle(){
        deck.shuffle(2);
        
    }
    
    
    
    
    
}
