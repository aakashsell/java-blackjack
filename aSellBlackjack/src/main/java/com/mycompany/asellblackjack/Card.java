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
    int type = 0;
    int faceUp = -1;
    
    public final static int ACE = 1;
    
    public static final int SPADES = 1;
    public static final int HEARTS = 2;
    public static final int CLUBS = 3;
    public static final int DIAMONDS = 4;
    
    public Card(int t, int s, int f){
        type = t;
        suit = s;
        faceUp = f;
    }
    
    public int getValue(){
        if(type >=10){
            value = 10;
        }else{
            value = type;
        }
        return value;
    }
    
    public int getSuit(){
        return suit;
    }
    
    public int getType(){
        return type;
    }
    
    public String printCard(){
        String cardInfo = "";
        if(type == ACE){
            cardInfo+= "\nThe Ace";
        }else if(type == 11){
            cardInfo+="\nThe Jack";
        }else if(type == 12){
            cardInfo+="\nThe Queen";
        }else if(type == 13){
            cardInfo+="\nThe King";
        }else{
            for(int i = 2; i <=10 ; i++){
                if(type == i){
                    cardInfo+="\n The " + i;
                }
            }
        }
        
        cardInfo+=" of ";
        if(suit == SPADES){
            cardInfo+="Spades";
        }else if(suit == HEARTS){
            cardInfo+="Hearts";
        }else if(suit == CLUBS){
            cardInfo+="Clubs";
        }else if(suit == DIAMONDS){
           cardInfo+="Diamonds";
        }
        return cardInfo;
        
    }
    
    public int isFaceUp(){
        return faceUp;
    }
    
    public void toggleFaceUp(){
        if(faceUp == 0){
            faceUp = 1;
        }else if(faceUp == 1){
            faceUp = 0;
        }else{
            
        }
    }
        
}
