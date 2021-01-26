 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asellblackjack;

import java.util.Scanner;

/**
 * Aakash Sell
 * January 28, 2021
 * 
 * This class runs the game
 */
public class Game {
    Deck deck; //The deck object;
    Player player; //The player object
    Dealer dealer; //The dealer object 
    Scanner scan = new Scanner(System.in); //Create the scanner object to hand input during the game.
    String playerResponse; //The variable that holds the value of the scanner when it is used.
    boolean run = false;
    public Game(){
        
    }
  
    //The main method that runs the game
    public static void main(String[] args){
       Game game = new Game(); //Create a new game object
       game.run();
    }
    
    public void run(){
       run = true;
       System.out.println("Welcome to Blackjack. A game of luck and a little bit of skill. I hope you have fun!!");
       startGame();
       printHand(dealer);
       printHand(player);
       while(run){
           
            
            if(!didStand(player)){
                printHand(player);
                playerTurn(); 
            }else if(!didStand(dealer)){
                printHand(dealer);
                dealerTurn();
            }else{
                whoWin();
            }
            
           if(deck.getShoe().size() < 11){
               run = false;
           }
       }
    }
    
    
    public void startGame(){
        if(checkGameSave() == true){
                System.out.println("It looks like you have a saved game. Loading it up for you right now.");
                System.out.println("Would you like to start a new(n) game or continue(c) your old game?");
                playerResponse = scan.nextLine();
                switch (toChar(playerResponse)) {
                    case 'n':
                        printRules();
                        break;
                    case 'c':
                        System.out.println("Would you like a refresher on the rules of blackjack? y or n");
                        playerResponse = scan.nextLine();
                        if(toChar(playerResponse) == 'y'){
                            printRules();
                        }else{
                            System.out.println("Ok, you must be a master blackjack player!!");
                        }
                        break;
                    default:
                        System.out.println("There has been an error processing your response.");
                        break;
                }
                getGameSave();
            }else{
               printRules();
               reset();
            }
    }
    
    public void playerTurn(){
        
        System.out.println("Would you like to hit(h) , stand(s) or fold(f)?");
           playerResponse = scan.nextLine();
           switch (toChar(playerResponse)) {
               case 'h':
                   System.out.println("You hit!!");
                   addCard(player);
                   printHand(player);
                   break;
               case 's':
                   System.out.println("You stand!!");
                   player.stand();
                   printHand(player);
                   break;
               case 'f':
                   System.out.println("I guess game over. Good job");
                   run = false;
                   break;
               default:
                   System.out.println("There has been an error processing your response.");
                   break;
           }
           
           if(player.checkLose() == true){
               System.out.println("It appears that you have gone over 21. You lose!");
               run = playAgain();
           }
    }
    
    //Deals the initial cards to the player and the dealer
    public void deal(){
        for(int i = 0; i < 2; i++){
         
          player.addCard(deck.getShoe().remove(0), 1);
          dealer.addCard(deck.getShoe().remove(1), 1);
          if(i != 0){
              dealer.hand.get(1).toggleFaceUp();
          }
          
        }

    }
    
    //Adds a card to a participants hand
    private void addCard(Player p){
        Card tempCard = deck.getShoe().remove(0);
        tempCard.setFaceUp();
        int i;
        System.out.println("New card: ");
        System.out.println(tempCard.printCard());
        if(p.checkSplit(tempCard) ==  true){
            if(p.isPlayer() == true){
                System.out.println("It appears as this is the second card in your hand with this value, would you like to split your hand? y or n");
                playerResponse = scan.nextLine();
                if(toChar(playerResponse) == 'y'){
                    System.out.println("Ok, splitting your hand right now.");
                    i = p.addCard(tempCard, 2);
                    if(i == 1){
                        System.out.println("This card is an ace. That means it can have a value of either 1 or 11");
                    }
                }else{
                    i = p.addCard(tempCard, 1);
                    if(i == 1){
                        System.out.println("This card is an ace. That means it can have a value of either 1 or 11");
                    }
                }
            }else{
                i = p.addCard(tempCard, 1);
            }
        }else{
            p.addCard(tempCard, 1);
        }
        
    }
    
    //Makes the deck shuffle from within this class
    private void shuffle(){
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
        if(p.doesSplit == true){
            if(p.isPlayer()){
            System.out.print("Player Second hand: ");
            }else{
            System.out.print("Dealer Second hand: ");
            }
            for(int i = 0; i < p.getSecondHand().size(); i++){
            System.out.println(p.getSecondHand().get(i).printCard());
            }
        }
        System.out.println();
    }
    
    //Converts the player input into a lowercase char for easy processing
    private char toChar(String s){
        return s.toLowerCase().charAt(0);
    }
    
    private void dealerTurn(){
        if(dealer.handValue() <= 16){
            System.out.println("The dealer hits this round");
            addCard(dealer);
            printHand(dealer);
            
        }else if(dealer.handValue() > 16){
            System.out.println("The dealer stands");
            dealer.stand();
            printHand(dealer);
        }
        if(dealer.checkLose() == true){
               System.out.println("It appears that the dealer has lost. You win!");
               run = playAgain();
           }
    }
    
    private boolean playAgain(){
        String playerResponse;
        System.out.println("Would you like to play again? y or n");
        playerResponse = scan.nextLine();
        if(toChar(playerResponse) == 'y'){
            reset();
            return true;
        }else{
            return false;
        }
    }
    
    private void reset(){
         deck = new Deck();
         player = new Player();
         dealer = new Dealer();
         shuffle();
         deal();
    }
    
    private boolean didStand(Player p){
        return p.didStand();
    }
    
    private void whoWin(){
        if(player.handValue() > dealer.handValue()){
            System.out.println("You won the game good job.");
        }else{
            System.out.println("Oh no. You lost.");
        }
        run = playAgain();
    }
    
}
