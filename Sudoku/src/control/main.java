/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author yannis.hofmann , Joshua
 */
public class main {
    
        public static void main(String[] args) {
            
            //Beispiel Sudoku in "sample.txt"
            short[][] sudokuleicht = new short[9][9];
            sudokuleicht = convert("sample.txt",(short)9);
            model.Sudoku sdk = new model.Sudoku(sudokuleicht,(short)9);
            view.Ausgabe.sudokuAnzeigen(sdk);
            sdk.sudokuLoesen(false, true, false);
            view.Ausgabe.sudokuAusgeben(sdk);
            
            //leeres Sudoku
            short size = 4; //Größe des Leeren Sudokus - Größe schneller leeren Sudokus: 1 , 2 , 4 , 9 , 16 , 64 , (256) -> Quadrate der 2er Potenzen (bis auf 9)
            short[][] sdk2_ = new short[size][size]; //Notiz: Die Matrix muss (n^2) * (n^2) groß sein -> sqrt (size) = Natürliche Zahl
            sdk2_[1][0] = 2;
            sdk2_[0][1] = 1;
            sdk2_[2][1] = 4;
            sdk2_[3][2] = 4;
            sdk2_[0][3] = 3;
            model.Sudoku sdk2 = new model.Sudoku(sdk2_,(short)size);
            sdk2.sudokuLoesen(false, true, true);//Stand d. Algorithmus  |  Statistiken für Nerds  |  Rekursionsraph
            view.Ausgabe.sudokuAusgeben(sdk2);   // 1 Zeile mit Rotem Balken im Rekursionsgraph = 1 Blatt ("Niete")
                                                 // 1 Zeile im Rekursionsgraph(abgesehen von der ersten) = 1 Knoten
                                                 // (Anzahl rekursive Aufrufe) - (Anzahl der Knoten) = Zahl der übersprungenen, vorgegebenen Felder
    }

        public static short[][] convert(String file, short size) {
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("/src/control/" + file);
        Scanner sc = null;            
        try{
            sc = new Scanner(new BufferedReader(new FileReader(filePath)));
        }
        catch(Exception e){
            return new short[0][0];
        }
        short[][] myArray = new short[size][size];
        for(short c = 0; c < size;c++){
            String[] items = sc.nextLine().trim().split(",");
            for (short j = 0; j < size; j++) {
                myArray[c][j] = (short)Integer.parseInt(items[j]);
            }
        }
        return myArray;


}
        
}
