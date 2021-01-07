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
public class Card {
    int value = 0;
    int suit = 0;
    
    public final static int ACE = 1;
    
    public static final int SPADES = 1;
    public static final int HEARTS = 2;
    public static final int CLUBS = 3;
    public static final int DIAMONDS = 4;
    
    public Card(int v, int s){
        value = v;
        suit = s;
    }
    
    public int getValue(){
        return value;
    }
    
    public int getSuit(){
        return suit;
    }
    
    public void printCard(){
        if(value == ACE){
            System.out.print("\nThe Ace");
        }else if(value == 2){
            System.out.print("\nThe 2");
        }else if(value == 3){
            System.out.print("\nThe 3");
        }else if(value == 4){
            System.out.print("\nThe 4");
        }else if(value == 5){
            System.out.print("\nThe 5");
        }else if(value == 6){
            System.out.print("\nThe 6");
        }else if(value == 7){
            System.out.print("\nThe 7");
        }else if(value == 8){
            System.out.print("\nThe 8");
        }else if(value == 9){
            System.out.print("\nThe 9");
        }else if(value == 10){
            System.out.print("\nThe 10");
        }else if(value == 11){
            System.out.print("\nThe Jack");
        }else if(value == 12){
            System.out.print("\nThe Queen");
        }else if(value == 13){
            System.out.print("\nThe King");
        }
        System.out.print(" of ");
        if(suit == SPADES){
            System.out.print("Spades");
        }else if(suit == HEARTS){
            System.out.print("Hearts");
        }else if(suit == CLUBS){
            System.out.print("Clubs");
        }else if(suit == DIAMONDS){
            System.out.print("Diamonds");
        }
        
    }
        
}
