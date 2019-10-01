/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;

/**
 *
 * @author yannis.hofmann
 */
public class main {

    
        private model.Sudoku sudokuleicht;
    
        private Convert c1;
    
    
        public static void main(String[] args) throws Exception {
            int[][] sudokuleicht = new int[9][9];
            Convert c1 = new Convert();
            c1.umwandeln(9,9);
            
        }
        
        
}
