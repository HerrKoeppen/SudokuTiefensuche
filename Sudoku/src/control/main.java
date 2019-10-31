/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.WindowConstants;
import view.*;
/**
 *
 * @author yannis.hofmann , Joshua
 */
public class main {
        //GameState state = GameState.SIZEC;
        static public short size = 1;
        static private short[][] sdk = new short[1][1];
        static private model.Sudoku sudoku = new model.Sudoku(sdk, (short)1);
    
        static public JDialog window = new JDialog();
        static public SizeChoosement szeCh;
        static public SudokuExportment sdkExp9;
        static public SudokuExportment16x16 sdkExp16;
        static public SudokuExportment4x4 sdkExp4;
        static public SudokuImportment sdkImp9;
        static public SudokuImportment4x4 sdkImp4;
        static public SudokuImportment16x16 sdkImp16;
        
        
        public static void main(String[] args) {
            window.setTitle("Sudoku");
            window.setSize(450,300);
            szeCh = new view.SizeChoosement();
            window.add(szeCh);
            window.setVisible(true);
            window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }
        
        
        public static void sudokuInitialisieren(short sze){
            size = sze;
            sdk = new short[sze][sze];
        }
        
        public static void zelleVeraendern(short x, short y, String value){
            if((x >= size) ||(y >= size)) return;
            if((x < 0) || (y < 0)) return;
            short val;
            try{
                val = Short.valueOf(value);
            }
            catch(Exception e) {return;}
            if((val <= 0)||(val > size)) return;
            sdk[x][y] = val;
        }
        
        public static void sudokuErstellen(){
            sudoku = new model.Sudoku(sdk, size);
            for(short x = 0; x < size; x++){
                for(short y = 0; y < size; y++){
                    setSdkVal(x, y, sdk[x][y]);
                }
            }
            window.validate();
        }
        
        
        public static void importieren(String file, short sze){
            size = sze;
            sdk = convert(file, sze);
            sudoku = new model.Sudoku(sdk, sze);
        }
        
