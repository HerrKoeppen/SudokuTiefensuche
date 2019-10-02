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
    private short wert;
    private boolean statisch;
    private Sudoku sdk;
    
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
    
    public boolean naechsteEinsetzen(short x, short y, short size){
        if(wert==size){
            wert = 0;
            return false;
        }
        short i = wert;
        boolean einsetzbar = false;
        while((i < size) && !einsetzbar){
            i++;
            einsetzbar = true;
            for(short iy = 0; iy < 10;iy++){
                if(sdk.werteNetz[x][iy].wert == i) einsetzbar = false;
            }
            for(short ix = 0; ix < 10;ix++){
                if(sdk.werteNetz[ix][y].wert == i) einsetzbar = false;
            }
            short cx = (short) Math.ceil((x+1) / Math.sqrt(size));
            short cy = (short) Math.ceil((y+1) / Math.sqrt(size));
            for(short ix = (short)(((cx-1)*Math.sqrt(size))+1); ix <= cx*Math.sqrt(size);ix++){
                for(short iy = (short)(((cx-1)*Math.sqrt(size))+1); iy <= cx*Math.sqrt(size);iy++){
                    if(sdk.werteNetz[ix-1][iy-1].wert == i) einsetzbar = false;
                }
            }
        }
        if(einsetzbar){
            wert = i;
            return true;
        }
        wert = 0;
        return false;
    }

    public short getWert() {
        return wert;
    }
    public void setWert(short wert) {
        this.wert = wert;
        statisch = true;
        if(wert == 0) statisch = false;
    }
    public boolean isStatisch() {
        return statisch;
    }
    
    
}
