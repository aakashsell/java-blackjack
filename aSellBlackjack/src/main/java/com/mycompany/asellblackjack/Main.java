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
public class Main {
    public static void main(String[] args){
          Deck deck = new Deck();
        
        deck.shuffle();
        for(int i = 0; i < 104; i++){
            System.out.println(deck.getDeck()[i]);
        }
    }
}
