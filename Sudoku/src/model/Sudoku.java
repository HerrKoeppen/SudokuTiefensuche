/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Joshua, Lukas, Simon
 */
public class Sudoku {
    
    private int anzBlaetter = 1;//statistische Variablen
    private int anzKnoten = 0;
    private int anzRekAuf = 0;
    
    private String graph = "";
    
    
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
    
    public void sudokuLoesen(){
        if(geloest||size < 1) return;//Abbruch bei nicht initialisiertem oder bereits gelöstem Sudoku
        
        graph+="| #";
        for(int c = 0; c < size*size+size-2;c++) graph+= " ";
        graph+="||\n";
        
        short ix = 0, iy = 0; //index der momentanen Zelle
        boolean done = false;
        boolean goNext = true;//Bewegrichtung der Rekursionstiefe (in die nächste Ebene / in die vorherige raus)
                              //Benötigt, um vorgegebene Zellen überspringen zu können
        //ArrayList blaetter = new ArrayList<Integer>();
        
                
        while(!done){
            anzRekAuf++;
            if(!werteNetz[ix][iy].isStatisch()){ //überspringe vorgegebene Zellen
                
                if(werteNetz[ix][iy].naechsteEinsetzen(ix, iy, size)) {
                    goNext = true;
                    
                }       //Einsetzen der nächstgrößten, einsetzbaren Zahl
                else {  //und setzen der Bewegrichtung
                    goNext = false;
                    //blaetter.add((ix * size) + iy +1);
                    anzBlaetter++;
                }
                control.main.setSdkVal(ix, iy, werteNetz[ix][iy].getWert());
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException ex){}
                anzKnoten++;
                
                if(size <= 9){
                    graph += "|";
                    int cs = 0;
                    for(int c = 0;  c < ((ix * size) + iy +1);c++) {
                        int w = werteNetz[(int)Math.ceil(c/size)][c - size * (int)Math.ceil(c/size)].getWert();
                        if(c % size == 0) graph += " ";
                        if(c % size == 0) cs++;
                        if(w != 0) graph+="\033[0m"+w+"\033[32m";
                        else graph += "\033[31m=";
                    };
                    graph += "#";
                    for(int c = 0; c < (size*size)-((ix * size) + iy +2);c++) graph += " ";
                    for(int c = 0; c < size - cs; c++) graph += " ";
                    if((size*size) > ((ix * size) + iy +1)) graph += "|";
                    graph += "|\033[0m\n";
                }
            }
            
            if(goNext){ //gehe zur nächsten Zelle
                if(iy < size-1) iy++;
                else {
                    iy = 0;
                    if(ix < size-1) ix++;
                    else { //sudoku wurde gelöst
                        done = true;
                        loesbar = true;
                        //blaetter.add(size*size);
                    }
                }
            }
            else { //gehe zur vorherigen Zelle
                if(iy > 0) iy--;
                else {
                    iy = (short)(size-1);
                    if(ix > 0) ix--;
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

    /**
     * @return the anzBlaetter
     */
    public int getAnzBlaetter() {
        return anzBlaetter;
    }

    /**
     * @return the anzKnoten
     */
    public int getAnzKnoten() {
        return anzKnoten;
    }

    /**
     * @return the anzRekAuf
     */
    public int getAnzRekAuf() {
        return anzRekAuf;
    }

    /**
     * @return the graph
     */
    public String getGraph() {
        return graph;
    }
}
