/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author yannis.hofmann
 */
public class Convert {
    public void umwandeln(int x, int y) throws Exception {
      String filePath = new File("").getAbsolutePath();
      filePath = filePath.concat("/src/control/" + "file.txt");
      Scanner sc = new Scanner(new BufferedReader(new FileReader(filePath)));
      System.out.println("x");
      int rows = x;
      int columns = y;
      int [][] myArray = new int[rows][columns];
      System.out.println("y");
      while(sc.hasNextLine()) {
         for (int i=0; i<9; i++) {
            String[] line = sc.nextLine().trim().split(",");
            for (int j=0; j<9; j++) {
               myArray[i][j] = Integer.parseInt(line[j]);
            }
         }
      }
      System.out.println(Arrays.deepToString(myArray));
    }
    
}

//line.length  
// myArray.length