/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.Sudoku;
/**
 *
 * @author yannis.hofmann
 */
public class Ausgabe{
    
    public static void sudokuAusgeben(Sudoku sdk){
        if(!sdk.geloest()){  //Überprüfung ob das Sudoku gelöst ist.
            System.out.println("Das Sudoku wurde noch nicht gelöst.");
            
            short[][] werteNetz = sdk.getWerteNetz();
            short size = sdk.getSize();
            
            for(short x=0;x<size;x++){
                String str = "";
                for(short y=0;y<size;y++){
                    if(werteNetz[x][y] < size+1) {
                        if(werteNetz[x][y] == 0) {
                            str += "[";
                            for(int l = 0; l <= Math.floor(Math.log10(size));l++) str += " ";
                            str += "]";
                        }
                        else{   
                            str += "\033[31m[";
                            for(int l = 0; l < Math.floor(Math.log10(size));l++)
                                if(Math.floor(Math.log10(werteNetz[x][y])) <= l) str += "0";
                            str += werteNetz[x][y]+"]\033[0m";
                        }
                    }
                    else {
                        str += "[";
                        for(int l = 0; l < Math.floor(Math.log10(size));l++)
                            if(Math.floor(Math.log10(werteNetz[x][y])) <= l) str += "0";
                        str += (werteNetz[x][y]-(size+1))+"]";
                    }
                }
                System.out.println(str); //Ausgabe des gelösten Sudokus.
            }
            System.out.println("\n");
        }
        else if(sdk.loesbar()){    //Lösungsalgorithmus endete bei "Schritt 3".
            System.out.println("Das Sudoku wurde erfolgreich gelöst. Das Fertige Sudoku:");
            
            short[][] werteNetz = sdk.getWerteNetz();
            short size = sdk.getSize();
            
            for(short x=0;x<size;x++){
                String str = "";
                for(short y=0;y<size;y++){
                    if(werteNetz[x][y] < size+1) {
                        str += "\033[31m[";
                        for(int l = 0; l < Math.floor(Math.log10(size));l++)
                            if(Math.floor(Math.log10(werteNetz[x][y])) <= l) str += "0";
                        str += werteNetz[x][y]+"]\033[0m";
                    }
                    else {
                        str += "[";
                        for(int l = 0; l < Math.floor(Math.log10(size));l++)
                            if(Math.floor(Math.log10(werteNetz[x][y])) <= l) str += "0";
                        str += (werteNetz[x][y]-(size+1))+"]";
                    }
                }
                System.out.println(str); //Ausgabe des gelösten Sudokus.
            }
            System.out.println("\n");
        }
        else{
            System.out.println("Das Sudoku ist nicht lösbar\n");
        }
    }
}
