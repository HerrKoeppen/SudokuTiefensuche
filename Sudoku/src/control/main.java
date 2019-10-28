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
    
        static private short size = 1;
        static private short[][] sdk = new short[1][1];
        static private model.Sudoku sudoku = new model.Sudoku(sdk, (short)1);
    
        public static void main(String[] args) {
            
    }

        private static short[][] convert(String file, short size) {
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
        
        
        
        public static void sudokuInitialisieren(short sze){
            size = sze;
            sdk = new short[sze][sze];
        }
        
        public static void zelleVeraendern(short x, short y, short value){
            if((x >= size) ||(y >= size)) return;
            sdk[x][y] = value;
        }
        
        public static void sudokuErstellen(){
            sudoku = new model.Sudoku(sdk, size);
        }
        
        
        
        public static void importieren(String file, short sze){
            size = sze;
            sdk = convert(file, sze);
            sudoku = new model.Sudoku(sdk, sze);
        }
        
        
        
        public static void sudokuLoesen(){
            sudoku.sudokuLoesen();
        }
}
