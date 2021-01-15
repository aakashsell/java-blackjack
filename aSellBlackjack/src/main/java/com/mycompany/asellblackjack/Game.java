/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asellblackjack;

import java.util.Scanner;

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
       Scanner scanner = new Scanner(System.in);
       boolean run = true;
       while(run){
            System.out.println("Welcome to Blackjack. A game of luck and a little bit of skill. I hope you have fun!!");
            if(game.checkGameSave() == true){
                System.out.println("It looks like you have a saved game. Loading it up for you right now.");
                game.getGameSave();
            }
            game.deal();
            game.printHand(game.dealer);
            game.printHand(game.player);
            run = false;
             
       }
    }
    
    public void deal(){
        for(int i = 0; i < 2; i++){
         
          player.addCard(deck.getShoe().remove(1));
          dealer.addCard(deck.getShoe().remove(2));
          
        }

    }
    
    public void shuffle(){
        deck.shuffle(2);
        
    }
    
    private void saveGame(){}
    
    private void getGameSave(){}
    
    private boolean checkGameSave(){
        
        return false;
    }
    
    private void printHand(Player p){
        if(p.isPlayer()){
            System.out.println("Player hand: ");
        }else{
            System.out.println("Dealer hand: ");
        }
        String cards = "";
        for(int i = 0; i < p.getHand().size(); i++){
            cards += p.getHand().get(i).toString();
        }
        System.out.println(cards);
    }
    
    
}
