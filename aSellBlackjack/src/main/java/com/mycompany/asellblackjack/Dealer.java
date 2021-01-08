/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.asellblackjack;

import java.util.ArrayList;

/**
 *
 * @author aakas
 */
public class Dealer extends Player {
    
    public Dealer(){
        
    }
    
    public boolean doesHit(){
        if(handValue() < 16){
            return true;
        }
        else{
            return false;
        }
    }
    
}
