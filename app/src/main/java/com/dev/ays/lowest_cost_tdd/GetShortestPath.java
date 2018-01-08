package com.dev.ays.lowest_cost_tdd;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jihshin on 12/25/2017.
 */

public class GetShortestPath {
    private int[][] matrix;
    private String leastPath;
    private final int MAX_DISTANCE = 50;
    private int Row, Column, leastSum=Integer.MAX_VALUE, numCol=0;
    private boolean LT_MAX_DISTANCE = true;
    String res = "";
    public final String TAG = "LowestCostTest";
    Map<String, Integer> pathMap = new HashMap<>();
    Map<String, Integer> midPath = new HashMap<>();

    public GetShortestPath(int[][] matrix, int matrixRow, int matrixColumn) {
        this.matrix = matrix;
        this.Row = matrixRow;
        this.Column = matrixColumn;
    }

    public String TheShortestPath(int[][] matrix) {
        int mRow = matrix.length;
        int mCol = matrix[0].length;
        GetShortestPath shortestPath = new GetShortestPath(matrix, mRow, mCol);
        return shortestPath.run(mRow);
    }

    private String run(int numOfRow) {
        StringBuilder sbdr = new StringBuilder();
        for(int r = 0; r < numOfRow; r++) {
            res = "";
            int sum = 0;
            leastSumOf(r, 0, res, sum);
            findShortest(pathMap);
            pathMap.clear();
        }
        if ( leastSum < MAX_DISTANCE ) this.res = "YES";
        else {
            this.res = "NO";
            if ( leastPath == null ) {
                leastSum = 0;
            } else {
                shortestMidpath( midPath, numCol );
            }
        }
        sbdr.append(res + ",");
        sbdr.append(leastSum + ",");
        if ( leastPath == null || leastPath.length()==0 ) {
            sbdr.append("[]");
        } else {
            sbdr.append(leastPath);
        }
        return sbdr.toString();
    }

    private void leastSumOf(int row, int col, String path, int cSum) {
        if ( col >= Column-1 || cSum > MAX_DISTANCE ) {
            int[] leastEle = getRowWithLeastElement(row, col);
            // get least one from last column
            path += (leastEle[0]+1);
            cSum += leastEle[1];
            pathMap.put(path, cSum);
            return;
        } else {
            path += (row+1) + " ";
            cSum += matrix[row][col];
            if ( cSum > MAX_DISTANCE ) {
                numCol = path.split(" ").length;
                midPath.put(path, cSum);
                leastPath = path;
                LT_MAX_DISTANCE = false;
                return;
            }
        }
        if ( col+1 == Column-1 ) {
            leastSumOf(getRow(row), col + 1, path, cSum);
        } else {
            if ( Row > 2 ) {
                leastSumOf(getRow(row - 1), col + 1, path, cSum);
                leastSumOf(getRow(row), col + 1, path, cSum);
                leastSumOf(getRow(row + 1), col + 1, path, cSum);
            } else if ( Row == 2 ) {
                leastSumOf(getRow(row), col + 1, path, cSum);
                leastSumOf(getRow(row + 1), col + 1, path, cSum);
            } else {
                leastSumOf(getRow(row), col + 1, path, cSum);
            }
<<<<<<< HEAD:app/src/main/java/com/dev/ays/lowest_cost_tdd/GetShortestPath.java

=======
>>>>>>> 85acc734358f9f9ce5ef016f5775090d9ccf8cfc:app/src/main/java/com/dev/ays/matrixtdd/GetShortestPath.java
        }
    }

    private ArrayList getSortedList(Map<String, Integer> pathMap) {
        // Get entry set from the path map
        Set<Map.Entry<String, Integer>> pathSet = pathMap.entrySet();
        // Create comparator to sort the map acending order
        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                Integer v1 = e1.getValue();
                Integer v2 = e2.getValue();

                if ( v1 < v2 ) return -1;
                else if ( v1 > v2 ) return 1;
                else return 0;
            }
        };
        // Sort method needs a List, so let's first convert Set to List in Java
        ArrayList<Map.Entry<String, Integer>> listOfPath = new ArrayList<Map.Entry<String, Integer>>(pathSet);
        // sorting HashMap by values using ascending order comparator
        Collections.sort(listOfPath, valueComparator);
        return listOfPath;
    }

    private void findShortest(Map<String, Integer> pathMap) {
        ArrayList<Map.Entry<String, Integer>> listOfPath = getSortedList(pathMap);
        if ( listOfPath.size() > 0 && leastSum >= listOfPath.get(0).getValue() ) {
            leastSum = listOfPath.get(0).getValue();
            leastPath = listOfPath.get(0).getKey();
        }
    }

    private void shortestMidpath( Map<String, Integer> pathMap, int nCol ) {
        ArrayList<Map.Entry<String, Integer>> listOfPath = getSortedList(pathMap);
        int entryIndex=0, lr;
        for(int i=0; i < listOfPath.size(); i++) {
            if ( nCol == listOfPath.get(i).getKey().split(" ").length ) {
                entryIndex = i;
                break;
            }
        }
        leastPath = "";
        String[] pathComp = listOfPath.get(entryIndex).getKey().split(" ");
        for(int c=0; c < pathComp.length-1; c++ ) {
            leastPath += pathComp[c] + " ";
        }
        leastPath = leastPath.trim();
        lr = Integer.parseInt( pathComp[pathComp.length-1] );
        leastSum = listOfPath.get(entryIndex).getValue() - matrix[lr-1][nCol-1];
    }

    private int getRow(int currRow) {
        if (currRow < 0) {
            return (Row-1);
        } else if (currRow > Row - 1) {
            return 0;
        } else return currRow;
    }

    private int[] getRowWithLeastElement(int atRow, int Col) {
        int rowA=getRow(atRow-1), rowB=getRow(atRow+1);
        int[] vals = {rowA, matrix[rowA][Col]};
        if (matrix[atRow][Col] < vals[1]) {
            vals[0] = atRow;
            vals[1] = matrix[atRow][Col];
        }
        if (matrix[rowB][Col] < vals[1]) {
            vals[0] = rowB;
            vals[1] = matrix[rowB][Col];
        }
        return vals;
    }
}
