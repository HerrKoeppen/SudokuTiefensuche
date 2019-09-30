/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yannis.hofmann
 */
public class Solver {


    public static void main(String args[]) throws Exception {


        Scanner sc = new Scanner(new BufferedReader(new FileReader("sample.txt")));
        int rows = 4;
        int columns = 4;
        int[][] myArray = new int[rows][columns];
        while (sc.hasNextLine()) {
            String[] items = sc.nextLine().trim().split(",");
            for (int j = 0; j < items.length; j++) {
                myArray[j / 4][j % 4] = Integer.parseInt(items[j]);
            }
        }
        System.out.println(Arrays.deepToString(myArray));
    }
}
