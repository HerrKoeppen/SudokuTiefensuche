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
 * @author yannis.hofmann
 */
public class main {

    
        private static model.Sudoku sdk;
    
    
        public static void main(String[] args) throws Exception {
            short[][] sudokuleicht = new short[9][9];
            sudokuleicht = convert("sample.txt",(short)9);
            sdk = new model.Sudoku(sudokuleicht,(short)9);
            view.Ausgabe.sudokuAusgeben(sdk);
            sdk.sudokuLoesen();
            view.Ausgabe.sudokuAusgeben(sdk);
            
    }

            
        
        public static short[][] convert(String file, short size) throws FileNotFoundException{
        String filePath = new File("").getAbsolutePath();
        filePath = filePath.concat("/src/control/" + file);
        Scanner sc;            
        sc = new Scanner(new BufferedReader(new FileReader(filePath)));      
        short[][] myArray = new short[size][size];
        while (sc.hasNextLine()) {
            String[] items = sc.nextLine().trim().split(",");
            for (short j = 0; j < items.length; j++) {
                myArray[j / size][j % size] = (short)Integer.parseInt(items[j]);
            }
        }
        return myArray;


}
        
}
