package com.dev.ays.lowest_cost_tdd;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by AiYeSus on 12/25/2017.
 */

public class ReadMatrix {
    public int rows = 0;
    public int columns = 0;
    public int [][] matrix = null;
    public final String TAG = "LowestCostMatrix";

    public String FillMatrix(InputStream fileinputStream) throws Exception, NumberFormatException, IOException {
        String expResp = "";
        Scanner instrm = null;
        try {
            instrm = new Scanner(fileinputStream);
            this.rows = instrm.nextInt();
            this.columns = instrm.nextInt();
            this.matrix = new int[rows][columns];
            for (int r = 0; r < rows; r++)
                for (int c = 0; c < columns; c++) {
                    matrix[r][c] = instrm.nextInt();
                }

            instrm.nextLine();  // Skip the rest of line
            expResp = instrm.nextLine(); // Read the expected string in next line
        } catch (InputMismatchException numEx ){
             expResp = "Invalid Matrix";
        } finally {
            if (instrm!=null) instrm.close();
        }
        return expResp;
    }

    public String ShowMatrix(InputStream fileinputStream) throws Exception {
        StringBuilder sbd = new StringBuilder();
        try {
            int rows = matrix.length,
                    columns = matrix[0].length;
            sbd.append("\n\n");
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    sbd.append(matrix[r][c] + " ");
                }
                sbd.append("\n");
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return sbd.toString();
    }
}
