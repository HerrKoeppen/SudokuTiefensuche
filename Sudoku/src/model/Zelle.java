/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Joshua, Lukas, Simon 
 */
public class Zelle {
    short wert;
    boolean statisch;
    Sudoku sdk;
    
    public Zelle(Sudoku s){
        wert = 0;
        statisch = false;
        sdk = s;
    }
    public Zelle(Sudoku s,short val){
        wert = val;
        statisch = true;
        if(val == 0) statisch = false;
        sdk = s;
    }
    
    
}
