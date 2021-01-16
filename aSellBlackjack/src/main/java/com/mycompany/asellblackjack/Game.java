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
       
        
         
         
    }
  
    public static void main(String[] args){
       Game game = new Game();
       game.shuffle();
       Scanner scan = new Scanner(System.in);
       boolean run = true;
       while(run){
            System.out.println("Welcome to Blackjack. A game of luck and a little bit of skill. I hope you have fun!!");
            if(game.checkGameSave() == true){
                System.out.println("It looks like you have a saved game. Loading it up for you right now.");
                game.getGameSave();
            }else{
                game.deck = new Deck();
                game.player = new Player();
                game.dealer = new Dealer();
            }
            game.deal();
            game.printHand(game.dealer);
            game.printHand(game.player);
            System.out.println("Would you like to hit(h) or stand(s)?");
            String playerMove = scan.nextLine();
            if(playerMove.toLowerCase().charAt(0) == 'h'){
                
            }else if(playerMove.toLowerCase().charAt(0) == 's'){
                
            }else{
                System.out.println("There has been an error processing your response.");
            }
             
       }
    }
    
    public void deal(){
        for(int i = 0; i < 2; i++){
         
          player.addCard(deck.getShoe().remove(0));
          dealer.addCard(deck.getShoe().remove(1));
          
        }

    }
    
    private void addCard(Player p){
        p.addCard(deck.getShoe().remove(0));
    }
    
    public void shuffle(){
        deck.shuffle(2);
        
    }
    
    private void saveGame(){}
    
    private void getGameSave(){}
    
    private boolean checkGameSave(){
        
        return false;
    }
    
    private void printRules(){
        System.out.println();
    }
    
    private void printHand(Player p){
        System.out.println();
        if(p.isPlayer()){
            System.out.print("Player hand: ");
        }else{
            System.out.print("Dealer hand: ");
        }
        for(int i = 0; i < p.getHand().size(); i++){
            System.out.print(p.getHand().get(i).printCard());
        }
        System.out.println();
    }
    
    
}