        public static void sudokuLoesen(){
            sudoku.sudokuLoesen();
            window.validate();
        }
        
        
        //4x4 Importment & Exportment sind fertig, in 9x9 und 16x16 müssen alle Labels noch umbenannt werden.
        public static void setSdkVal(short x, short y, short val){
            if(size == 4){
                switch (x) {
                    case 0:
                    {
                        switch (y){
                            case 0: if(val != 0)sdkExp4.getL1x1().setText(String.valueOf(val)); else sdkExp4.getL1x1().setText(""); break;
                            case 1: if(val != 0)sdkExp4.getL1x2().setText(String.valueOf(val)); else sdkExp4.getL1x2().setText(""); break;
                            case 2: if(val != 0)sdkExp4.getL1x3().setText(String.valueOf(val)); else sdkExp4.getL1x3().setText(""); break;
                            case 3: if(val != 0)sdkExp4.getL1x4().setText(String.valueOf(val)); else sdkExp4.getL1x4().setText(""); break;
                        }
                        break;
                    }
                    case 1:
                    {
                        switch (y){
                            case 0: if(val != 0)sdkExp4.getL2x1().setText(String.valueOf(val)); else sdkExp4.getL2x1().setText(""); break;
                            case 1: if(val != 0)sdkExp4.getL2x2().setText(String.valueOf(val)); else sdkExp4.getL2x2().setText(""); break;
                            case 2: if(val != 0)sdkExp4.getL2x3().setText(String.valueOf(val)); else sdkExp4.getL2x3().setText(""); break;
                            case 3: if(val != 0)sdkExp4.getL2x4().setText(String.valueOf(val)); else sdkExp4.getL2x4().setText(""); break;
                        }
                        break;
                    }
                    case 2:
                    {
                        switch (y){
                            case 0: if(val != 0)sdkExp4.getL3x1().setText(String.valueOf(val)); else sdkExp4.getL3x1().setText(""); break;
                            case 1: if(val != 0)sdkExp4.getL3x2().setText(String.valueOf(val)); else sdkExp4.getL3x2().setText(""); break;
                            case 2: if(val != 0)sdkExp4.getL3x3().setText(String.valueOf(val)); else sdkExp4.getL3x3().setText(""); break;
                            case 3: if(val != 0)sdkExp4.getL3x4().setText(String.valueOf(val)); else sdkExp4.getL3x4().setText(""); break;
                        }
                        break;
                    }
                    case 3:
                    {
                        switch (y){
                            case 0: if(val != 0)sdkExp4.getL4x1().setText(String.valueOf(val)); else sdkExp4.getL4x1().setText(""); break;
                            case 1: if(val != 0)sdkExp4.getL4x2().setText(String.valueOf(val)); else sdkExp4.getL4x2().setText(""); break;
                            case 2: if(val != 0)sdkExp4.getL4x3().setText(String.valueOf(val)); else sdkExp4.getL4x3().setText(""); break;
                            case 3: if(val != 0)sdkExp4.getL4x4().setText(String.valueOf(val)); else sdkExp4.getL4x4().setText(""); break;
                        }
                        break;
                    }
                }
            }
            
            else if(size == 9){
                switch (x) {
                    case 0:
                    {
                        switch (y){
                            case 0: if(val != 0)sdkExp9.getL1x1().setText(String.valueOf(val)); else sdkExp9.getL1x1().setText(""); break;
                            case 1: if(val != 0)sdkExp9.getL1x2().setText(String.valueOf(val)); else sdkExp9.getL1x2().setText(""); break;
                            case 2: if(val != 0)sdkExp9.getL1x3().setText(String.valueOf(val)); else sdkExp9.getL1x3().setText(""); break;
                            case 3: if(val != 0)sdkExp9.getL1x4().setText(String.valueOf(val)); else sdkExp9.getL1x4().setText(""); break;
                            case 4: if(val != 0)sdkExp9.getL1x5().setText(String.valueOf(val)); else sdkExp9.getL1x5().setText(""); break;
                            case 5: if(val != 0)sdkExp9.getL1x6().setText(String.valueOf(val)); else sdkExp9.getL1x6().setText(""); break;
                            case 6: if(val != 0)sdkExp9.getL1x7().setText(String.valueOf(val)); else sdkExp9.getL1x7().setText(""); break;
                            case 7: if(val != 0)sdkExp9.getL1x8().setText(String.valueOf(val)); else sdkExp9.getL1x8().setText(""); break;
                            case 8: if(val != 0)sdkExp9.getL1x9().setText(String.valueOf(val)); else sdkExp9.getL1x9().setText(""); break;
                        }
                        break;
                    }
                    case 1:
                    {
                        switch (y){
                            case 0: if(val != 0)sdkExp9.getL2x1().setText(String.valueOf(val)); else sdkExp9.getL2x1().setText(""); break;
                            case 1: if(val != 0)sdkExp9.getL2x2().setText(String.valueOf(val)); else sdkExp9.getL2x2().setText(""); break;
                            case 2: if(val != 0)sdkExp9.getL2x3().setText(String.valueOf(val)); else sdkExp9.getL2x3().setText(""); break;
                            case 3: if(val != 0)sdkExp9.getL2x4().setText(String.valueOf(val)); else sdkExp9.getL2x4().setText(""); break;
                            case 4: if(val != 0)sdkExp9.getL2x5().setText(String.valueOf(val)); else sdkExp9.getL2x5().setText(""); break;
                            case 5: if(val != 0)sdkExp9.getL2x6().setText(String.valueOf(val)); else sdkExp9.getL2x6().setText(""); break;
                            case 6: if(val != 0)sdkExp9.getL2x7().setText(String.valueOf(val)); else sdkExp9.getL2x7().setText(""); break;
                            case 7: if(val != 0)sdkExp9.getL2x8().setText(String.valueOf(val)); else sdkExp9.getL2x8().setText(""); break;
                            case 8: if(val != 0)sdkExp9.getL2x9().setText(String.valueOf(val)); else sdkExp9.getL2x9().setText(""); break;
                        }
                        break;
                    }
                    case 2:
                    {
                        switch (y){
                            case 0: if(val != 0)sdkExp9.getL3x1().setText(String.valueOf(val)); else sdkExp9.getL3x1().setText(""); break;
                            case 1: if(val != 0)sdkExp9.getL3x2().setText(String.valueOf(val)); else sdkExp9.getL3x2().setText(""); break;
                            case 2: if(val != 0)sdkExp9.getL3x3().setText(String.valueOf(val)); else sdkExp9.getL3x3().setText(""); break;
                            case 3: if(val != 0)sdkExp9.getL3x4().setText(String.valueOf(val)); else sdkExp9.getL3x4().setText(""); break;
                            case 4: if(val != 0)sdkExp9.getL3x5().setText(String.valueOf(val)); else sdkExp9.getL3x5().setText(""); break;
                            case 5: if(val != 0)sdkExp9.getL3x6().setText(String.valueOf(val)); else sdkExp9.getL3x6().setText(""); break;
                            case 6: if(val != 0)sdkExp9.getL3x7().setText(String.valueOf(val)); else sdkExp9.getL3x7().setText(""); break;
                            case 7: if(val != 0)sdkExp9.getL3x8().setText(String.valueOf(val)); else sdkExp9.getL3x8().setText(""); break;
                            case 8: if(val != 0)sdkExp9.getL3x9().setText(String.valueOf(val)); else sdkExp9.getL3x9().setText(""); break;
                        }
                        break;
                    }
                    case 3:
                    {
                        switch (y){
                            case 0: if(val != 0)sdkExp9.getL4x1().setText(String.valueOf(val)); else sdkExp9.getL4x1().setText(""); break;
                            case 1: if(val != 0)sdkExp9.getL4x2().setText(String.valueOf(val)); else sdkExp9.getL4x2().setText(""); break;
                            case 2: if(val != 0)sdkExp9.getL4x3().setText(String.valueOf(val)); else sdkExp9.getL4x3().setText(""); break;
                            case 3: if(val != 0)sdkExp9.getL4x4().setText(String.valueOf(val)); else sdkExp9.getL4x4().setText(""); break;
                            case 4: if(val != 0)sdkExp9.getL4x5().setText(String.valueOf(val)); else sdkExp9.getL4x5().setText(""); break;
                            case 5: if(val != 0)sdkExp9.getL4x6().setText(String.valueOf(val)); else sdkExp9.getL4x6().setText(""); break;
                            case 6: if(val != 0)sdkExp9.getL4x7().setText(String.valueOf(val)); else sdkExp9.getL4x7().setText(""); break;
                            case 7: if(val != 0)sdkExp9.getL4x8().setText(String.valueOf(val)); else sdkExp9.getL4x8().setText(""); break;
                            case 8: if(val != 0)sdkExp9.getL4x9().setText(String.valueOf(val)); else sdkExp9.getL4x9().setText(""); break;
                        }
                        break;
                    }
                    case 4:
                    {
                        switch (y){
                            case 0: if(val != 0)sdkExp9.getL5x1().setText(String.valueOf(val)); else sdkExp9.getL5x1().setText(""); break;
                            case 1: if(val != 0)sdkExp9.getL5x2().setText(String.valueOf(val)); else sdkExp9.getL5x2().setText(""); break;
                            case 2: if(val != 0)sdkExp9.getL5x3().setText(String.valueOf(val)); else sdkExp9.getL5x3().setText(""); break;
                            case 3: if(val != 0)sdkExp9.getL5x4().setText(String.valueOf(val)); else sdkExp9.getL5x4().setText(""); break;
                            case 4: if(val != 0)sdkExp9.getL5x5().setText(String.valueOf(val)); else sdkExp9.getL5x5().setText(""); break;
                            case 5: if(val != 0)sdkExp9.getL5x6().setText(String.valueOf(val)); else sdkExp9.getL5x6().setText(""); break;
                            case 6: if(val != 0)sdkExp9.getL5x7().setText(String.valueOf(val)); else sdkExp9.getL5x7().setText(""); break;
                            case 7: if(val != 0)sdkExp9.getL5x8().setText(String.valueOf(val)); else sdkExp9.getL5x8().setText(""); break;
                            case 8: if(val != 0)sdkExp9.getL5x9().setText(String.valueOf(val)); else sdkExp9.getL5x9().setText(""); break;
                        }
                        break;
                    }
                    case 5:
                    {
                        switch (y){
                            case 0: if(val != 0)sdkExp9.getL6x1().setText(String.valueOf(val)); else sdkExp9.getL6x1().setText(""); break;
                            case 1: if(val != 0)sdkExp9.getL6x2().setText(String.valueOf(val)); else sdkExp9.getL6x2().setText(""); break;
                            case 2: if(val != 0)sdkExp9.getL6x3().setText(String.valueOf(val)); else sdkExp9.getL6x3().setText(""); break;
                            case 3: if(val != 0)sdkExp9.getL6x4().setText(String.valueOf(val)); else sdkExp9.getL6x4().setText(""); break;
                            case 4: if(val != 0)sdkExp9.getL6x5().setText(String.valueOf(val)); else sdkExp9.getL6x5().setText(""); break;
                            case 5: if(val != 0)sdkExp9.getL6x6().setText(String.valueOf(val)); else sdkExp9.getL6x6().setText(""); break;
                            case 6: if(val != 0)sdkExp9.getL6x7().setText(String.valueOf(val)); else sdkExp9.getL6x7().setText(""); break;
                            case 7: if(val != 0)sdkExp9.getL6x8().setText(String.valueOf(val)); else sdkExp9.getL6x8().setText(""); break;
                            case 8: if(val != 0)sdkExp9.getL6x9().setText(String.valueOf(val)); else sdkExp9.getL6x9().setText(""); break;
                        }
                        break;
                    }
                    case 6:
                    {
                        switch (y){
                            case 0: if(val != 0)sdkExp9.getL7x1().setText(String.valueOf(val)); else sdkExp9.getL7x1().setText(""); break;
                            case 1: if(val != 0)sdkExp9.getL7x2().setText(String.valueOf(val)); else sdkExp9.getL7x2().setText(""); break;
                            case 2: if(val != 0)sdkExp9.getL7x3().setText(String.valueOf(val)); else sdkExp9.getL7x3().setText(""); break;
                            case 3: if(val != 0)sdkExp9.getL7x4().setText(String.valueOf(val)); else sdkExp9.getL7x4().setText(""); break;
                            case 4: if(val != 0)sdkExp9.getL7x5().setText(String.valueOf(val)); else sdkExp9.getL7x5().setText(""); break;
                            case 5: if(val != 0)sdkExp9.getL7x6().setText(String.valueOf(val)); else sdkExp9.getL7x6().setText(""); break;
                            case 6: if(val != 0)sdkExp9.getL7x7().setText(String.valueOf(val)); else sdkExp9.getL7x7().setText(""); break;
                            case 7: if(val != 0)sdkExp9.getL7x8().setText(String.valueOf(val)); else sdkExp9.getL7x8().setText(""); break;
                            case 8: if(val != 0)sdkExp9.getL7x9().setText(String.valueOf(val)); else sdkExp9.getL7x9().setText(""); break;
                        }
                        break;
                    }
                    case 7:
                    {
                        switch (y){
                            case 0: if(val != 0)sdkExp9.getL8x1().setText(String.valueOf(val)); else sdkExp9.getL8x1().setText(""); break;
                            case 1: if(val != 0)sdkExp9.getL8x2().setText(String.valueOf(val)); else sdkExp9.getL8x2().setText(""); break;
                            case 2: if(val != 0)sdkExp9.getL8x3().setText(String.valueOf(val)); else sdkExp9.getL8x3().setText(""); break;
                            case 3: if(val != 0)sdkExp9.getL8x4().setText(String.valueOf(val)); else sdkExp9.getL8x4().setText(""); break;
                            case 4: if(val != 0)sdkExp9.getL8x5().setText(String.valueOf(val)); else sdkExp9.getL8x5().setText(""); break;
                            case 5: if(val != 0)sdkExp9.getL8x6().setText(String.valueOf(val)); else sdkExp9.getL8x6().setText(""); break;
                            case 6: if(val != 0)sdkExp9.getL8x7().setText(String.valueOf(val)); else sdkExp9.getL8x7().setText(""); break;
                            case 7: if(val != 0)sdkExp9.getL8x8().setText(String.valueOf(val)); else sdkExp9.getL8x8().setText(""); break;
                            case 8: if(val != 0)sdkExp9.getL8x9().setText(String.valueOf(val)); else sdkExp9.getL8x9().setText(""); break;
                        }
                        break;
                    }
                    case 8:
                    {
                        switch (y){
                            case 0: if(val != 0)sdkExp9.getL9x1().setText(String.valueOf(val)); else sdkExp9.getL9x1().setText(""); break;
                            case 1: if(val != 0)sdkExp9.getL9x2().setText(String.valueOf(val)); else sdkExp9.getL9x2().setText(""); break;
                            case 2: if(val != 0)sdkExp9.getL9x3().setText(String.valueOf(val)); else sdkExp9.getL9x3().setText(""); break;
                            case 3: if(val != 0)sdkExp9.getL9x4().setText(String.valueOf(val)); else sdkExp9.getL9x4().setText(""); break;
                            case 4: if(val != 0)sdkExp9.getL9x5().setText(String.valueOf(val)); else sdkExp9.getL9x5().setText(""); break;
                            case 5: if(val != 0)sdkExp9.getL9x6().setText(String.valueOf(val)); else sdkExp9.getL9x6().setText(""); break;
                            case 6: if(val != 0)sdkExp9.getL9x7().setText(String.valueOf(val)); else sdkExp9.getL9x7().setText(""); break;
                            case 7: if(val != 0)sdkExp9.getL9x8().setText(String.valueOf(val)); else sdkExp9.getL9x8().setText(""); break;
                            case 8: if(val != 0)sdkExp9.getL9x9().setText(String.valueOf(val)); else sdkExp9.getL9x9().setText(""); break;
                        }
                        break;
                    }
                }
            }/*
            else if(size == 16){
                switch (x) {
                    case 0:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL1x1(). setText(String.valueOf(val)); else sdkExp16.getL1x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL1x2(). setText(String.valueOf(val)); else sdkExp16.getL1x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL1x3(). setText(String.valueOf(val)); else sdkExp16.getL1x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL1x4(). setText(String.valueOf(val)); else sdkExp16.getL1x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL1x5(). setText(String.valueOf(val)); else sdkExp16.getL1x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL1x6(). setText(String.valueOf(val)); else sdkExp16.getL1x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL1x7(). setText(String.valueOf(val)); else sdkExp16.getL1x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL1x8(). setText(String.valueOf(val)); else sdkExp16.getL1x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL1x9(). setText(String.valueOf(val)); else sdkExp16.getL1x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL1x10().setText(String.valueOf(val)); else sdkExp16.getL1x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL1x11().setText(String.valueOf(val)); else sdkExp16.getL1x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL1x12().setText(String.valueOf(val)); else sdkExp16.getL1x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL1x13().setText(String.valueOf(val)); else sdkExp16.getL1x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL1x14().setText(String.valueOf(val)); else sdkExp16.getL1x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL1x15().setText(String.valueOf(val)); else sdkExp16.getL1x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL1x16().setText(String.valueOf(val)); else sdkExp16.getL1x16().setText(""); break;
                        }
                        break;
                    }
                    case 1:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL2x1(). setText(String.valueOf(val)); else sdkExp16.getL2x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL2x2(). setText(String.valueOf(val)); else sdkExp16.getL2x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL2x3(). setText(String.valueOf(val)); else sdkExp16.getL2x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL2x4(). setText(String.valueOf(val)); else sdkExp16.getL2x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL2x5(). setText(String.valueOf(val)); else sdkExp16.getL2x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL2x6(). setText(String.valueOf(val)); else sdkExp16.getL2x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL2x7(). setText(String.valueOf(val)); else sdkExp16.getL2x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL2x8(). setText(String.valueOf(val)); else sdkExp16.getL2x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL2x9(). setText(String.valueOf(val)); else sdkExp16.getL2x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL2x10().setText(String.valueOf(val)); else sdkExp16.getL2x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL2x11().setText(String.valueOf(val)); else sdkExp16.getL2x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL2x12().setText(String.valueOf(val)); else sdkExp16.getL2x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL2x13().setText(String.valueOf(val)); else sdkExp16.getL2x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL2x14().setText(String.valueOf(val)); else sdkExp16.getL2x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL2x15().setText(String.valueOf(val)); else sdkExp16.getL2x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL2x16().setText(String.valueOf(val)); else sdkExp16.getL2x16().setText(""); break;
                        }
                        break;
                    }
                    case 2:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL3x1(). setText(String.valueOf(val)); else sdkExp16.getL3x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL3x2(). setText(String.valueOf(val)); else sdkExp16.getL3x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL3x3(). setText(String.valueOf(val)); else sdkExp16.getL3x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL3x4(). setText(String.valueOf(val)); else sdkExp16.getL3x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL3x5(). setText(String.valueOf(val)); else sdkExp16.getL3x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL3x6(). setText(String.valueOf(val)); else sdkExp16.getL3x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL3x7(). setText(String.valueOf(val)); else sdkExp16.getL3x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL3x8(). setText(String.valueOf(val)); else sdkExp16.getL3x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL3x9(). setText(String.valueOf(val)); else sdkExp16.getL3x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL3x10().setText(String.valueOf(val)); else sdkExp16.getL3x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL3x11().setText(String.valueOf(val)); else sdkExp16.getL3x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL3x12().setText(String.valueOf(val)); else sdkExp16.getL3x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL3x13().setText(String.valueOf(val)); else sdkExp16.getL3x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL3x14().setText(String.valueOf(val)); else sdkExp16.getL3x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL3x15().setText(String.valueOf(val)); else sdkExp16.getL3x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL3x16().setText(String.valueOf(val)); else sdkExp16.getL3x16().setText(""); break;
                        }
                        break;
                    }
                    case 3:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL4x1(). setText(String.valueOf(val)); else sdkExp16.getL4x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL4x2(). setText(String.valueOf(val)); else sdkExp16.getL4x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL4x3(). setText(String.valueOf(val)); else sdkExp16.getL4x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL4x4(). setText(String.valueOf(val)); else sdkExp16.getL4x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL4x5(). setText(String.valueOf(val)); else sdkExp16.getL4x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL4x6(). setText(String.valueOf(val)); else sdkExp16.getL4x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL4x7(). setText(String.valueOf(val)); else sdkExp16.getL4x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL4x8(). setText(String.valueOf(val)); else sdkExp16.getL4x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL4x9(). setText(String.valueOf(val)); else sdkExp16.getL4x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL4x10().setText(String.valueOf(val)); else sdkExp16.getL4x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL4x11().setText(String.valueOf(val)); else sdkExp16.getL4x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL4x12().setText(String.valueOf(val)); else sdkExp16.getL4x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL4x13().setText(String.valueOf(val)); else sdkExp16.getL4x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL4x14().setText(String.valueOf(val)); else sdkExp16.getL4x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL4x15().setText(String.valueOf(val)); else sdkExp16.getL4x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL4x16().setText(String.valueOf(val)); else sdkExp16.getL4x16().setText(""); break;
                        }
                        break;
                    }
                    case 4:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL5x1(). setText(String.valueOf(val)); else sdkExp16.getL5x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL5x2(). setText(String.valueOf(val)); else sdkExp16.getL5x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL5x3(). setText(String.valueOf(val)); else sdkExp16.getL5x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL5x4(). setText(String.valueOf(val)); else sdkExp16.getL5x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL5x5(). setText(String.valueOf(val)); else sdkExp16.getL5x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL5x6(). setText(String.valueOf(val)); else sdkExp16.getL5x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL5x7(). setText(String.valueOf(val)); else sdkExp16.getL5x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL5x8(). setText(String.valueOf(val)); else sdkExp16.getL5x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL5x9(). setText(String.valueOf(val)); else sdkExp16.getL5x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL5x10().setText(String.valueOf(val)); else sdkExp16.getL5x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL5x11().setText(String.valueOf(val)); else sdkExp16.getL5x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL5x12().setText(String.valueOf(val)); else sdkExp16.getL5x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL5x13().setText(String.valueOf(val)); else sdkExp16.getL5x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL5x14().setText(String.valueOf(val)); else sdkExp16.getL5x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL5x15().setText(String.valueOf(val)); else sdkExp16.getL5x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL5x16().setText(String.valueOf(val)); else sdkExp16.getL5x16().setText(""); break;
                        }
                        break;
                    }
                    case 5:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL6x1(). setText(String.valueOf(val)); else sdkExp16.getL6x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL6x2(). setText(String.valueOf(val)); else sdkExp16.getL6x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL6x3(). setText(String.valueOf(val)); else sdkExp16.getL6x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL6x4(). setText(String.valueOf(val)); else sdkExp16.getL6x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL6x5(). setText(String.valueOf(val)); else sdkExp16.getL6x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL6x6(). setText(String.valueOf(val)); else sdkExp16.getL6x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL6x7(). setText(String.valueOf(val)); else sdkExp16.getL6x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL6x8(). setText(String.valueOf(val)); else sdkExp16.getL6x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL6x9(). setText(String.valueOf(val)); else sdkExp16.getL6x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL6x10().setText(String.valueOf(val)); else sdkExp16.getL6x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL6x11().setText(String.valueOf(val)); else sdkExp16.getL6x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL6x12().setText(String.valueOf(val)); else sdkExp16.getL6x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL6x13().setText(String.valueOf(val)); else sdkExp16.getL6x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL6x14().setText(String.valueOf(val)); else sdkExp16.getL6x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL6x15().setText(String.valueOf(val)); else sdkExp16.getL6x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL6x16().setText(String.valueOf(val)); else sdkExp16.getL6x16().setText(""); break;
                        }
                        break;
                    }
                    case 6:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL7x1(). setText(String.valueOf(val)); else sdkExp16.getL7x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL7x2(). setText(String.valueOf(val)); else sdkExp16.getL7x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL7x3(). setText(String.valueOf(val)); else sdkExp16.getL7x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL7x4(). setText(String.valueOf(val)); else sdkExp16.getL7x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL7x5(). setText(String.valueOf(val)); else sdkExp16.getL7x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL7x6(). setText(String.valueOf(val)); else sdkExp16.getL7x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL7x7(). setText(String.valueOf(val)); else sdkExp16.getL7x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL7x8(). setText(String.valueOf(val)); else sdkExp16.getL7x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL7x9(). setText(String.valueOf(val)); else sdkExp16.getL7x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL7x10().setText(String.valueOf(val)); else sdkExp16.getL7x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL7x11().setText(String.valueOf(val)); else sdkExp16.getL7x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL7x12().setText(String.valueOf(val)); else sdkExp16.getL7x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL7x13().setText(String.valueOf(val)); else sdkExp16.getL7x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL7x14().setText(String.valueOf(val)); else sdkExp16.getL7x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL7x15().setText(String.valueOf(val)); else sdkExp16.getL7x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL7x16().setText(String.valueOf(val)); else sdkExp16.getL7x16().setText(""); break;
                        }
                        break;
                    }
                    case 7:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL8x1(). setText(String.valueOf(val)); else sdkExp16.getL8x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL8x2(). setText(String.valueOf(val)); else sdkExp16.getL8x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL8x3(). setText(String.valueOf(val)); else sdkExp16.getL8x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL8x4(). setText(String.valueOf(val)); else sdkExp16.getL8x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL8x5(). setText(String.valueOf(val)); else sdkExp16.getL8x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL8x6(). setText(String.valueOf(val)); else sdkExp16.getL8x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL8x7(). setText(String.valueOf(val)); else sdkExp16.getL8x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL8x8(). setText(String.valueOf(val)); else sdkExp16.getL8x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL8x9(). setText(String.valueOf(val)); else sdkExp16.getL8x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL8x10().setText(String.valueOf(val)); else sdkExp16.getL8x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL8x11().setText(String.valueOf(val)); else sdkExp16.getL8x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL8x12().setText(String.valueOf(val)); else sdkExp16.getL8x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL8x13().setText(String.valueOf(val)); else sdkExp16.getL8x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL8x14().setText(String.valueOf(val)); else sdkExp16.getL8x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL8x15().setText(String.valueOf(val)); else sdkExp16.getL8x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL8x16().setText(String.valueOf(val)); else sdkExp16.getL8x16().setText(""); break;
                        }
                        break;
                    }
                    case 8:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL9x1(). setText(String.valueOf(val)); else sdkExp16.getL9x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL9x2(). setText(String.valueOf(val)); else sdkExp16.getL9x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL9x3(). setText(String.valueOf(val)); else sdkExp16.getL9x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL9x4(). setText(String.valueOf(val)); else sdkExp16.getL9x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL9x5(). setText(String.valueOf(val)); else sdkExp16.getL9x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL9x6(). setText(String.valueOf(val)); else sdkExp16.getL9x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL9x7(). setText(String.valueOf(val)); else sdkExp16.getL9x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL9x8(). setText(String.valueOf(val)); else sdkExp16.getL9x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL9x9(). setText(String.valueOf(val)); else sdkExp16.getL9x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL9x10().setText(String.valueOf(val)); else sdkExp16.getL9x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL9x11().setText(String.valueOf(val)); else sdkExp16.getL9x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL9x12().setText(String.valueOf(val)); else sdkExp16.getL9x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL9x13().setText(String.valueOf(val)); else sdkExp16.getL9x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL9x14().setText(String.valueOf(val)); else sdkExp16.getL9x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL9x15().setText(String.valueOf(val)); else sdkExp16.getL9x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL9x16().setText(String.valueOf(val)); else sdkExp16.getL9x16().setText(""); break;
                        }
                        break;
                    }
                    case 9:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL10x1(). setText(String.valueOf(val)); else sdkExp16.getL10x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL10x2(). setText(String.valueOf(val)); else sdkExp16.getL10x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL10x3(). setText(String.valueOf(val)); else sdkExp16.getL10x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL10x4(). setText(String.valueOf(val)); else sdkExp16.getL10x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL10x5(). setText(String.valueOf(val)); else sdkExp16.getL10x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL10x6(). setText(String.valueOf(val)); else sdkExp16.getL10x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL10x7(). setText(String.valueOf(val)); else sdkExp16.getL10x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL10x8(). setText(String.valueOf(val)); else sdkExp16.getL10x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL10x9(). setText(String.valueOf(val)); else sdkExp16.getL10x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL10x10().setText(String.valueOf(val)); else sdkExp16.getL10x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL10x11().setText(String.valueOf(val)); else sdkExp16.getL10x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL10x12().setText(String.valueOf(val)); else sdkExp16.getL10x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL10x13().setText(String.valueOf(val)); else sdkExp16.getL10x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL10x14().setText(String.valueOf(val)); else sdkExp16.getL10x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL10x15().setText(String.valueOf(val)); else sdkExp16.getL10x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL10x16().setText(String.valueOf(val)); else sdkExp16.getL10x16().setText(""); break;
                        }
                        break;
                    }
                    case 10:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL11x1(). setText(String.valueOf(val)); else sdkExp16.getL11x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL11x2(). setText(String.valueOf(val)); else sdkExp16.getL11x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL11x3(). setText(String.valueOf(val)); else sdkExp16.getL11x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL11x4(). setText(String.valueOf(val)); else sdkExp16.getL11x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL11x5(). setText(String.valueOf(val)); else sdkExp16.getL11x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL11x6(). setText(String.valueOf(val)); else sdkExp16.getL11x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL11x7(). setText(String.valueOf(val)); else sdkExp16.getL11x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL11x8(). setText(String.valueOf(val)); else sdkExp16.getL11x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL11x9(). setText(String.valueOf(val)); else sdkExp16.getL11x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL11x10().setText(String.valueOf(val)); else sdkExp16.getL11x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL11x11().setText(String.valueOf(val)); else sdkExp16.getL11x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL11x12().setText(String.valueOf(val)); else sdkExp16.getL11x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL11x13().setText(String.valueOf(val)); else sdkExp16.getL11x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL11x14().setText(String.valueOf(val)); else sdkExp16.getL11x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL11x15().setText(String.valueOf(val)); else sdkExp16.getL11x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL11x16().setText(String.valueOf(val)); else sdkExp16.getL11x16().setText(""); break;
                        }
                        break;
                    }
                    case 11:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL12x1(). setText(String.valueOf(val)); else sdkExp16.getL12x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL12x2(). setText(String.valueOf(val)); else sdkExp16.getL12x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL12x3(). setText(String.valueOf(val)); else sdkExp16.getL12x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL12x4(). setText(String.valueOf(val)); else sdkExp16.getL12x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL12x5(). setText(String.valueOf(val)); else sdkExp16.getL12x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL12x6(). setText(String.valueOf(val)); else sdkExp16.getL12x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL12x7(). setText(String.valueOf(val)); else sdkExp16.getL12x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL12x8(). setText(String.valueOf(val)); else sdkExp16.getL12x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL12x9(). setText(String.valueOf(val)); else sdkExp16.getL12x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL12x10().setText(String.valueOf(val)); else sdkExp16.getL12x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL12x11().setText(String.valueOf(val)); else sdkExp16.getL12x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL12x12().setText(String.valueOf(val)); else sdkExp16.getL12x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL12x13().setText(String.valueOf(val)); else sdkExp16.getL12x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL12x14().setText(String.valueOf(val)); else sdkExp16.getL12x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL12x15().setText(String.valueOf(val)); else sdkExp16.getL12x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL12x16().setText(String.valueOf(val)); else sdkExp16.getL12x16().setText(""); break;
                        }
                        break;
                    }
                    case 12:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL13x1(). setText(String.valueOf(val)); else sdkExp16.getL13x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL13x2(). setText(String.valueOf(val)); else sdkExp16.getL13x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL13x3(). setText(String.valueOf(val)); else sdkExp16.getL13x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL13x4(). setText(String.valueOf(val)); else sdkExp16.getL13x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL13x5(). setText(String.valueOf(val)); else sdkExp16.getL13x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL13x6(). setText(String.valueOf(val)); else sdkExp16.getL13x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL13x7(). setText(String.valueOf(val)); else sdkExp16.getL13x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL13x8(). setText(String.valueOf(val)); else sdkExp16.getL13x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL13x9(). setText(String.valueOf(val)); else sdkExp16.getL13x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL13x10().setText(String.valueOf(val)); else sdkExp16.getL13x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL13x11().setText(String.valueOf(val)); else sdkExp16.getL13x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL13x12().setText(String.valueOf(val)); else sdkExp16.getL13x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL13x13().setText(String.valueOf(val)); else sdkExp16.getL13x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL13x14().setText(String.valueOf(val)); else sdkExp16.getL13x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL13x15().setText(String.valueOf(val)); else sdkExp16.getL13x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL13x16().setText(String.valueOf(val)); else sdkExp16.getL13x16().setText(""); break;
                        }
                        break;
                    }
                    case 13:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL14x1(). setText(String.valueOf(val)); else sdkExp16.getL14x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL14x2(). setText(String.valueOf(val)); else sdkExp16.getL14x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL14x3(). setText(String.valueOf(val)); else sdkExp16.getL14x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL14x4(). setText(String.valueOf(val)); else sdkExp16.getL14x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL14x5(). setText(String.valueOf(val)); else sdkExp16.getL14x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL14x6(). setText(String.valueOf(val)); else sdkExp16.getL14x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL14x7(). setText(String.valueOf(val)); else sdkExp16.getL14x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL14x8(). setText(String.valueOf(val)); else sdkExp16.getL14x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL14x9(). setText(String.valueOf(val)); else sdkExp16.getL14x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL14x10().setText(String.valueOf(val)); else sdkExp16.getL14x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL14x11().setText(String.valueOf(val)); else sdkExp16.getL14x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL14x12().setText(String.valueOf(val)); else sdkExp16.getL14x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL14x13().setText(String.valueOf(val)); else sdkExp16.getL14x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL14x14().setText(String.valueOf(val)); else sdkExp16.getL14x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL14x15().setText(String.valueOf(val)); else sdkExp16.getL14x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL14x16().setText(String.valueOf(val)); else sdkExp16.getL14x16().setText(""); break;
                        }
                        break;
                    }
                    case 14:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL15x1(). setText(String.valueOf(val)); else sdkExp16.getL15x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL15x2(). setText(String.valueOf(val)); else sdkExp16.getL15x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL15x3(). setText(String.valueOf(val)); else sdkExp16.getL15x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL15x4(). setText(String.valueOf(val)); else sdkExp16.getL15x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL15x5(). setText(String.valueOf(val)); else sdkExp16.getL15x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL15x6(). setText(String.valueOf(val)); else sdkExp16.getL15x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL15x7(). setText(String.valueOf(val)); else sdkExp16.getL15x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL15x8(). setText(String.valueOf(val)); else sdkExp16.getL15x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL15x9(). setText(String.valueOf(val)); else sdkExp16.getL15x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL15x10().setText(String.valueOf(val)); else sdkExp16.getL15x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL15x11().setText(String.valueOf(val)); else sdkExp16.getL15x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL15x12().setText(String.valueOf(val)); else sdkExp16.getL15x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL15x13().setText(String.valueOf(val)); else sdkExp16.getL15x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL15x14().setText(String.valueOf(val)); else sdkExp16.getL15x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL15x15().setText(String.valueOf(val)); else sdkExp16.getL15x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL15x16().setText(String.valueOf(val)); else sdkExp16.getL15x16().setText(""); break;
                        }
                        break;
                    }
                    case 15:
                    {
                        switch (y){
                            case 0 : if(val != 0)sdkExp16.getL15x1(). setText(String.valueOf(val)); else sdkExp16.getL15x1(). setText(""); break;
                            case 1 : if(val != 0)sdkExp16.getL15x2(). setText(String.valueOf(val)); else sdkExp16.getL15x2(). setText(""); break;
                            case 2 : if(val != 0)sdkExp16.getL15x3(). setText(String.valueOf(val)); else sdkExp16.getL15x3(). setText(""); break;
                            case 3 : if(val != 0)sdkExp16.getL15x4(). setText(String.valueOf(val)); else sdkExp16.getL15x4(). setText(""); break;
                            case 4 : if(val != 0)sdkExp16.getL15x5(). setText(String.valueOf(val)); else sdkExp16.getL15x5(). setText(""); break;
                            case 5 : if(val != 0)sdkExp16.getL15x6(). setText(String.valueOf(val)); else sdkExp16.getL15x6(). setText(""); break;
                            case 6 : if(val != 0)sdkExp16.getL15x7(). setText(String.valueOf(val)); else sdkExp16.getL15x7(). setText(""); break;
                            case 7 : if(val != 0)sdkExp16.getL15x8(). setText(String.valueOf(val)); else sdkExp16.getL15x8(). setText(""); break;
                            case 8 : if(val != 0)sdkExp16.getL15x9(). setText(String.valueOf(val)); else sdkExp16.getL15x9(). setText(""); break;
                            case 9 : if(val != 0)sdkExp16.getL15x10().setText(String.valueOf(val)); else sdkExp16.getL15x10().setText(""); break;
                            case 10: if(val != 0)sdkExp16.getL15x11().setText(String.valueOf(val)); else sdkExp16.getL15x11().setText(""); break;
                            case 11: if(val != 0)sdkExp16.getL15x12().setText(String.valueOf(val)); else sdkExp16.getL15x12().setText(""); break;
                            case 12: if(val != 0)sdkExp16.getL15x13().setText(String.valueOf(val)); else sdkExp16.getL15x13().setText(""); break;
                            case 13: if(val != 0)sdkExp16.getL15x14().setText(String.valueOf(val)); else sdkExp16.getL15x14().setText(""); break;
                            case 14: if(val != 0)sdkExp16.getL15x15().setText(String.valueOf(val)); else sdkExp16.getL15x15().setText(""); break;
                            case 15: if(val != 0)sdkExp16.getL15x16().setText(String.valueOf(val)); else sdkExp16.getL15x16().setText(""); break;
                        }
                        break;
                    }
                }
            }*/
        }
        
        
        //-----------------------private functions------------------------------
        
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
        
        
        
}
