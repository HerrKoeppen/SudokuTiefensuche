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
    
    public void sudokuAusgeben(Sudoku sdk){
        if(!sdk.geloest()){  //Überprüfung ob das Sudoku gelöst ist.
            System.out.println("Das Sudoku wurde noch nicht gelöst.");
            
            short[][] werteNetz = sdk.getWerteNetz();
            short size = sdk.getSize();
            
            for(short x=0;x<size;x++){
                String str = "";
                for(short y=0;y<size;y++){
                    if(werteNetz[x][y] == 0) str += "[ ]";
                    else str += "["+werteNetz[x][y]+"]";
                }
                System.out.println(str);  //Ausgabe des ungelösten Sudoku. 
            }
        }
        else if(sdk.loesbar()){    //Lösungsalgorithmus endet bei "Schritt 3".
            System.out.println("Das Sudoku wurde erfolgreich gelöst. Das Fertige Sudoku:");
            
            short[][] werteNetz = sdk.getWerteNetz();
            short size = sdk.getSize();
            
            for(short x=0;x<size;x++){
                String str = "";
                for(short y=0;y<size;y++){
                    str += "["+werteNetz[x][y]+"]";
                }
                System.out.println(str); //Ausgabe des gelösten Sudokus.
            }
            
        }
        else{
            System.out.println("Das Sudoku ist nicht lösbar");
        }
    }
}
