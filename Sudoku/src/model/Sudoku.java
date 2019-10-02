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
    
    protected Zelle[][] werteNetz;
    protected boolean geloest, loesbar;
    private short size;
    
    public Sudoku(){
        geloest = false;
        loesbar = false;
        size = 0;
    }
    public Sudoku(short sze) {
        werteNetz = new Zelle[sze][sze];
        for(int x=0;x<sze;x++){
            for(int y=0;y<sze;y++){
                werteNetz[x][y] = new Zelle(this);
            }
        }
        geloest = false;
        loesbar = false;
        size = sze;
    }
    public Sudoku(short[][] net, short sze) {
        werteNetz = new Zelle[sze][sze];
        for(int x=0;x<sze;x++){
            for(int y=0;y<sze;y++){
                werteNetz[x][y] = new Zelle(this, net[x][y]);
            }
        }
        geloest = false;
        loesbar = false;
        size = sze;
    }
    
    public void sudokuLoesen(boolean tracePath){
        if(geloest||size < 1) return;//Abbruch bei nicht initialisiertem oder bereits gelöstem Sudoku
        short ix = 0, iy = 0; //index der momentanen Zelle
        boolean done = false;
        boolean goNext = true;//Bewegrichtung der Rekursionstiefe (in die nächste Ebene / in die vorherige raus)
                              //Benötigt, um vorgegebene Zellen überspringen zu können
        
        while(!done){
            
            if(!werteNetz[ix][iy].isStatisch()){ //überspringe vorgegebene Zellen
                if(werteNetz[ix][iy].naechsteEinsetzen(ix, iy, size)) goNext = true; //Einsetzen der nächstgrößten, einsetzbaren Zahl
                else goNext = false;                                                 //und setzen der Bewegrichtung
            }
            if(goNext){ //gehe zur nächsten Zelle
                if(ix < size-1) ix++;
                else {
                    ix = 0;
                    if(tracePath) view.Ausgabe.sudokuAusgeben(this);
                    if(iy < size-1) iy++;
                    else { //sudoku wurde gelöst
                        done = true;
                        loesbar = true;
                    }
                }
            }
            else { //gehe zur vorherigen Zelle
                if(ix > 0) ix--;
                else {
                    ix = (short)(size-1);
                    if(iy > 0) iy--;
                    else { //sudoku ist nicht lösbar
                        done = true;
                        loesbar = false;
                    }
                }
            }
        }
        geloest = true;
    }
    
    public boolean geloest(){
        return geloest;
    }
    public boolean loesbar(){
        return loesbar;
    }
    public short[][] getWerteNetz(){
        short[][] valNet = new short[size][size];
        for(short x=0;x<size;x++){
            for(short y=0;y<size;y++){
                valNet[x][y] = werteNetz[x][y].getWert();
                if(werteNetz[x][y].isStatisch()) valNet[x][y] += size+1;
            }
        }
        return valNet;
    }
    public void setWerteNetz(short[][] valNet){
        for(short x=0;x<size;x++){
            for(short y=0;y<size;y++){
                werteNetz[x][y].setWert(valNet[x][y]);
            }
        }
        geloest = false;
        loesbar = false;
    }
    public void setWerteNetz(short[][] valNet, short sze){
        werteNetz = new Zelle[sze][sze];
        for(short x=0;x<sze;x++){
            for(short y=0;y<sze;y++){
                werteNetz[x][y].setWert(valNet[x][y]);
            }
        }
        geloest = false;
        loesbar = false;
        size = sze;
    }
    public short getSize(){
        return size;
    }
}
