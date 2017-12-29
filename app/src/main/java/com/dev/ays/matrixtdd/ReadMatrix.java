package com.dev.ays.matrixtdd;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

/**
 * Created by AiYeSus on 12/25/2017.
 */

public class ReadMatrix {
    public int rows = 0;
    public int columns = 0;
    public int [][] matrix = null;

    public String FillMatrix(String filepath) throws Exception {
        String dim = "";
        Scanner instrm = null;
        try {
            File source = new File( filepath );
            instrm = new Scanner(source);
            this.rows = instrm.nextInt();
            this.columns = instrm.nextInt();
            this.matrix = new int[rows][columns];
            for (int r=0; r < rows; r++)
                for (int c=0; c < columns; c++) {
                    matrix[r][c] = instrm.nextInt();
                }
            dim = matrix.length + " " + matrix[0].length;
        } catch (Exception ex) {
            System.out.println("Invalid Matrix");
        } finally {
            if (instrm!=null) instrm.close();
        }
        return dim;
    }
}
