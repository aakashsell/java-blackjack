/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asellblackjack;

import java.util.Scanner;

/**
 * Aakash Sell
 * January 19, 2021
 * 
 * This class runs the game.
 */
public class Game {
    Deck deck; //The deck object;
    Player player; //The player object
    Dealer dealer; //The dealer object 
    public Game(){
        
    }
  
    //The main method that runs the game
    public static void main(String[] args){
       Game game = new Game(); //Create a new game object
       Scanner scan = new Scanner(System.in); //Create the scanner object to hand input during the game
       String playerResponse; //The variable that holds the value of the scanner when it is used.
       boolean run = true;
       while(run){
            System.out.println("Welcome to Blackjack. A game of luck and a little bit of skill. I hope you have fun!!");
            if(game.checkGameSave() == true){
                System.out.println("It looks like you have a saved game. Loading it up for you right now.");
                System.out.println("Would you like to start a new(n) game or continue(c) your old game?");
                playerResponse = scan.nextLine();
                switch (game.toChar(playerResponse)) {
                    case 'n':
                        game.printRules();
                        break;
                    case 'c':
                        System.out.println("Would you like a refresher on the rules of blackjack? y or n");
                        playerResponse = scan.nextLine();
                        if(game.toChar(playerResponse) == 'y'){
                            game.printRules();
                        }else{
                            System.out.println("Ok, you must be a master blackjack player!!");
                        }
                        break;
                    default:
                        System.out.println("There has been an error processing your response.");
                        break;
                }
                game.getGameSave();
            }else{
                game.printRules();
                game.deck = new Deck();
                game.player = new Player();
                game.dealer = new Dealer();
                game.shuffle();
                game.deal();
            }
            
            game.printHand(game.dealer);
            game.printHand(game.player);
            System.out.println("Would you like to hit(h) or stand(s)?");
            playerResponse = scan.nextLine();
           switch (game.toChar(playerResponse)) {
               case 'h':
                   System.out.println("You hit!!");
                   break;
               case 's':
                   System.out.println("You stand!!");
                   break;
               default:
                   System.out.println("There has been an error processing your response.");
                   break;
           }
           if(run == true){
               run = false;
               System.out.println("Game over loser");
           }  
       }
    }
    
    
    //Deals the initial cards to the player and the dealer
    public void deal(){
        for(int i = 0; i < 2; i++){
         
          player.addCard(deck.getShoe().remove(0));
          dealer.addCard(deck.getShoe().remove(1));
          if(i != 0){
              dealer.hand.get(1).toggleFaceUp();
          }
          
        }

    }
    
    //Adds a card to a participants hand
    private void addCard(Player p){
        p.addCard(deck.getShoe().remove(0));
    }
    
    //Makes the deck shuffle from within this class
    public void shuffle(){
        deck.shuffle(2);
        
    }
    
    //Saves the game
    private void saveGame(){}
    
    
    //Gets a save game
    private void getGameSave(){
        
    }
    
    //Checks if there is a save game
    private boolean checkGameSave(){
        
        return false;
    }
    
    
    //Prints the rules of blackjack
    private void printRules(){
        System.out.println("The goal of this game is for the point values of your cards to get as close to 21 without going over 21.");
        System.out.println("You will get both of your cards face up but you will only see the dealers first card.");
        System.out.println("The point values of the cards will be the numeric value of the card.");
        System.out.println("The only exceptions are that all face cards are valued at ten and the ace can be valued at 11 or 1, the player decided.");
        System.out.println();
    }
    
    
    //Prints the hand of the player that is passed to it
    private void printHand(Player p){
        System.out.println();
        if(p.isPlayer()){
            System.out.print("Player hand: ");
        }else{
            System.out.print("Dealer hand: ");
        }
        for(int i = 0; i < p.getHand().size(); i++){
            System.out.println(p.getHand().get(i).printCard());
        }
        System.out.println();
    }
    
    //Converts the player input into a lowercase char for easy processing
    private char toChar(String s){
        return s.toLowerCase().charAt(0);
    }
    
}
