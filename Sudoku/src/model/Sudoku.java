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
    
    protected Zelle[][] werteNetz;
    protected boolean geloest, loesbar;
    private short size;
    protected int anzTests;
    
    public Sudoku(){
        geloest = false;
        loesbar = false;
        size = 0;
        anzTests = 0;
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
        anzTests = 0;
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
        anzTests = 0;
    }
    
    public void sudokuLoesen(boolean tracePath, boolean stats, boolean showGraph){
        if(geloest||size < 1) return;//Abbruch bei nicht initialisiertem oder bereits gelöstem Sudoku
        short ix = 0, iy = 0; //index der momentanen Zelle
        boolean done = false;
        boolean goNext = true;//Bewegrichtung der Rekursionstiefe (in die nächste Ebene / in die vorherige raus)
                              //Benötigt, um vorgegebene Zellen überspringen zu können
                              
        int anzBlaetter = 1;//statistische Variablen
        int anzKnoten = 0;
        int anzInnKnoten = 0;
        int anzRekAuf = 0;
        ArrayList blaetter = new ArrayList<Integer>();
        boolean isKnoten[][] = new boolean[size][size];
        
        String graph = "";
        if(showGraph&&size<10){
            graph+=("| #");
            for(int c = 0; c < size*size+size-2;c++) graph+=(" ");
            graph+=("||\n");
        }
        else if(showGraph) graph = "\033[31m    //FEHLER: Rekursionsgraph kann nicht gezeichnet werden, da \033[34m[size]\033[31m > 10 ist.\033[0m\n";
                
        while(!done){
            anzRekAuf++;
            if(!werteNetz[ix][iy].isStatisch()){ //überspringe vorgegebene Zellen
                
                if(werteNetz[ix][iy].naechsteEinsetzen(ix, iy, size)) {
                    if(!goNext){
                        goNext = true;
                        if(!isKnoten[ix][iy]){
                            isKnoten[ix][iy] = true;
                            anzInnKnoten++;
                        }
                        isKnoten[ix][iy] = true;
                    }
                    if(tracePath&&stats) System.out.println("Betrete neue Rekursionsebene - (X:"+(iy+1)+" , Y:"+(ix+1)+")");
                    if(tracePath) view.Ausgabe.sudokuAnzeigen(this,ix, iy);
                }       //Einsetzen der nächstgrößten, einsetzbaren Zahl
                else {  //und setzen der Bewegrichtung
                    if(goNext){
                        goNext = false;
                        blaetter.add((ix * size) + iy +1);
                        anzBlaetter++;
                    }
                    if(tracePath&&stats) System.out.println("Verlasse Rekursionsebene bei (X:"+(iy+1)+" , Y:"+(ix+1)+") - Tiefe: "+((ix * size) + iy +1));
                    if(tracePath&&stats) view.Ausgabe.sudokuAnzeigen(this,ix, iy);
                }
                anzKnoten++;
                
                if(showGraph&&size<10){
                    graph+=("|");
                    int cs = 0;
                    for(int c = 0;  c < ((ix * size) + iy +1);c++) {
                        int w = werteNetz[(int)Math.ceil(c/size)][c - size * (int)Math.ceil(c/size)].getWert();
                        if(c % size == 0) graph += " ";
                        if(c % size == 0) cs++;
                        if(w != 0) graph+="\033[0m"+w+"\033[32m";
                        else graph += "\033[31m=";
                    };
                    graph += "#";
                    for(int c = 0; c < (size*size)-((ix * size) + iy +2);c++) graph+=(" ");
                    for(int c = 0; c < size - cs; c++) graph += " ";
                    if((size*size) > ((ix * size) + iy +1)) graph+=("|");
                    graph+="|\033[0m\n";
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
                        blaetter.add(size*size);
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
        if(showGraph) System.out.println(graph);
        if(stats){
            
            System.out.print("Lösungsalgorithmus - Ergebnis:");
            if(loesbar) System.out.println(" Das Sudoku ist lösbar!\n");
            else  System.out.println(" Das Sudoku ist nicht lösbar!\n");
            
            System.out.println("Gesammtzahl der Knoten: " + anzKnoten +"\n");
            System.out.println(" -> Gesammtzahl der inneren Knoten/Teilbäume: " + anzInnKnoten);
            System.out.println(" -> Gesammtzahl der Halbblätter: " + (anzKnoten - anzInnKnoten - anzBlaetter));
            System.out.println(" -> Gesammtzahl der Blätter: " + anzBlaetter);
            System.out.println("\nGesammtzahl überprüfter Zahlen: " + anzTests);
            System.out.println("Gesammtzahl verglichener Zahlen: " + anzTests *(size-1)*3 + " (" + anzTests + " * " + (size-1)*3 + ")");
            anzTests = 0;
            System.out.println("\nGesammtzahl rekursiver Aufrufe: " + anzRekAuf);
            System.out.println("Gesammtzahl übersprungener Felder: " + (anzRekAuf - anzKnoten));
            blaetter.sort(Collections.reverseOrder());
            String[] b = blaetter.toString().split(",");
            String blaetter_ = "";
            for(int i = 0;i< b.length;i++){
                blaetter_ += b[i];
                if(i+1 < b.length){
                    blaetter_ += ",";
                    if((i+1)%40 == 0) blaetter_ += "\n ";
                }
            }
            System.out.println("\nAbsteigend geordnete Liste der Tiefen aller Blätter:\n "+ blaetter_ +"\n\n");
        }
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
