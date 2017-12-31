package com.dev.ays.matrixtdd;

import org.junit.Assert;
import org.junit.Test;
import com.dev.ays.matrixtdd.MatrixOpsActivity;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SanityCheckTest {
    @Test
    public void matrix2x3() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "matrix2x3.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("YES", parts[0]);
        Assert.assertEquals(12, Integer.parseInt(parts[1]));
        Assert.assertEquals("2 2 1", parts[2]);
    }

    /*    @Test
       public void matrix2x20() throws Exception {
           ReadMatrix mat = new ReadMatrix();
           String filepath = "matrix2x20.txt";
           String res = mat.FillMatrix(filepath);
           GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
           res = shortestpath.TheShortestPath(mat.matrix);
           String[] parts = res.split(",");
           int sum = Integer.parseInt(parts[1]);
           System.out.println(res);
           Assert.assertEquals("YES", parts[0]);
           Assert.assertEquals(20, Integer.parseInt(parts[1]));
           Assert.assertEquals("1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1", parts[2]);
       }
       */

    public void matrix1x1() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "matrix1x1.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("YES", parts[0]);
        Assert.assertEquals(4, Integer.parseInt(parts[1]));
        Assert.assertEquals("1", parts[2]);
    }


    @Test
    public void matrix5x1() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "matrix5x1.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("YES", parts[0]);
        Assert.assertEquals(3, Integer.parseInt(parts[1]));
        Assert.assertEquals("4", parts[2]);
    }

    @Test
    public void NoPathLessThan50() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "noPathLessT50.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("NO", parts[0]);
        Assert.assertEquals(48, Integer.parseInt(parts[1]));
        Assert.assertEquals("1 1 1", parts[2]);
    }

    @Test
    public void AllRowsStartGreaterThan50() throws Exception {
        ReadMatrix mat = new ReadMatrix();
        String filepath = "AllRowsStartGT50.txt";
        String res = mat.FillMatrix(filepath);
        GetShortestPath shortestpath = new GetShortestPath(mat.matrix, mat.rows, mat.columns);
        res = shortestpath.TheShortestPath(mat.matrix);
        String[] parts = res.split(",");
        int sum = Integer.parseInt(parts[1]);
        System.out.println(res);
        Assert.assertEquals("NO", parts[0]);
        Assert.assertEquals(0, Integer.parseInt(parts[1]));
        Assert.assertEquals("[]", parts[2]);
    }
}