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
public class Sudoku {
    
    private Zelle[][] werteNetz;
    
    public Sudoku() {
        werteNetz = new Zelle[9][9];
        for(int x=0;x<9;x++){
            for(int y=0;y<9;y++){
                werteNetz[x][y] = new Zelle(this);
            }
        }
    }
    public Sudoku(short[][] net, short size) {
        werteNetz = new Zelle[size][size];
        for(int x=0;x<size;x++){
            for(int y=0;y<size;y++){
                werteNetz[x][y] = new Zelle(this, net[x][y]);
            }
        }
    }
    
    
}
